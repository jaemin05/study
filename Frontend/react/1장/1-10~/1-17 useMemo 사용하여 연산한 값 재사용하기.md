# 1-17 useMemo 사용하여 연산한 값 재사용하기

## 1️⃣예제

```javascript
function countActiveUsers(users) {
  console.log('활성 사용자 수를 세는중...');
  return users.filter(user => user.active).length;
}

const count = useMemo(() => countActiveUsers(users), [users]);
```

+ useMemo의 첫번째 파라미터에는 어떻게 연산할지 정의하는 함수를 넣어준다.
+ 두번째 파라미터에는 deps 배열을 넣어준다.
+ deps 배열 안에 넣은 내용이 바뀌면, 등록한 함수를 호출해 값을 연산한다.
+ 내용이 바뀌지 않으면 이전에 연산한 값을 재사용한다.