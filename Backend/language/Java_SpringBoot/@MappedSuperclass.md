# @MappedSuperclass

## 📌 사용 이유

+ **객체 입장**에서 **공통 매핑 정보가 필요할 때 사용**한다.

![image-20220313220230463](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220313220230463.png)

## 📑 사용 방법

```java
@Getter
@MappedSuperclass
public abstract class BaseEntity {
    
    @CreateDate
    private LocalDateTime createdDate;
}
```

+ **abstract**는 **자식 클래스에서 오버라이딩**해야만 사용할 수 있다. 

  

## ⚠ 주의사항

+ **DB는 매핑 정보를 다 따로 쓰고** 있다.

![image-20220313220602546](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220313220602546.png)

