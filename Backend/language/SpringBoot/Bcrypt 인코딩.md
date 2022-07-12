# Bcrypt 인코딩

## 📌 정의

+ **Bcrypt**는 조정할 수 있는 **해시알고리즘**을 써서 비밀번호를 저장한다.

+ **Bcrypt**는 패스워드를 해싱할 때 내부적으로 **랜덤한 솔트를** 생성하기 때문에 같은 문자열을 **다른 인코드된 결과를 반환**해준다.

  

## 📏 Column 길이

```java
 @Column(length = 60, nullable = false)
    private String password;
```

+ 인코딩할 때마다 **길이가 60인 String**을 만든다.



## 📑 결과

![image-20220422090708481](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220422090708481.png)

