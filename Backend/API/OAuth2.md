# OAuth2.0

## 📌정의

**다양한 플랫폼 환경**에서 **권한 부여**를 위한 **산업 표준 프로토콜**이다.

## 📄인증 과정

![https://developers.payco.com/static/img/@img_guide2.jpg](https://developers.payco.com/static/img/@img_guide2.jpg)

## 📄인증 종류

**Authorization Code Grant**

서버사이드 코드로 인증하는 방식이다.

로그인시 페이지 URL에 response_type = code라고 넘긴다.

**Implicit Grant**

권한코드 없이 바로 발급된다.

주로 Read only인 서비스에서 사용된다.

로그인시 페이지 URL에 response_type = token이라고 넘긴다.

**Password Credentials Grant**

Client에 아이디,패스워드를 저장해 놓고 아이디,패스워드로 직접 access token을 받아오는 방식이다.

로그인시 API에 POST로 grant_type = password 라고 넘긴다.

**Client Credentials Grant**

어플리케이션이 Confidential Client일 때 id 와 secret을 가지고 인증하는 방식이다.

로그인시 API에 POST로 grant_type = client_credentials 라고 넘긴다.
