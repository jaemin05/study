## **📌정의**

텍스트 기반의 통신 규약으로 **인터넷에서 데이터를 주고받을 수 있는 프로토콜**이다. 이렇게 규약을 정해두었기 때문에 모든 프로그램이 이 규약에 맞춰 개발해서 서로 정보를 교환할 수 있게 되었다.

## **📌HTTP 동작**

**클라이언트** 즉, **사용자**가 브라우저를 통해서 어떠한 서비스를 url을 통하거나 다른 것을 통해서 **요청(request)**을 하면 **서버**에서는 해당 요청사항에 맞는 결과를 찾아서 사용자에게 **응답(response)**하는 형태로 동작한다.

- **요청 : client -> server**
- **응답 : server -> client**

보통은 클라이언트가 정보를 **HTML 형태로 받고 싶은지, JSON 형태**로 받고 싶은지 명시해주는 경우가 대부분이다.

## **📌HTTP 특징**

**HTTP 메시지**는 HTTP 서버와 HTTP 클라이언트에 의해 해석이 된다.

**TCP/ IP를 이용하는 응용 프로토콜**이다.

HTTP는 연결 상태를 유지하지 않는 **비연결성 프로토콜**이다. (이러한 단점을 해결하기 위해 Cookie와 Session이 등장하였다.)

HTTP는 연결을 유지하지 않는 프로토콜이기 때문에 **요청/응답 방식**으로 동작한다.

![https://media.vlpt.us/post-images/surim014/e0aa5520-2d59-11ea-86da-fb3b00230640/image.png](https://media.vlpt.us/post-images/surim014/e0aa5520-2d59-11ea-86da-fb3b00230640/image.png)

---

클라이언트 프로그램에서 사용자가 회원가입을 시도하게 되면, 서버로 회원정보를 보내게 되고 서버는 회원 정보를 저장해주기도 한다. 이 과정에서 **클라이언트와 서버 간의 교류가 HTTP라는 규약을 이용하여 발생하게 된다.**
