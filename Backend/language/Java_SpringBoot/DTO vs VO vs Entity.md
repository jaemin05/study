# DTO vs VO vs Entity

<br>

## 📌 정의

+ DTO (Data Transfer Object)

> 쿼리 결과값을 리턴받을 때, 프로젝트 때마다 통신시 보내줄 때 사용한다.
> 계층간 데이터 교환을 위한 객체이다.

+ VO(Value Object)

>  클래스 맴버변수들의 값 그 자체를 가진다.

+ Entity

> DB 테이블 그 자체이다.



<br>

## 📑 DTO, Entity를 분리하는 이유

+ DB 레이어, 비즈니스 레이어, 프론트 레이어 의 레이어 아키텍쳐 구성에서 분리하기 위함이다.
+ **DTO**는 클라이언트가 던진 데이터에 따라 받기 때문에 **Data들이 자주 변경될 수 있다. **
+ **Entity**는 Domain Model 객체로 영속성만을 위해서 사용된다. 
  + DB 클래스 칼럼 그 자체로 변경되지 않고 사용해야 한다. ← Setter를 사용하지 않는 이유 



