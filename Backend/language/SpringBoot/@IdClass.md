# @IdClass

## 📑 사용하는 이유

+ DB에 **PK값을 여러 개 사용**하고 싶을 때 사용한다.

## 📑 사용 방법

```java
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(TestId.class)
@Entity
public class Test {
    
    @Id
    @Column(name = "notification_id")
    private Notification notification;

    @Id
    @Column(name = "user_id")
    private User user;
}
```

+ PK에 모두 **@Id**를 붙여줘야 한다.
+ **@IdClass(클래스 이름 + Id.class)** 어노테이션을 추가해준다.
  + '클래스 이름 + Id' 라는 클래스를 만들어줘야한다.