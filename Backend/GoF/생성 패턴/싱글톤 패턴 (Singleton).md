# 싱글톤 패턴 (Singleton)

## 📌 정의

+ **인스턴스를 하나만 만들어 **사용하기 위한 패턴이다.

+ 생성자 호출이 반복적으로 이뤄져도 실제로 생성되는 객체는 **최초 생성된 객체를 반환한다.**

  ```java
  public class Food {
      //Instance
      private static Fruit apple = new Fruit();
  
      //private construct
  	private Fruit() {}
      
      public static Fruit getApple() {
          return apple;
      }
  }
  ```

**👎 단점**

+ 객체의 역할이 복잡하면 **객체 간의 결합도가 높아져서** 객체 지향 설계 원칙에 어긋나게 된다.
+ 멀티 쓰레드 환경에서 동기화 문제가 있을 수 있다.

