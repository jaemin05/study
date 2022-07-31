# 4-3 useAsync 커스텀 Hook 만들어서 사용하기

## 1️⃣ 커스텀 Hook 을 만들기

### useAsync.js

```javascript
 function reducer(state, action) {
  switch (action.type) {
    case 'LOADING':
      return {
        loading: true,
        data: null,
        error: null
      };
    case 'SUCCESS':
      return {
        loading: false,
        data: action.data,
        error: null
      };
    case 'ERROR':
      return {
        loading: false,
        data: null,
        error: action.error
      };
    default:
      throw new Error(`Unhandled action type: ${action.type}`);
  }
}

function useAsync(callback, deps = []) {
  const [state, dispatch] = useReducer(reducer, {
    loading: false,
    data: null,
    error: false
  });

  const fetchData = async () => {
    dispatch({ type: 'LOADING' });
    try {
      const data = await callback();
      dispatch({ type: 'SUCCESS', data });
    } catch (e) {
      dispatch({ type: 'ERROR', error: e });
    }
  };

  useEffect(() => {
    fetchData();
  }, deps);

  return [state, fetchData];
}
```

+ `useAsync` 함수는 두가지 파라미터를 받아온다.
  + 첫번째 파라미터는 API 요청을 시작하는 함수이다.
  + 두번째 파라미터는 deps이다. (`deps` 값은 해당 함수 안에서 사용하는 `useEffect` 의 `deps` 로 설정된다.)
+ 이 Hook 에서 반환하는 값은 요청 관련 상태와, `fetchData` 이다.
+ `fetchData` 함수를 반환해 나중에 데이터를 쉽게 리로딩을 해줄 수 있다.



### Users.js

```javascript
async function getUsers() {
  const response = await axios.get(
    'https://jsonplaceholder.typicode.com/users'
  );
  return response.data;
}

function Users() {
  const [state, refetch] = useAsync(getUsers, []);
  const { loading, data: users, error } = state;
    
  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return null;
  return (
    <>
      <ul>
        {users.map(user => (
          <li key={user.id}>
            {user.username} ({user.name})
          </li>
        ))}
      </ul>
      <button onClick={refetch}>다시 불러오기</button>
    </>
  );
}
```

## 2️⃣데이터 나중에 불러오기

(특정 버튼을 눌렀을 때만 API를 요청하고 싶을 때)



### useAsync.js

```javascript
function useAsync(callback, deps = [], skip = false) {
  const [state, dispatch] = useReducer(reducer, {
    loading: false,
    data: null,
    error: false
  });

  const fetchData = async () => {
    dispatch({ type: 'LOADING' });
    try {
      const data = await callback();
      dispatch({ type: 'SUCCESS', data });
    } catch (e) {
      dispatch({ type: 'ERROR', error: e });
    }
  };

  useEffect(() => {
    if (skip) return;
    fetchData();
  }, deps);

  return [state, fetchData];
}
```

+ 세번째 파라미터로 skip을 넣었다.
+ `skip` 파라미터의 기본 값을 `false` 로 지정하고, 만약 이 값이 `true` 라면 `useEffect` 에서 아무런 작업도 하지 않도록 설정했다.



### Users.js

```javascript
function Users() {
  const [state, refetch] = useAsync(getUsers, [], true);
  const { loading, data: users, error } = state;
    
  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return <button onClick={refetch}>불러오기</button>;
  return (
    <>
      <ul>
        {users.map(user => (
          <li key={user.id}>
            {user.username} ({user.name})
          </li>
        ))}
      </ul>
      <button onClick={refetch}>다시 불러오기</button>
    </>
  );
}
```



## 3️⃣API 에 파라미터가 필요한 경우



### User.js

```javascript
async function getUser(id) {
  const response = await axios.get(
    `https://jsonplaceholder.typicode.com/users/${id}`
  );
  return response.data;
}

function User({ id }) {
  const [state] = useAsync(() => getUser(id), [id]);
  const { loading, data: user, error } = state;

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
```

+ `useAsync` 를 사용 할 때, 파라미터를 포함시켜서 함수를 호출하는 새로운 함수를 만들어서 등록해준다.
+ `id` 가 바뀔 때 마다 재호출 되도록 `deps` 에 `id` 를 넣어준다.
+ 리스트에 있는 항목을 클릭하면 클릭한 사용자의 `id` 를 `userId` 값으로 설정한다.



### Users.js

```javascript
function Users() {
  const [userId, setUserId] = useState(null);
  const [state, refetch] = useAsync(getUsers, [], true);

  const { loading, data: users, error } = state; // state.data 를 users 키워드로 조회

  if (loading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return <button onClick={refetch}>불러오기</button>;
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
      <button onClick={refetch}>다시 불러오기</button>
      {userId && <User id={userId} />}
    </>
  );
}
```