# AsyncConfig

## ๐ ์ ์

+ **๋น๋๊ธฐ ์ฒ๋ฆฌ**๋ฅผ ํ๊ณ  ์ถ์ ๋ ์ฌ์ฉํ๋ค.
+ **AsyncConfigurer** ๋ฅผ **implement** ํ๊ฑฐ๋, **Bean ์ผ๋ก ์ค์ **ํด์ ์ฌ์ฉํ๋ค.

```java
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);     
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(10);
        executor.setBeanName("bjisfp-async-");
        executor.initialize();
        return executor;
    }
}
```



## ๐ ์ฉ์ด

**@EnableAsync**

+ ๋ฉ์๋์ ๋น๋๊ธฐ ๊ธฐ๋ฅ์ ํ์ฑํ ์์ผ์ค๋ค.

**ThreadPoolTaskExecutor**

+ ๋น๋๊ธฐ๋ก ํธ์ถํ๋ Thread์ ๋ํ ์ค์ ์ ํ๋ค.

**corePoolSize**

+ ๊ธฐ๋ณธ์ ์ผ๋ก ์คํ์ ๋๊ธฐํ๊ณ  ์๋ Thread์ ๊ฐฏ์์ด๋ค.

**MaxPoolSize**

+ ๋์์ ๋์ํ๋ ์ต๋ Thread์ ๊ฐฏ์์ด๋ค. 

**QueueCapacity**

+ MaxPoolSize๋ฅผ ์ด๊ณผํ๋ ์์ฒญ์์ Thread ์์ฑ ์์ฒญ์, ํด๋น ์์ฒญ์ Queue์ ์ ์ฅํ๋ค.
+ ์ต๋ ์์ฉ ๊ฐ๋ฅํ Queue์ ๊ฐฏ์์ด๋ค.

**ThreadNamePrefix**

+ ์์ฑํ๋ Thread ์ ๋์ฌ๋ฅผ ์ง์ ํ๋ค.