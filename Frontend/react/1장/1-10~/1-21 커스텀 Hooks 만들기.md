# 1-21 커스텀 Hooks 만들기

## 1️⃣커스텀 Hooks란

+ 반복되는 로직이나 코드를 쉽게 재사용할 수 있도록 해준다.
+ 커스텀 hooks를 만들 때는 보통 use라는 키워드로 시작되는 파일을 만들고 그 안에 함수를 작성한다.



## 2️⃣만드는 법

+ 안에 useState, useEffect, useReducer, useCallback과 같이 Hooks를 사용해 원하는 기능을 구현하고 컴포넌트에서 사용하고 싶은 값을 반환한다.

```javascript
import { useState, useCallback } from 'react';

function useInputs(initialForm) {
  const [form, setForm] = useState(initialForm);
  
  const onChange = useCallback(e => {
    const { name, value } = e.target;
    setForm(form => ({ ...form, [name]: value }));
  }, []);
    
  const reset = useCallback(() => setForm(initialForm), [initialForm]);
  return [form, onChange, reset];
}

export default useInputs;
```

+ useReducer 쪽에서 사용하는 inputs을 없애고 useInputs로 대체해야 한다.
+ 새로운 항목을 추가 할 때 input값을 초기화해야 해서 데이터 등록 후 reset()을 호출한다.

```javascript
function App() {
  const [{ username, email }, onChange, reset] = useInputs({
    username: '',
    email: ''
  });
  const [state, dispatch] = useReducer(reducer, initialState);
  const nextId = useRef(4);

  const { users } = state;

  const onCreate = useCallback(() => {
    dispatch({
      type: 'CREATE_USER',
      user: {
        id: nextId.current,
        username,
        email
      }
    });
    reset();
    nextId.current += 1;
  }, [username, email, reset]);
```

