# 파이프(PIPE)

## 📌정의

**어떤 프로그램의 결과값을 다른 프로그램의 입력값**으로 사용하는 것이다.

## 📑사용

```
echo "foo bar baz" | wc -w
```

![https://media.vlpt.us/images/goban/post/d4b6fc1f-3b5d-424c-aab9-b87554a37b4b/image.png](https://media.vlpt.us/images/goban/post/d4b6fc1f-3b5d-424c-aab9-b87554a37b4b/image.png)

wc: 문자열의 문자수를 세는 명령어

`|`가 파이프를 뜻한다. echo 출력값을 wc의 입력값으로 사용했다.
