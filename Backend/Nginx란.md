# Nginx란

## 📌 정의

+ 트래픽이 많은 웹사이트의 확장성을 위해 개발된 경량의 고성능 웹서버이다.
+ Nginx는 **적은 자원**의 사용으로 **높은 성능**과 **높은 동시성**을 목표로 만들어졌다.



## 🙌 사용 예시

**HTTP Server **

+ 요청에 의해 정적 파일을 응답해주는 웹서버

**Reverse Proxy Server**

+ 요청으로부터 애플리케이션 서버에 로드밸런싱

**Mail Proxy Server**



## 👎 Nginx vs Apache

### Nginx

**👍장점**

- 비동기 Event-Drive 으로 요청하여 적은 자원을 사용해 CPU 소모가 적다.
- 다수의 클라이언트 연결을 효율적으로 처리 가능.
- 문맥 교환(context switching)의 비용이 적다.

**👎단점**

+ 복잡한 처리가 필요한 요청의 경우 시스템 큐에 쌓이게 되어 성능이 저하될 수 있다.

![image-20220718212332397](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220718212332397.png)

### Apache

**👍장점**

+ 환경에 맞게 PreFork 방식(요청마다 프로세스 생성), Worker 방식(프로세스와 쓰레드 병행해서 사용) 선택 가능
+ 안정성, 확장성, 호환성의 장점이 있다.

**👎단점**

+ 클라이언트의 연결이 늘어남에 따라 프로세스가 계속 늘어나 메모리 낭비가 심하고 문맥 교환 비용이 든다.
+ 프로세스가 blocking 되면 요청을 처리하지 못하고 이전 요청을 처리하기 전까지 대기상태가 된다.

![image-20220718212730879](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20220718212730879.png)