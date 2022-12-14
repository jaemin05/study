# @NotNull vs nullable = false

## 📑 차이점

### @NotNull

+ **유효성검사를 해주기** 때문에 **비어있는 값**이 들어오면 안된다고 **에러**가 나온다.
+ **DB에 자동**으로 not null 제약 조건을 걸어준다. 

### nullable = false

+ DB에서 명시적으로 not null 제약 조건을 걸어준다. (유효성 검사 X)

---

## 📑 결론

+ @NotNull을 사용하면 제약조건 설정과 유효성 검사를 같이해준다. 
+ 조금 더 안전하다.

