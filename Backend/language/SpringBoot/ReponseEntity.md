# ReponseEntity

## π μ μ

+  **κ²°κ³Ό λ°μ΄ν°μ HTTP μν μ½λλ₯Ό μ§μ  μ μ΄**ν  μ μλ ν΄λμ€μ΄λ€.

+ **HttpRequest**μ λν μλ΅ λ°μ΄ν°κ° ν¬ν¨λλ€.

+ μ’ λ μΈλ°ν μ μ΄κ° νμν κ²½μ° μ¬μ©νλ€.



## π κ΅¬μ‘°

+ HttpBody: μμ²­μ λν λ΄μ©μ΄ μλ€.

+ HttpHeaders: μμ²­μ΄λ μλ΅μ λν μκ΅¬μ¬ν­μ΄ μλ€. 

  β μΉλΈλΌμ°μ κ° μμ²­ν κ°λ€μ bodyμ λ΄κ²¨μλ€.

+ HttpStatus: μνμ½λ



## π κ²°λ‘ 

+ κ²°κ³Όκ°μ΄λ μνμ½λ, ν€λκ°λ€μ λͺ¨λ νλ‘ νΈνν λκ²¨μ€ μ μλ€.
+ **μλ¬μ½λλ₯Ό μ¬μΈ**νκ² λ³΄λ΄μ€ μ μλ€.



## π μμ 

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



