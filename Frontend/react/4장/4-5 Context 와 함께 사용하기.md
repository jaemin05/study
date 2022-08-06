# 4-5 Context 와 함께 사용하기

## 1️⃣사용이유

+ 컴포넌트에서 필요한 외부 데이터들은 컴포넌트 내부에서 `useAsync` 같은 Hook 을 사용해서 작업을 하면 충분하지만, 가끔 특정 데이터들은 다양한 컴포넌트에서 필요하게 될 때도 있는데 그럴 때에는 Context 를 사용하면 개발이 편하다.
+ (예: 현재 로그인된 사용자의 정보, 설정 등)



## 2️⃣ Context 예제

### UsersContext.js

```javascript
import React, { createContext, useReducer, useContext } from 'react';

const initialState = {
  users: {
    loading: false,
    data: null,
    error: null
  },
  user: {
    loading: false,
    data: null,
    error: null
  }
};

const loadingState = {
  loading: true,
  data: null,
  error: null
};

const success = data => ({
  loading: false,
  data,
  error: null
});

const error = error => ({
  loading: false,
  data: null,
  error: error
});

function usersReducer(state, action) {
  switch (action.type) {
    case 'GET_USERS':
      return {
        ...state,
        users: loadingState
      };
    case 'GET_USERS_SUCCESS':
      return {
        ...state,
        users: success(action.data)
      };
    case 'GET_USERS_ERROR':
      return {
        ...state,
        users: error(action.error)
      };
    case 'GET_USER':
      return {
        ...state,
        user: loadingState
      };
    case 'GET_USER_SUCCESS':
      return {
        ...state,
        user: success(action.data)
      };
    case 'GET_USER_ERROR':
      return {
        ...state,
        user: error(action.error)
      };
    default:
      throw new Error(`Unhanded action type: ${action.type}`);
  }
}

const UsersStateContext = createContext(null);
const UsersDispatchContext = createContext(null);

export function UsersProvider({ children }) {
  const [state, dispatch] = useReducer(usersReducer, initialState);
  return (
    <UsersStateContext.Provider value={state}>
      <UsersDispatchContext.Provider value={dispatch}>
        {children}
      </UsersDispatchContext.Provider>
    </UsersStateContext.Provider>
  );
}

export function useUsersState() {
  const state = useContext(UsersStateContext);
  if (!state) {
    throw new Error('Cannot find UsersProvider');
  }
  return state;
}

export function useUsersDispatch() {
  const dispatch = useContext(UsersDispatchContext);
  if (!dispatch) {
    throw new Error('Cannot find UsersProvider');
  }
  return dispatch;
}

export async function getUsers(dispatch) {
  dispatch({ type: 'GET_USERS' });
  try {
    const response = await axios.get(
      'https://jsonplaceholder.typicode.com/users'
    );
    dispatch({ type: 'GET_USERS_SUCCESS', data: response.data });
  } catch (e) {
    dispatch({ type: 'GET_USERS_ERROR', error: e });
  }
}

export async function getUser(dispatch, id) {
  dispatch({ type: 'GET_USER' });
  try {
    const response = await axios.get(
      `https://jsonplaceholder.typicode.com/users/${id}`
    );
    dispatch({ type: 'GET_USER_SUCCESS', data: response.data });
  } catch (e) {
    dispatch({ type: 'GET_USER_ERROR', error: e });
  }
}
```



### Users.js

```javascript
import React, { useState } from 'react';
import { useUsersState, useUsersDispatch, getUsers } from './UsersContext';
import User from './User';

function Users() {
  const [userId, setUserId] = useState(null);
  const state = useUsersState();
  const dispatch = useUsersDispatch();

  const { data: users, loading, error } = state.users;
  const fetchData = () => {
    getUsers(dispatch);
  };

  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return <button onClick={fetchData}>불러오기</button>;

  return (
    <>
      <ul>
        {users.map(user => (
          <li
            key={user.id}
            onClick={() => setUserId(user.id)}
            style={{ cursor: 'pointer' }}
          >
            {user.username} ({user.name})
          </li>
        ))}
      </ul>
      <button onClick={fetchData}>다시 불러오기</button>
      {userId && <User id={userId} />}
    </>
  );
}

export default Users;
```



### User.js

```javascript
import React, { useEffect } from 'react';
import { useUsersState, useUsersDispatch, getUser } from './UsersContext';

