# Meta Annotation

## ๐ ์ ์

+ meta-annotation์ **๋ค๋ฅธ annotation์์๋ ์ฌ์ฉ๋๋ annotation**์ ๊ฒฝ์ฐ๋ฅผ ๋งํ๋ค.
+ **annotation์ ์ ์ธํ  ๋ ์ฌ์ฉํ๋ annotation**์ด๋ค.
+ @Controller๋ @Component์ ๋ดํฌํ๊ณ  ์๋๋ฐ, ์ฌ๊ธฐ์ @Component๊ฐ meta-annotation์๋๋ค.



## @Target

+ Java compiler๊ฐ annotation์ด ์ด๋์ ์ ์ฉ๋ ์ง ๊ฒฐ์ ํ๋ ค๊ณ  ์ฌ์ฉํ๋ค.
+ @Service์ `ElementType.TYPE` ์ ํด๋น annotation์ ํ์ ์ ์ธ์ ์ฌ์ฉํ๋ค๋ ์๋ฏธ์ด๋ค.

``` java
ElementType.PACKAGE : ํจํค์ง ์ ์ธ
ElementType.TYPE : ํ์ ์ ์ธ
ElementType.ANNOTATION_TYPE : ์ด๋ธํ์ด์ ํ์ ์ ์ธ
ElementType.CONSTRUCTOR : ์์ฑ์ ์ ์ธ
ElementType.FIELD : ๋ฉค๋ฒ ๋ณ์ ์ ์ธ
ElementType.LOCAL_VARIABLE : ์ง์ญ ๋ณ์ ์ ์ธ
ElementType.METHOD : ๋ฉ์๋ ์ ์ธ
ElementType.PARAMETER : ์ ๋ฌ์ธ์ ์ ์ธ
ElementType.TYPE_PARAMETER : ์ ๋ฌ์ธ์ ํ์ ์ ์ธ
ElementType.TYPE_USE : ํ์ ์ ์ธ
```



## @Retention

+ annotation์ด ์ค์ ๋ก ์ ์ฉ๋๊ณ  ์ ์ง๋๋ ๋ฒ์๋ฅผ ๋งํ๋ค.

```java
RetentionPolicy.RUNTIME : ์ปดํ์ผ ์ดํ์๋ JVM์ ์ํด ๊ณ์ ์ฐธ์กฐ๊ฐ ๊ฐ๋ฅํ๋ค.(๋ฆฌํ๋ ์, ๋ก๊น์ ์ฃผ๋ก ์ฌ์ฉ)
RetentionPolicy.CLASS : ์ปดํ์ผ๋ฌ๊ฐ ํด๋์ค๋ฅผ ์ฐธ์กฐํ  ๋๊น์ง ์ ํจํ๋ค.
RetentionPolicy.SOURCE : ์ปดํ์ผ ์ ๊น์ง ์ ํจํ๋ค.
```

