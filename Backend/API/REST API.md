# REST API(REpresentational State Transfer) 특징

**Uniform(유니폼 인터페이스)**

URI로 지정한 리소스에 대한 조작을 통일되고 한정적인 인터페이스로 수행하는 아키택쳐 스타일을 말한다. 

**Stateless(무상태성)**

작업을 위한 상태정보를 따로 저장하고 관리하지 않습니다.

**Cacheanle(캐시 가능)**

HTTP라는 기존 웹표준을 그대로 사용하기 때문에 웹에서 사용하는 기존 인프라를 그대로 활용이 가능하다. 

**Self-descriptiveness(자체 표현 구조)**

Rest API 메시지만 보고 쉽게 이해 할 수 있다.

**Client-Server 구조**

REST 서버는 API 제공, Client는 사용자 인증이나 컨텐스트 등을 직접 관리하는 구조로 각각의 역할이  구분된다.

**계층형 구조**

REST 서버는 다중 계층으로 구성 될 수 있다. 보안, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있다.
