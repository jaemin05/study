# Spring Batch

## 📌 정의

+ **로깅, 추적, 트랜잭션 관리, 작업 처리 통계, 작업 재시작, 건너뛰기, 리소스 관리** 등 **대용량 레코드 처리**에 필수적인 기능을 제공한다.

+ 배치가 실패하여 작업 재시작을 하게 된다면 처음부터가 아니라 **실패한 지점부터 실행**을 하게 된다.
+ **중복 실행을 막기 위해** 성공한 이력이 있는 Batch는 **동일한 Parameters로 실행 시 Exception**이 발생한다. 



## 📑 차이점

### **Spring Batch vs Quartz? Scheduler?**

+ **Spring Batch**는 Batch Job을 관리하지만 **Job을 구동**하거나 **실행하는 기능**을 지원하지 않는다.
+ Spring에서 Batch Job을 실행시킬려면 **Quartz, Scheduler, Jenkins**등 전용 **Scheduler를 사용**해야 한다.



