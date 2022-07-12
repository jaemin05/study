# 직렬화(Serializable)

## 📌 정의

+ 자바 시스템 내부에서 **객체나 데이터**들을 **외부의 자바 시스템에서도 사용**할 수 있도록**바이트(byte) 형태**로 데이터 변환하는 기술이다. 

+ **역직렬화**: 바이트로 변환된 데이터를 **다시 객체로 변환**한다.

  

## ⚡ 예제 코드

```java
import java.io.Serializable;

public class NotificationListId implements Serializable {

    private Long notification;
    private Long user;
}
```



## ❓ 사용하는 이유

+ **데이터를 외부 서버로 전송**하기 위해서이다. 
+ JVM의 메모리에서만 상주되어있는 객체 데이터를 그대로 **영속화**가 필요할 때 사용된다.
+ **객체를 DB에 저장**하거나 **파일로 저장한 객체를 전송**할 때 데이터를 바이트 단위로 보내야한다. 
+ 다른 서버에서 객체를 받아올 때 **역직렬화**가 필요하다.