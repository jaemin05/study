# @IdClass

## π μ¬μ©νλ μ΄μ 

+ DBμ **PKκ°μ μ¬λ¬ κ° μ¬μ©**νκ³  μΆμ λ μ¬μ©νλ€.

## π μ¬μ© λ°©λ²

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

+ PKμ λͺ¨λ **@Id**λ₯Ό λΆμ¬μ€μΌ νλ€.
+ **@IdClass(ν΄λμ€ μ΄λ¦ + Id.class)** μ΄λΈνμ΄μμ μΆκ°ν΄μ€λ€.
  + 'ν΄λμ€ μ΄λ¦ + Id' λΌλ ν΄λμ€λ₯Ό λ§λ€μ΄μ€μΌνλ€.