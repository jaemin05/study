# 1-16 useEffect를 사용하여 마운트/언마운트/업데이트시 할 작업 설정하기

## 📌정의

**마운트**

+ 처음 나타났을 때를 의미한다.

**언마운트**

+ 사라질 때를 의미한다.



## 1️⃣예제

```javascript
 useEffect(() => {
    console.log('UP');
    return () => {
      console.log('DOWN');
    };
  }, []);
```

+ useEffect를 사용할 때는 첫번째 파라미터로는 함수, 두번째 파라미터로는 의존값이 들어있는 배열(deps)을 넣는다. 
+ deps 배열을 비우면, 컴포넌트가 처음 나타날 때만 useEffect에 등록한 함수가 호출된다.

**cleanup 함수**

+ useEffect에서 함수를 반환하는 것을 의미한다.
+ deps가 비어있으면 컴포넌트가 사라질 때 호출된다.



## 2️⃣마운트 & 언마운트 시에 하는 작업

**마운트**

+ props로 받은 값을 컴포넌트의 로컬 상태로 설정할 때
+ 외부 API 요청할 때 (REST API 등)
+ 라이브러리 사용할 때 (D3, Video.js 등)
+ setInterval을 통한 반복작업 혹은 setTimeout을 통한 작업 예약할 때

**언마운트**

+ setInterval, setTimeout을 사용해 등록한 작업 clear 할 때 (clearInterval, clearTimeout)
+ 라이브러리 인스턴스를 제거할 때



## 3️⃣deps에 특정 값 넣기

+ deps에 특정 값을 넣으면 컴포넌트가 처음 마운트가 될 때 호출되고, 지정한 값이 바뀔 때도 호출이 된다.
+ deps 안에 특정 값이 있으면 언마운트시에도 호출되고, 값이 바뀌기 직전에도 호출이 된다.

```javascript
useEffect(() => {
    console.log('user 값이 설정됨');
    console.log(user);
    return () => {
      console.log('user 가 바뀌기 전..');
      console.log(user);
    };
  }, [user]);
```

+ useEffect안에서 사용하는 상태나 props가 있다면, useEffect의 deps에 넣어줘야 한다.



## 4️⃣deps 파라미터를 생략하기

```javascript
useEffect(() => {
    console.log(user);
  });
```



## 5️⃣ 참고

+ 리액트 컴포넌트는 바뀐 내용이 없어도 부모컴포넌트가 리렌더링되면 자식 컴포넌트 또한 리렌더링이 된다.
+ 실제 DOM 에 변화가 반영되는 것은 바뀐 내용이 있는 컴포넌트에만 해당한다.
+ Virtual DOM 에는 모든걸 다 렌더링하고 있다.