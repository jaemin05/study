# @QueryProjection

## ๐ ์ฌ์ฉ ์ด์ 

+ **dto ์์ฑ์์** @QueryProjection์ ๋ถ์ด๊ณ  compileQuerydsl์ ํ๋ฉด **Qํ์ผ์ด ์์ฑ**๋๋ค.
+ Qํ์ผ ์์๋ **@QueryProjection์ด ๋ถ์ด์๋ ์์ฑ์์ ํํด์** ๋์ผํ **์์ฑ์๊ฐ ๋ง๋ค์ด์ง๋ค.**

```java
public class userDto {
    private final String name;
    private final int age;

    @QueryProjection
    public userDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

## ๐ ์ฅ์ 

+ Qํ์ผ์ ๋ง๋ค์ด์ ธ ์๋ ์์ฑ์๋ฅผ ์กฐํํ๋ฉด ๋์ **์ฝ๋๊ฐ ๊น๋**ํ๋ค.
+ ์ค๋ฅ๋ฅผ ๋ฐํ์์ด ์๋๋ผ **์ปดํ์ผ ํ์์์ ์ก์ ์ ์๋ค.**

## ๐ ๋จ์  

+ ์ง๋์น๊ฒ **Querydsl์ ์์กด์ **์ด๋ค.
+ dto ํ์ผ๊น์ง Q-Type์ ์์ฑํด์ผํ๋ค.