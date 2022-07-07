# JSX

## 📌 정의

+ 리액트에서 생김새를 정의할 때, 사용하는 문법이다.
+ HTML 같이 생겼지만 실제로는 **JavaScript이다.**

```js
return <div>JSX입니다.</div>;
```



## ⚠️ 규칙

> **태그는 닫혀야 한다.**

![image-20220705232600732](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220705232600732.png)

+ HTML 에서는 `input` 또는 `br` 태그를 사용 할 때 닫지 않고 사용하기도 한다. 
+ 리액트에서는 하면 안된다.



> **꼭 감싸져야하는 태그**

```js
function App() {
  return (
    <div>
      <Hello />
      <div>안녕하십니까</div>
    </div>
  );
}
```

+ 위 코드를 밑에 있는 코드처럼 바꿔야한다.

```javascript
function App() {
  return (
    <>
      <Hello />
      <div>안녕하십니까</div>
    </>
  );
}
```

+ 감싸기 위해 불필요한 <div> 태그를 사용한다. → **복잡해진다.**

```js
function App() {
  return (
    <>
      <Hello />
      <div>안녕하십니까</div>
    </>
  );
}
```

+ **Fragment**를 사용하면 위의 문제를 해결할 수있다.
+  Fragment 는 브라우저에서 별도의 엘리먼트로 나타나지 않는다.



## ⚡ JS 값 사용

+ JSX 내부에 JS 변수를 보여줄 때는 `{}` 을 이용한다.

```js
 <div>{name}</div>
```



### style 과 className

+ JSX 에서 태그에 `style` 과 CSS class 를 설정하는 방법은 **HTML 에서 설정하는 방법과 다르다.**
+ 인라인 스타일은 **객체 형태**로 작성을 해야 한다.
+  **camelCase 형태**로 네이밍 해줘야 한다.

```js
 const style = {
    backgroundColor: 'white',
    color: 'red',
    fontSize: 24, // 기본 단위 px
    padding: '1rem' // 다른 단위 사용 시 문자열로 설정
  }
```

+  CSS class 를 설정 할 때에는  `className=` 으로 설정해야 한다.



## ⚒️ 주석

```js
 {/* 주석 */} 
```

+ 중괄호로 감싸야한다.