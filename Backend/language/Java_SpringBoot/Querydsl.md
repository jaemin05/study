# Querydsl 

## 📌 정의

+ **쿼리를 자바코드로 작성**할 수 있도록 도와준다.

## 📑 설정

+ build.gradle에 Querydsl 관련 dependencies를 추가해 준다.

```java
implementation 'com.querydsl:querydsl-jpa'
annotationProcessor "com.querydsl:querydslapt:${dependencyManagement.importedProperties['querydsl.version']}:jpa"
annotationProcessor 'jakarta.persistence:jakarta.persistence-api'
```

+ Querydsl 사용을 위해 **Config 설정**을 해줘야한다. jpaQueryFactory 빈을 **repository에서 사용한다.**

```java
@Configuration
public class QuerydslConfig {
	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}
}
```

## 📑 사용 방법

+ Querydsl로 작성할 쿼리는 **'~RepositoryCustom'에다가 시그니처를 정의**한다.

  ```java
  public interface NoticeRepositoryCustom {
  	List<NoticeResponse> findByPageQuerydsl(Integer page);
  }
  ```

+ **구현체의 이름**은 **'~RepositoryImpl'**이다.

  ```java
  public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {
      
  	private final JPAQueryFactory queryFactory;
      
      @Override
      public List<NoticeResponse> findByPage(Integer page) {
      }
  }
  ```

---

## ⚠ 주의사항

+ 커스텀한 repository는 **네이밍 규약을 지켜야지 스프링이 찾을 수 있다.**