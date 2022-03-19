# ACID

## 📌정의

**데이터베이스 트랜잭션들이 안정적으로 수행된다는 것을 보장**하기 위한 성질을 말한다.

## 📄성질 4가지

**원자성(Atomicity)**

트랜잭션이 DB에 모두 반영되거나, 전혀 반영되지 않아야 한다.

**일관성(Consistency)**

트랜잭션의 작업 처리 결과는 항상 일관서 있어야 한다.

**독릭성(Isolation)**

둘 이상의 트랜잭션이 동시에 병행 실행되고 있을때, 어떤 트랜잭션도 다른 트랜잭션 연산에 끼어들 수 없다.

**지속성(Durability)**

트랜잭션이 성공적으로 완료되면 결과는 영구적으로 반영되어야 한다.