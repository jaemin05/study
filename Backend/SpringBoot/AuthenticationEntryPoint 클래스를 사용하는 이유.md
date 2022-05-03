# AuthenticationEntryPoint 클래스를 사용하는 이유

+ Response에서 **특정 Status (401, 403,  · · ·)이 떨어질만한 에러가 발생하면** 해당 로직을 타고 **commence라는 메소드가 실행**하게 된다.

## 📑 사용방법

+ **objectMapper를 이용해서 고정적으로** response body에 담아준다.

+ Spring boot Security 컨텍스트 내에서 관리해야 하므로 **@Comment로 빈이 되어야한다.**

+ Security Config에 추가해야 한다.

  ```java
   .exceptionHandling()
       .authenticationEntryPoint(authenticationEntryPoint)
       .and()
  ```

+ Response 헤더를 수정해야하기 때문에 contentType과 status를 수정해야 한다.

  ```java
  response.setStatus(errorCode.getStatus());
  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
  ```

  + ContentType이란 **보내는 자원의 형식**을 명시하기 위해서이다.