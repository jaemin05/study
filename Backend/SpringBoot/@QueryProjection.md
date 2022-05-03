# @QueryProjection

## 📌 사용 이유

+ **dto 생성자에** @QueryProjection을 붙이고 compileQuerydsl을 하면 **Q파일이 생성**된다.
+ Q파일 안에는 **@QueryProjection이 붙어있는 생성자에 한해서** 동일한 **생성자가 만들어진다.**

```java
public class userDto {
    private final String name;
    private final int age;

    @QueryProjection
    public userDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## 👍 장점

+ Q파일에 만들어져 있는 생성자를 조회하면 되서 **코드가 깔끔**하다.
+ 오류를 런타임이 아니라 **컴파일 타임에서 잡을 수 있다.**

## 👎 단점 

+ 지나치게 **Querydsl에 의존적**이다.
+ dto 파일까지 Q-Type을 생성해야한다.