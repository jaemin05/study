# 4-4 react-async 로 요청 상태 관리하기

## 1️⃣설정

+ react-async는 useAsync 와 비슷한 함수가 들어있는 라이브러리이다.
+ (이 라이브러리 안에 들어있는 함수 이름도 useAsync 이지만 사용법이 조금 다르다.)



**설치**

```bash
$ yarn add react-async
```



**공식 사용법**

[react-async](https://github.com/ghengeveld/react-async)

```javascript
import { useAsync } from "react-async"

const loadCustomer = async ({ customerId }, { signal }) => {
  const res = await fetch(`/api/customers/${customerId}`, { signal })
  if (!res.ok) throw new Error(res)
  return res.json()
}

const MyComponent = () => {
  const { data, error, isLoading } = useAsync({ promiseFn: loadCustomer, customerId: 1 })
  if (isLoading) return "Loading..."
  if (error) return `Something went wrong: ${error.message}`
  if (data)
    return (
      <div>
        <strong>Loaded some data:</strong>
        <pre>{JSON.stringify(data, null, 2)}</pre>
      </div>
    )
  return null
}
```

+ react-async 의 `useAsync` 를 사용 할 때 파라미터로 넣는 옵션 객체에는 호출 할 함수 `promiseFn` 을 넣고, 파라미터도 필드 이름과 함께 (`customerId`) 넣어줘야 한다.

  

## 2️⃣사용 예시 (렌더링 시점)

```javascript
import React from 'react';
import axios from 'axios';
import { useAsync } from 'react-async';

async function getUser({ id }) {
  const response = await axios.get(
    `https://jsonplaceholder.typicode.com/users/${id}`
  );
  return response.data;
}

function User({ id }) { //useAsync를 사용할 때는 프로미스를 반환하는 함수의 파라미터를 객체형태로 해주어야 합니다.
  const { data: user, error, isLoading } = useAsync({
    promiseFn: getUser,
    id,
    watch: id
  });

  if (isLoading) return <div>로딩중..</div>;
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

+ `useAsync` 를 사용 할 때 `watch` 값에 특정 값을 넣어주면 이 값이 바뀔 때마다 `promiseFn` 에 넣은 함수를 다시 호출해줍니다.

## 3️⃣사용 예시 (특정 인터랙션)

+ `promiseFn` →`deferFn` 
+ `reload` → `run` 

```javascript
import React, { useState } from 'react';
import axios from 'axios';
import { useAsync } from 'react-async';
import User from './User';

async function getUsers() {
  const response = await axios.get(
    'https://jsonplaceholder.typicode.com/users'
  );
  return response.data;
}

function Users() {
  const [userId, setUserId] = useState(null);
  const { data: users, error, isLoading, run } = useAsync({
    deferFn: getUsers
  });

  if (isLoading) return <div>로딩중..</div>;
  if (error) return <div>에러가 발생했습니다</div>;
  if (!users) return <button onClick={run}>불러오기</button>;

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
      <button onClick={run}>다시 불러오기</button>
      {userId && <User id={userId} />}
    </>
  );
}

export default Users;
```



## 4️⃣정리

+ 직접 요청 상태 관리를 위한 커스텀 Hook 을 만들기 귀찮을 때 사용하면 된다.