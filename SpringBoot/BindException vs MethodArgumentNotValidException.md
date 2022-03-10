## BindException vs MethodArgumentNotValidException

### ⚡ 차이점

+ BindException은 **매개변수 없이 사용하는 경우** 개체가 **유효성 검사에 실패하면** 유효성 검사에 MethodArgumentNotValidException 대신 BindException이 발생합니다.
+ MethodArgumentNotValidException은 @RequestBody로 받은 받은 파라미터를 처리한다. 

---

### 📑 결론

+ BindException이 MethodArgumentNotValidException보다 큰 개념이다. 

