# 1-10 useRef 로 특정 DOM 선택하기

## 1️⃣ 이론

+ JS에서, 특정 DOM 을 선택해야 하는 상황에 `getElementById`, `querySelector` 같은 DOM Selector 함수를 사용한다.

+ 리액트에서는 `ref` 라는 것을 사용합니다.
+ 함수형 컴포넌트에서 `ref` 를 사용 할 때에는 `useRef` 라는 Hook 함수를 사용한다.
+ 클래스형 컴포넌트에서는 콜백 함수를 사용하거나 `React.createRef` 라는 함수를 사용한다.



## 2️⃣ 예제

```javascript
import React, {useRef, useState} from "react";

function InputSample() {

    const [input, setInput] = useState({
        name: '',
        age: 0
    });

    const nameInput = useRef();

    const {name, age} = input;

    const onChange = (e) => {
        const {value, name} = e.target;
        setInput({
            ...input,
            [name]: value
        });
    };
    //여기서 사용한 ... 문법은 spread 문법입니다. 객체의 내용을 모두 "펼쳐서" 기존 객체를 복사해주는데요.

    const onReset = () => {
        setInput({
            name: '',
            age: 0,
        });
        nameInput.current.focus();
    };

    return (
        <div>
            <input name="name" placeholder="input your name" onChange={onChange} value={name} ref={nameInput}/>
            <input name="age" placeholder="input your age" onChange={onChange} value={age}/>
            <button onClick={onReset}>RESET</button>
            <div>
                <p><b>VAULE</b></p>
                name: {name} age: {age}
            </div>
        </div>
    );
}

export default InputSample;
```

+ `useRef()` 를 사용하여 Ref 객체를 만들고, 이 객체를 우리가 선택하고 싶은 DOM 에 `ref` 값으로 설정해줘야 한다.
+ Ref 객체의 `.current` 값은 해당하는 DOM 을 가르킨다. 
