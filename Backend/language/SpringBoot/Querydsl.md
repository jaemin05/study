# Querydsl 

## ๐ ์ ์

+ **์ฟผ๋ฆฌ๋ฅผ ์๋ฐ์ฝ๋๋ก ์์ฑ**ํ  ์ ์๋๋ก ๋์์ค๋ค.

## ๐ ์ค์ 

+ build.gradle์ Querydsl ๊ด๋ จ dependencies๋ฅผ ์ถ๊ฐํด ์ค๋ค.

```java
implementation 'com.querydsl:querydsl-jpa'
annotationProcessor "com.querydsl:querydslapt:${dependencyManagement.importedProperties['querydsl.version']}:jpa"
annotationProcessor 'jakarta.persistence:jakarta.persistence-api'
```

+ Querydsl ์ฌ์ฉ์ ์ํด **Config ์ค์ **์ ํด์ค์ผํ๋ค. jpaQueryFactory ๋น์ **repository์์ ์ฌ์ฉํ๋ค.**

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

## ๐ ์ฌ์ฉ ๋ฐฉ๋ฒ

+ Querydsl๋ก ์์ฑํ  ์ฟผ๋ฆฌ๋ **'~RepositoryCustom'์๋ค๊ฐ ์๊ทธ๋์ฒ๋ฅผ ์ ์**ํ๋ค.

  ```java
  public interface NoticeRepositoryCustom {
  	List<NoticeResponse> findByPageQuerydsl(Integer page);
  }
  ```

+ **๊ตฌํ์ฒด์ ์ด๋ฆ**์ **'~RepositoryImpl'**์ด๋ค.

  ```java
  public class NoticeRepositoryCustomImpl implements NoticeRepositoryCustom {
      
  	private final JPAQueryFactory queryFactory;
      
      @Override
      public List<NoticeResponse> findByPage(Integer page) {
      }
  }
  ```

---

## โ  ์ฃผ์์ฌํญ

+ ์ปค์คํํ repository๋ **๋ค์ด๋ฐ ๊ท์ฝ์ ์ง์ผ์ผ์ง ์คํ๋ง์ด ์ฐพ์ ์ ์๋ค.**