# Meta Annotation

## 📌 정의

+ meta-annotation은 **다른 annotation에서도 사용되는 annotation**의 경우를 말한다.
+ **annotation을 선언할 때 사용하는 annotation**이다.
+ @Controller는 @Component을 내포하고 있는데, 여기서 @Component가 meta-annotation입니다.



## @Target

+ Java compiler가 annotation이 어디에 적용될지 결정하려고 사용한다.
+ @Service의 `ElementType.TYPE` 은 해당 annotation은 타입 선언시 사용한다는 의미이다.

``` java
ElementType.PACKAGE : 패키지 선언
ElementType.TYPE : 타입 선언
ElementType.ANNOTATION_TYPE : 어노테이션 타입 선언
ElementType.CONSTRUCTOR : 생성자 선언
ElementType.FIELD : 멤버 변수 선언
ElementType.LOCAL_VARIABLE : 지역 변수 선언
ElementType.METHOD : 메서드 선언
ElementType.PARAMETER : 전달인자 선언
ElementType.TYPE_PARAMETER : 전달인자 타입 선언
ElementType.TYPE_USE : 타입 선언
```



## @Retention

+ annotation이 실제로 적용되고 유지되는 범위를 말한다.

```java
RetentionPolicy.RUNTIME : 컴파일 이후에도 JVM에 의해 계속 참조가 가능하다.(리플렉션, 로깅에 주로 사용)
RetentionPolicy.CLASS : 컴파일러가 클래스를 참조할 때까지 유효하다.
RetentionPolicy.SOURCE : 컴파일 전까지 유효하다.
```

