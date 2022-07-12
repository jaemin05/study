# @PostConstruct, @PreDestroy

## 📌 정의

### @PostConstruct

+ **의존성 주입**이 이루어지고 **초기화를 수행**하는 메소드이다.
+ **service(로직)**을 **수행하기 전**에 발생한다.

### @PreDestroy

+ **마지막 소멸 단계**이다.
+ **bean을 제거**하지 전에 해야할 **작업**이 있을 때 사용한다.

## 👍 장점

+ **bean**이 **생성될 때 한 번**만 초기화한다.
+ bean이 **초기화**될 때, **의존성을 확인**할 수 있다. 
  + 생성자가 호출 되었을 때, bean은 초기화 되지 않는다. 

```java
@PostConstruct
public void init(){
    System.out.println("초기화");
}

@PreDestroy
public void destroy(){
    System.out.println("종료 전");       
}
```







