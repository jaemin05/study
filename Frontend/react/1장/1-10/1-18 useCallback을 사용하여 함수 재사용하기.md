# 1-18 useCallback을 사용하여 함수 재사용하기

## 1️⃣상태 혹은 props가 있을 경우

```js
const onChange = useCallback(
     e => {
      const {name, value} = e.target;
      setInput({
        ...input,
        [name]: value
      });
    },
    [input]
  );
```

+ 함수 안에서 사용하는 상태나 props가 있으면 deps 배열 안에 포함시켜야 한다.
+ 만약 넣지 않는다면, 함수 내에서 해당 값들을 참조할때 가장 최신 값을 참조한다고 보장 할 수 없다.
+ props로 받아온 값도 deps에 넣어줘야 한다.



## 2️⃣상태 혹은 props가 없을 경우

```js
const onCreate = useCallback(() => {
    const user = {
      id: nextId.current,
      accountId,
      password
    };

    setUser(users.concat(user));

    setInput({
      accountId:'',
      password: ''
    });
    nextId.current += 1;
  });
```

