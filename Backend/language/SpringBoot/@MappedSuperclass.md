# @MappedSuperclass

## π μ¬μ© μ΄μ 

+ **κ°μ²΄ μμ₯**μμ **κ³΅ν΅ λ§€ν μ λ³΄κ° νμν  λ μ¬μ©**νλ€.

![image-20220313220230463](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220313220230463.png)

## π μ¬μ© λ°©λ²

```java
@Getter
@MappedSuperclass
public abstract class BaseEntity {
    
    @CreateDate
    private LocalDateTime createdDate;
}
```

+ **abstract**λ **μμ ν΄λμ€μμ μ€λ²λΌμ΄λ©**ν΄μΌλ§ μ¬μ©ν  μ μλ€. 

  

## β  μ£Όμμ¬ν­

+ **DBλ λ§€ν μ λ³΄λ₯Ό λ€ λ°λ‘ μ°κ³ ** μλ€.

![image-20220313220602546](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220313220602546.png)

