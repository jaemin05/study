# AsyncConfig

## 📌 정의

+ **비동기 처리**를 하고 싶을 때 사용한다.
+ **AsyncConfigurer** 를 **implement** 하거나, **Bean 으로 설정**해서 사용한다.

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



## 📑 용어

**@EnableAsync**

+ 메소드의 비동기 기능을 활성화 시켜준다.

**ThreadPoolTaskExecutor**

+ 비동기로 호출하는 Thread에 대한 설정을 한다.

**corePoolSize**

+ 기본적으로 실행을 대기하고 있는 Thread의 갯수이다.

**MaxPoolSize**

+ 동시에 동작하는 최대 Thread의 갯수이다. 

**QueueCapacity**

+ MaxPoolSize를 초과하는 요청에서 Thread 생성 요청시, 해당 요청을 Queue에 저장한다.
+ 최대 수용 가능한 Queue의 갯수이다.

**ThreadNamePrefix**

+ 생성하는 Thread 접두사를 지정한다.