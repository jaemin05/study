# 1-19 React.memo 를 사용한 컴포넌트 리렌더링 방지

## 1️⃣React.memo 적용

```js
const UserList = ({users, onRemove, onToggle}) => {
    return (
        <div>
            {users.map(user => (
                <User user={user} key={user.id} onRemove={onRemove} onToggle={onToggle} />
            ))}
        </div>
    );
}
```

```js
const User = React.memo(function({user, onRemove, onToggle}) {
    useEffect(() => {
        console.log('값이 설정됨');
        console.log(user);
        return () => {
          console.log('바뀌기 전..');
          console.log(user);
        };
    }, [user]);

    return (
            <p>
                <b style={{cursor: 'pointer', color: user.active ? 'red' : 'black'}} onClick={() => onToggle(user.id)}>{user.accountId}</b>
                ❤️
                <b style={{cursor: 'pointer', color: user.active ? 'red' : "black"}} onClick={() => onToggle(user.id)}>{user.password}</b>
                <button onClick={() => onRemove(user.id)}>REMOVE</button>
            </p>
    );
});
```

+ input을 수정 할 때 리렌더링이 되지 않는 것을 확인할 수 있다.



## 2️⃣해당 항목만 리렌더링 하는 법

+ 함수형 업데이트를 사용하면 콜백함수의 파라미터에서 최신 값을 참조할 수 있다.

```js
const onChange = useCallback(e => {
      const {name, value} = e.target;
      setInput(input => ({
        ...input,
        [name]: value
      }));
    }, []);
```

```js
  const onCreate = useCallback(() => {
    const user = {
      id: nextId.current,
      accountId,
      password
    };

    setUser(users => users.concat(user));

    setInput({
      accountId:'',
      password: ''
    });
    nextId.current += 1;
  }, [accountId, password]);
```



## 3️⃣주의

+ 잘못사용할 경우 의도치 않은 버그가 발생할 수 있다.
  + b, button, onClick 으로 설정해준 함수들은 useCallback으로 재사용한다고 해서 리렌더링을 막을 수 있는 것이 아니다.