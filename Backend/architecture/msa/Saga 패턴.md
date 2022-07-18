# Saga 패턴

## ❓ 왜 사용할까?

+ **MSA 아키택쳐**를 사용하기 어려운 이유 중 하나는 트랜잭션이다. 
+ 모놀리식 환경에서는 DBMS가 제공해주는 트랜잭션 기능으로, Commit과 Rollback을 사용해 데이터를 일관성 있게 관리했다.
+ 하지만 **Application, DB가 분산되면** 트랜잭션 처리를 단일 DBMS에서 제공하는 기능을 통해서 할 수가 없다.

## 📑 Two Phase Commit

+ **2단계**를 거쳐서 데이터를 영속화한다.
+ 트랜잭션 요청이 들어왔을 때 2단계를 거쳐 **트랜잭션 진행을 담당하는 조정자**가 존재한다.

### 1. Prepare

+ 연관된 DB에게 데이터를 **저장할 수 있는 상태**인지 묻는다.

+ 메시지를 받은 DB는 영속화할 준비가 완료되면 완료 메시지 혹은 불가 **메시지를 전달**한다.

### 2. Commit

+ 모든 메시지 수신이 완료되면 진행한다.

+ **조정자**가 DB에 데이터를 저장하라는 메시지를 송신하고 **DB는 데이터를 영속화한다.** 

  → 모든 DB에서 트랜잭션 처리가 완료되면 전체 트랜잭션을 종료한다.

+ DB 하나라도 Commit이 불가능하면 **모든 DB에게 Rollback**을 요구한다.

### MSA에서의 문제점

+ Two-Phase Commit은 DBMS 간 분산 트랜잭션을 지원해야 적용가능하다.
+ **NoSQL에서는 지원하지 않는다.**
+ **함께 사용되는 DBMS가 동일**해야 한다. (Oracle, MySQL, Postgres) 
+ 따라서 DBMS polyglot 구성은 어렵다.

![image-20220613125501908](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220613125501908.png)

## 📑 Saga 패턴

### 📌 정의

+ **트랜잭션의 관리주체**가 DBMS가 아닌 **Application**에 있다.
+ 각 App 하위에 존재하는 DB는 Local 트랜잭션 처리만 담당한다.

+ 각 App에 대한 연속적인 트랜잭션 요청 및 실패할 경우에 **Rollback 처리를 Application에서 구현**해야한다.
+ DBMS를 다른 제품군으로 구성할 수 있다.

### 1. Choreography-Based Saga

+ 자신이 보유한 서비스내 Local 트랜잭션을 관리하고 트랜잭션이 종료되면 완료 Event를 발행한다.
+ Event는 **Kafka와 같은 메시지 큐**를 이용해서 비동기 방식으로 전달할 수 있다.
+ 중간에 트랜잭션이 실패하면, 해당 트랜잭션 취소처리를 **실패한 App에서 보상 Event를 발행**하고 Rollback을 한다.

![image-20220613131512044](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220613131512044.png)

### 2. Orchestration-Based Saga

+ 트랜잭션 처리를 위한 **Saga 인스턴스가 별도로 존재**한다.
+  **모든 App은 Manager에 의하여 점진적으로 트랜잭션을 수행**하고 그 결과를 Manager에게 전달한다.
+ 만약 중간에 실패하면 Manager에서 보상 트랜잭션을 발동하여 일관성을 유지한다.

**👍 장점**

+ 분산 트랜잭션의 **중앙 집중화**가 이루어진다.
+ 서비스간 복잡성이 줄어든다.
+ **Rollback을 쉽게** 할 수 있다.

**👎 단점**

+ **Orchestrator 서비스가 추가**되어야 한다. ← 인프라 구현의 복잡해진다.

![image-20220613131827393](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220613131827393.png)