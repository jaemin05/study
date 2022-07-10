# 1-20 useReducer를 사용해 상태 업데이트 로직 분리하기

## 1️⃣useReducer 이해하기

+ 컴포넌트의 상태 업데이트 로직을 컴포넌트에서 분리할 수 있다.
+ 다른 파일에 작성하고 불러와서 사용할 수도 있다.



## 2️⃣reducer란

+ reducer는 현재 상태와 액션 객체를 파라미터로 받아서 새로운 상태로 반환해주는 함수이다.

```javascript
function reducer(state, action) {
  // const nextState = ...
  return nextState;
}
```

### action

+ action은 업데이트를 위한 정보를 가지고 있다.

**액션 예시**

```javascript
// 카운터에 1을 더하는 액션
{
  type: 'INCREMENT'
}
// input 값을 바꾸는 액션
{
  type: 'CHANGE_INPUT',
  key: 'name',
  value: 'Arthur'
}
// 새 할 일을 등록하는 액션
{
  type: 'ADD_TODO',
  todo: {
    id: 1,
    text: 'Study React',
  }
}
```



## 3️⃣useReducer

```js
const [state, dispatch] = useReducer(reducer, initialState);
```

+ state는 앞으로 컴포넌트에서 사용할 수 있는 상태를 가르킨다.
+ dispatch는 액션을 발생시키는 함수이다. ← 사용법: `dispatch({ type: 'INCREMENT' })` 
+ useReducer에 넣는 첫번째 파라미터가 reducer함수이다.
+ 두번째 파라미터는 초기 상태이다.

```js
function reducer(state, action) {
  switch (action.type) {
    case 'CHANGE_INPUT':
      return {
        ...state,
        input: {
          ...state.input,
          [action.name]: action.value
        }
      };
  }
}
```

```js
const onCreate = useCallback(() => {
    dispatch({
      type: 'CREATE_USER',
      user: {
        id:nextId.current,
        accountId,
        password
      }
    });
    nextId.current += 1;
  }, [accountId, password]);
```



## 4️⃣useReducer vs useState

+ 컴포넌트에서 관리하는 값이 하나이거나 그 값이 단순한 숫자, 문자열, boolean 값이라면 useState로 관리하는 것이 편할 것이다.