function User({ id }) {
  const state = useUsersState();
  const dispatch = useUsersDispatch();
  useEffect(() => {
    getUser(dispatch, id);
  }, [dispatch, id]);

  const { data: user, loading, error } = state.user;

  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!user) return null;
  return (
    <div>
      <h2>{user.username}</h2>
      <p>
        <b>Email:</b> {user.email}
      </p>
    </div>
  );
}

export default User;
```



## 3️⃣반복되는 코드 줄이기

+ 반복되는 로직들을 함수화하여 재활용하기

#### 반복된 코드

```javascript
export async function getUsers(dispatch) {
  dispatch({ type: 'GET_USERS' });
  try {
    const response = await axios.get(
      'https://jsonplaceholder.typicode.com/users'
    );
    dispatch({ type: 'GET_USERS_SUCCESS', data: response.data });
  } catch (e) {
    dispatch({ type: 'GET_USERS_ERROR', error: e });
  }
}

export async function getUser(dispatch, id) {
  dispatch({ type: 'GET_USER' });
  try {
    const response = await axios.get(
      `https://jsonplaceholder.typicode.com/users/${id}`
    );
    dispatch({ type: 'GET_USER_SUCCESS', data: response.data });
  } catch (e) {
    dispatch({ type: 'GET_USER_ERROR', error: e });
  }
}
```

  

### api.js

```javascript
import axios from 'axios';

export async function getUsers() {
  const response = await axios.get(
    'https://jsonplaceholder.typicode.com/users'
  );
  return response.data;
}

export async function getUser(id) {
  const response = await axios.get(
    `https://jsonplaceholder.typicode.com/users/${id}`
  );
  return response.data;
}
```



### asyncActionUtils.js

```javascript
export default function createAsyncDispatcher(type, promiseFn) {
  const SUCCESS = `${type}_SUCCESS`;
  const ERROR = `${type}_ERROR`;
  
  async function actionHandler(dispatch, ...rest) {
    dispatch({ type }); 
    try {
      const data = await promiseFn(...rest); 
      dispatch({
        type: SUCCESS,
        data
      }); 
    } catch (e) {
      dispatch({
        type: ERROR,
        error: e
      }); 
    }
  }

  return actionHandler; 
}
```



### UsersContext.js

```javascript
import React, { createContext, useReducer, useContext } from 'react';
import createAsyncDispatcher from './createAsyncDispatcher';
import * as api from './api'; 

(...)

export const getUsers = createAsyncDispatcher('GET_USERS', api.getUsers);
export const getUser = createAsyncDispatcher('GET_USER', api.getUser);
```



## 4️⃣리듀서 코드 리팩토링

### asyncActionUtils.js

```javascript
export function createAsyncDispatcher(type, promiseFn) {

(...)

export const initialAsyncState = {
  loading: false,
  data: null,
  error: null
};

const loadingState = {
  loading: true,
  data: null,
  error: null
};

const success = data => ({
  loading: false,
  data,
  error: null
});

const error = error => ({
  loading: false,
  data: null,
  error: error
});

export function createAsyncHandler(type, key) {
  const SUCCESS = `${type}_SUCCESS`;
  const ERROR = `${type}_ERROR`;

  function handler(state, action) {
    switch (action.type) {
      case type:
        return {
          ...state,
          [key]: loadingState
        };
      case SUCCESS:
        return {
          ...state,
          [key]: success(action.data)
        };
      case ERROR:
        return {
          ...state,
          [key]: error(action.error)
        };
      default:
        return state;
    }
  }

  return handler;
}
```



### UsersContext.js

```javascript
import React, { createContext, useReducer, useContext } from 'react';
import { createAsyncDispatcher, createAsyncHandler, initialAsyncState } from './asyncActionUtils';
import * as api from './api'; 

const initialState = {
  users: initialAsyncState,
  user: initialAsyncState
};

const usersHandler = createAsyncHandler('GET_USERS', 'users');
const userHandler = createAsyncHandler('GET_USER', 'user');

function usersReducer(state, action) {
  switch (action.type) {
    case 'GET_USERS':
    case 'GET_USERS_SUCCESS':
    case 'GET_USERS_ERROR':
      return usersHandler(state, action);
    case 'GET_USER':
    case 'GET_USER_SUCCESS':
    case 'GET_USER_ERROR':
      return userHandler(state, action);
    default:
      throw new Error(`Unhanded action type: ${action.type}`);
  }
}

(...)
```

+ 각 요청에 대하여 3가지 (시작, 성공, 실패) 액션을 처리하는 함수를 만들었다.
+ 자주 사용되는 코드를 함수화해서 재사용하시면 좋다.