# 1-9 Input 상태 관리하기

## 1️⃣ input이 여러개 있을때

+ 단순히 `useState` 를 여러번 사용하고 `onChange` 도 여러개 만들어서 구현 할 수 있다. ← 가장 좋은 방법은 아니다. 
+ 더 좋은 방법은, input 에 `name` 을 설정하고 이벤트가 발생했을 때 이 값을 참조하는 것이다.
+ 그리고, `useState` 에서는 문자열이 아니라 객체 형태의 상태를 관리해줘야 한다.

```javascript
import React, { useState } from 'react';

function InputSample() {
  const [inputs, setInputs] = useState({
    name: '',
    age: 0
  });

  const { name, age } = inputs; // 비구조화 할당을 통해 값 추출

  const onChange = (e) => {
    const { value, name } = e.target; // 우선 e.target 에서 name 과 value 를 추출
    setInputs({
      ...inputs, // 기존의 input 객체를 복사한 뒤
      [name]: value // name 키를 가진 값을 value 로 설정
    });
  };

  const onReset = () => {
    setInputs({
      name: '',
      age: 0,
    })
  };


  return (
    <div>
      <input name="name" placeholder="write your name" onChange={onChange} value={name} />
      <input name="age" placeholder="write your age" onChange={onChange} value={age}/>
      <button onClick={onReset}>RESET</button>
      <div>
        <b>VALUE: </b>
        name: {name}, age: {age}세
      </div>
    </div>
  );
}

export default InputSample;
```

## 2️⃣리액트 상태에서 객체를 수정해야 할 때

```javascript
setInputs({
  ...inputs,
  [name]: value
});
```

+ 새로운 객체를 만들어서 새로운 객체에 변화를 주고, 이를 상태로 사용해줘야 한다.

> 여기서 사용한 `...` 문법은 spread 문법이다.
>
> 객체의 내용을 모두 "펼쳐서" 기존 객체를 복사해준다.

+ 이러한 작업을, "불변성을 지킨다" 라고 부른다.
+ 불변성을 지켜줘야 리액트 컴포넌트에서 상태가 업데이트를 감지 할 수 있고 필요한 리렌더링이 진행된다.

```javascript
inputs[name] = value;
```

+ 만약 이런식으로 수정하게 되면 값을 바꿔도 리렌더링이 되지 않는다

+ 리액트에서 객체를 업데이트할 때는 기존 객체를 직접 수정하면 안되고, **새로운 객체를 만들어서 새 객체에 변화를 줘야 한다.**

