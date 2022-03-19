# Redis

## 📌정의

Redis는 빠른 오픈 소스 인 **메모리 키 값 데이터 구조 스토어**이다. 

모든 데이터를 메모리에 저장하고 조회하기 때문에 **빠른 Read, Write 속도를 보장하는 NoSQL**이다.

## 📄Redis가 지원하는 데이터 형식

**String**

**Set**

**Sorted Set**

**Hash**

**List**

## 👍장점

캐시를 생성하여 액세스 **시간을 줄이고** 처리량을 늘려 **DB 부담을 줄인다.**

Sorted Set을 이용하면 **자동정렬을 할 수 있어서** 순위 매기기에 좋다.

**PUB/SUB가 지원이 된다.**

→ 채팅방, 실시간 코멘트 스트림, **서버 상호 통신을 지원한다.**

## 👎단점

**장애 발생시 데이터 유실이 발생한다.**

→ 스냅샷과 AOF 기능을 통한 복구 방식을 주의해서 작성해야 한다.