# Token

## 📌Access Token

보호된 리소스에 접근할 때, **권한 확인용**으로 사용된다. 

계정 아이디, 비밀번호 등 인증에 필요한 형태들을 토큰 하나로 표현함으로써 권한을 확인할 수 있다.

## 📌Refresh Token

**한번 발급된 Access Token은 사용할 수 있는 시간이 제한** 되어있다. **만료되면 새로운 액세스 토큰이 필요한데 그때** 사용된다.

Refresh Token을 미리 가지고 있을 수 있다.

권한 서버에서만 활용되고, 리소스 서버에는 전송되지 않는다.

## 📄토큰 갱신 과정

클라이언트가 서버에 Token을 요청하면 Access Token과 Refresh Token을 클라이언트에 알려준다. 

Access Token 이 만료되면 오류를 응답한다. 

Refresh Token을 권한 서버에 보내 새로운 액세스 토큰을 요청한다. 

Refresh Token도 새로 발급 될 수 있다.
