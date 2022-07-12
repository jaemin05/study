# SOP, CORS, CSP 



## 📌 정의

### SOP (Same Origin Policy)

+ **다른 기원에서 온 자원을 제한**하는 정책이다. 

+ 동일한 프로토콜, 호스트, 포트만 리소스를 공유 가능하다.



### CORS (Cross Origin Resource Sharing)

+ SOP 제약사항을 완화해준다. **다른 Origin이여도 리소스를 공유**할 수 있도록 해준다. 
+ 추가 HTTP 헤더를 사용해, 한 출처에서 실행 중인 웹 애플리케이션이 다른 출처의 선택한 자원에 접근할 수 있는 권한을 부여하도록 브라우저에 알려주는 체제이다. 
+ Access-Control-Allow-Origin 헤더에 알맞은 값을 세팅하면 해결할 수 있다. (하나만 가능, 여러개는  *)



### CSP (Content Security Policy)

+ 주로 XSS나 Data Injection, Click Jacking 등 웹 페이지에 악성 스크립트를 삽입하는 공격을 막기 위함이다.
+ **특정 리소스가 어디서 왔는지 검사하고 검토**한다.
+ 'Content-Security-Policy: '를 헤더에 추가한다. 



**Content-Security-Policy: (Directive Refrence) (Source List Refence)**



+ **Directive Refrence**
  - **default-src**: 만약 다른 CSP들이 걸려 있지 않다면 Default로 설정되는 CSP다.  다양한 값들을 관리한다.
  - **style-src**: Stylesheet가 명시된 주소에서 왔는지 검사한다.
  - **img-src**: 이미지가 명시된 주소에서 왔는지 검사한다.
+ **Source List Refrence**
  - **none**: 어디든 source를 가지고 오지 않는다. 
  - **self**: 같은 기원에서만 가져온다.





