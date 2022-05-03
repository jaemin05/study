# 어댑터 (Adapter)

## 📌 정의

+ 관계가 없는 인터페이스들이 **연계되서 사용**될 수 있도록 도와준다.
+ **상속을 받아서 사용**할 수 있고, **직접 인스턴스를 선언**해서 사용할 수 있다. (주로 상속을 사용한다.)

```java
public interface Service {
    public void signup();
    public void login();
}
```

+ interface를 추가로 생성한다.