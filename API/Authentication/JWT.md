# JWT(JSON Web Token)

## 📌정의

웹표준(RFC 7519)로서 **두 객체에서 JSON 객체를 사용**하여 **가볍고 자가수용적인 방식으로 정보를 안정성있게 전달해준다.**

## 👍장점

**수많은 프로그래밍 언어가 지원된다.**

**자가 수용적이다.**

**→ 필요한 모든 것 자체적으로 가지고 있다.**

**쉽게 전달 될 수 있다.**

## 📄사용하는 경우

**회원 인증**

**정보 교류**

## 📄생김새

![https://velopert.com/wp-content/uploads/2016/12/jwt.png](https://velopert.com/wp-content/uploads/2016/12/jwt.png)

JWT는  `.` 을 구분자로 **3가지 문자열**로 되어있다. 

![https://velopert.com/wp-content/uploads/2016/12/Untitled-4.png](https://velopert.com/wp-content/uploads/2016/12/Untitled-4.png)

**Signature Verified 가 뜨면 토큰이 검증되었다는 것을 의미한다.**

---

**typ: 토큰 타입**

**alg: 해싱 알고리즘, 보통 HMAC SHA256 혹은 RSA가 사용된다.**

**iss: 토큰 발급자**

**sub: 토큰 제목**

**aud: 토큰 대상자**

**exp: 토큰 만료일**

**nbf: 토큰 활성 날짜**

**iat: 토큰 발급된 시간**
