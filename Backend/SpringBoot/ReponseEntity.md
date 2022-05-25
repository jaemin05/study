# ReponseEntity

## 📌 정의

+  **결과 데이터와 HTTP 상태 코드를 직접 제어**할 수 있는 클래스이다.

+ **HttpRequest**에 대한 응답 데이터가 포함된다.

+ 좀 더 세밀한 제어가 필요한 경우 사용한다.



## 📑 구조

+ HttpBody: 요청에 대한 내용이 있다.

+ HttpHeaders: 요청이나 응답에 대한 요구사항이 있다. 

  → 웹브라우저가 요청한 값들은 body에 담겨있다.

+ HttpStatus: 상태코드



## 👍 결론

+ 결과값이나 상태코드, 헤더값들을 모두 프론트한테 넘겨줄 수 있다.
+ **에러코드를 섬세**하게 보내줄 수 있다.



## 🎉 예제

```java
@ExceptionHandler(CustomException.class)
public ResponseEntity<ErrorResponse> handleCustomException(CustomException customException) {

    ErrorCode errorCode = customException.getErrorCode();

    return new ResponseEntity<>(
            ErrorResponse.builder()
                    .status(errorCode.getStatus())
                    .code(errorCode.getCode())
                    .message(errorCode.getMessage())
                    .build(),
            HttpStatus.valueOf(errorCode.getStatus()));
}
```



