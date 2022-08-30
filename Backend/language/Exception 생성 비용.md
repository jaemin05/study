# Exception 생성 비용

## 🎊 배경  

예외를 적절하게 쓰면 비지니스 명확성을 높여준다.

그래서 각 서비스 성격에 맞게 Custom Exception 클래스를 만들어서 사용한다.

스프링의 경우 Exception을 던지면 전역적으로 잡아주는 **@ControllerAdvice**가 있다.



## 💡 문제

예외의 발생 경로 trace가 성능에 영향을 미친다.

비즈니스 로직이 커지면 예외 케이스가 많이지는데 그때 발생하는 예외 생성 비용이 비싸다.



## ♻️ 해결

**fillInStackTrace** method를 오버라이드하면 가능하다.

+ 현재 값이 어떤 call stack을 가지는지에 대한 trace는 필요하지 않다.
+ exception stack trace는 **Throwable.fillInStackTrace** 메소드를 통해 생성된다.
+ 이를 아무런 trace도 가지지 않게 Override해둘 수 있습니다.

> 10 stack depth에 4000 nano second정도인데 fillInStackTrace() 메서드를 Override하여 이 작업을 건너뛰면 80 nano second



**java**

```java
@Override 
public synchronized Throwable fillInStackTrace() {
  return this;
}
```

**kotlin**

```kotlin
override fun fillInStackTrace(): Throwable {
    return this
}
```

