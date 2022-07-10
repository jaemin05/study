# 1-22 Context API를 사용한 전역 값 관리

## 1️⃣ 사용 이유 & 정의

+ 특정 함수를 특정 컴포넌트를 거쳐서 원하는 컴포넌트에게 전달하는 작업은 번거롭다.
+ Context API를 사용하면, 프로젝트 안에서 전역적으로 사용할 수 있는 값을 관리 할 수 있다.



## 2️⃣사용법

```javascript
const UserDispatch = React.createContext(null);
```

+ createContext의 파라미터에는 Context의 기본값을 설정할 수 있다. 



+ Context를 만들면, Context 안에 Provier라는 컴포넌트가 들어있다. 이 컴포넌트를 통해 Context의 값을 정할 수 있다.

```javascript
<UserDispatch.Provider value={dispatch}>...</UserDispatch.Provider>
```

+ Provider에 의해 감싸진 컴포넌트 중 어디서든지 Context 값을 다른 곳에서 조회할 수 있다.



```javascript
export const UserDispatch = React.createContext(null);
```

+ 나중에 사용하고 싶을 때 불러와서 사용할 수있다.

**호출하는 코드**

```javascript
import { UserDispatch } from './App';
```



## 3️⃣예제

```javascript
import React, { useContext, useEffect } from "react";
import { UserDispatch } from "./App";

const User = React.memo(function({user, onRemove, onToggle}) {
    const dispatch = useContext(UserDispatch);

    return (
            <p>
                <b style={{
                    cursor: 'pointer',
                    color: user.active ? 'red' : 'black'
                }} 
                onClick={() =>
                    dispatch({type: 'TOGGLE_USER', id:user.id})
                }>
                {user.accountId}
                </b>
                ❤️
                <b style={{
                    cursor: 'pointer',
                    color: user.active ? 'red' : "black"
                }}
                onClick={() =>
                    dispatch({type: 'TOGGLE_USER', id:user.id})
                }>
                    {user.password}
                </b>
                <button onClick={() => {
                    dispatch({type: 'REMOVE_USER', id:user.id});
                }}>REMOVE</button>
            </p>
    );
});

function UserList ({users}) {
    return (
        <div>
            {users.map(user => (
                <User user={user} key={user.id} />
            ))} 
        </div>
    );
}

export default React.memo(UserList);
```



## 4️⃣장점

+ Context API를 사용하면 dispatch를 어디서든지 조회해서 사용할 수 있다. ← 코드 구조가 깔끔해진다.