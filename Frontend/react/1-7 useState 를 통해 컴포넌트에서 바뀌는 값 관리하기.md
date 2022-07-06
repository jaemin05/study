# 1-7 useState 를 통해 컴포넌트에서 바뀌는 값 관리하기

## 1️⃣ 이론

+ 리액트 16.8 에서 Hooks 라는 기능이 도입되면서 함수형 컴포넌트에서도 상태를 관리할 수 있게 되었다.



## 2️⃣ 동적인 값 끼얹기, useState

```javascript
import React, { useState } from 'react';

function Counter() {
  const [number, setNumber] = useState(0);

  const onIncrease = () => {
    setNumber(number + 1);
  }

  const onDecrease = () => {
    setNumber(number - 1);
  }

  return (
    <div>
      <h1>{number}</h1>
      <button onClick={onIncrease}>+1</button>
      <button onClick={onDecrease}>-1</button>
    </div>
  );
}

export default Counter;
```

```javascript
import React, { useState } from 'react';
```

+ 이 코드는 리액트 패키지에서 `useState` 라는 함수를 불러와준다.

```javascript
const [number, setNumber] = useState(0);
```

+ `useState` 를 사용 할 때에는 상태의 기본값을 파라미터로 넣어서 호출해준다.
+ 이 함수를 호출하면 배열이 반환되는데, 여기서 첫번째 원소는 현재 상태, 두번째 원소는 Setter 함수이다.

```javascript
const numberState = useState(0);
const number = numberState[0];
const setNumber = numberState[1];
```

+ 원래는 이렇게 해야하지만 배열 비구조화 할당을 통해 각 원소를 추출했다.

```javascript
    <h1>{number}</h1>
```

+ Setter 함수를 이용해서 파라미터로 받은 값을 최신 상태로 설정한다.

![image-20220706134638997](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220706134638997.png)



## 3️⃣ 함수형 업데이트

```javascript
function Counter() {
  const [number, setNumber] = useState(0);

  const onIncrease = () => {
    setNumber(prevNumber => prevNumber + 1);
  }

  const onDecrease = () => {
    setNumber(prevNumber => prevNumber - 1);
  }

```

+ `onIncrease` 와 `onDecrease` 에서 `setNumber` 를 사용 할 때 그 다음 상태를 파라미터로 넣어준것이 아니라, 값을 업데이트 하는 함수를 파라미터로 넣어준다.
+ 함수형 업데이트는 주로 컴포넌트를 최적화를 하게 될 때 사용한다.