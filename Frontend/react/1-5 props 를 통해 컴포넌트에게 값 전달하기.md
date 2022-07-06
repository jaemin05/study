# 1-5 props를 통해 컴포넌트에게 값 전달하기

> props 는 properties 의 줄임말입니다.



## 1️⃣ props 의 기본 사용법

### App.js

```javascript
import React from 'react';
import Hello from './Hello';

function App() {
  return (
    <Hello name="react" />
  );
}

export default App;
```



### Hello.js

```javascript
import React from 'react';

function Hello(props) {
  return <div>안녕하세요 {props.name}</div>
}

export default Hello;
```

+ 컴포넌트에게 전달되는 props 는 파라미터를 통하여 조회 할 수 있다.
+ props 는 객체 형태로 전달된다.



## 2️⃣ 여러개의 props 사용법

### APP.js

```javascript
import React from 'react';
import Hello from './Hello';

function App() {
  return (
    <Hello name="react" color="red"/>
  );
}

export default App;
```

```javascript
import React from 'react';

function Hello({ color, name }) {
  return <div style={{ color }}>안녕하세요 {name}</div>
}

export default Hello;
```



## 3️⃣ defaultProps 로 기본값 설정

```javascript
import React from 'react';

function Hello({ color, name }) {
  return <div style={{ color }}>안녕하세요 {name}</div>
}

Hello.defaultProps = {
  name: '알 수 없음',
  color: 'black'
}

export default Hello;
```

```javascript
import React from 'react';
import Hello from './Hello';

function App() {
  return (
    <>
      <Hello name="son" color="red"/>
      <Hello />
    </>
  );
}

export default App;
```



## 4️⃣ props.children

+ 컴포넌트 태그 사이에 넣은 값을 조회하고 싶을 땐, `props.children` 을 조회하면 된다.



### Wrapper.js

```javascript
import React from 'react';

function Wrapper({ children }) {
  const style = {
    border: '2px solid black',
    padding: '16px',
  };
  return (
    <div style={style}>
      {children}
    </div>
  )
}

export default Wrapper;
```