# 세션 기반 인증 시스템

## 📌정의

**서버 측에서 사용자들의 정보를 기억**하고 있어야 한다. **사용자들의 정보를 기억하기 위해서는 세션을 유지 해야 한다.** 

클라이언트로부터 요청을 받으면, 클**라이언트의 상태를 계속해서 유지**하고 이 정보를 서비스에 이용하는데, 이러한 서버를 **Sateful 서버**라고 한다. 

![https://blog.kakaocdn.net/dn/be5HFu/btqAsR8iEdh/rk9Xno6XlQAwbTWFiGIXIk/img.png](https://blog.kakaocdn.net/dn/be5HFu/btqAsR8iEdh/rk9Xno6XlQAwbTWFiGIXIk/img.png)

## 👎단점

**정보를 저장할 때, DB에 무리를 줄 수 있다.**

**확장하기 어렵다.**
