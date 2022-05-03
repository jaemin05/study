# **📌**정의

도메인 네임 시스템(Domain Name System, DNS)은 호스트의 도메인 이름을 **호스트의 네트워크 주소로 바꾸거나 그 반대의 변환을 수행**할 수 있도록 하기 위해 개발되었다.

# ✏DNS의 작동원리

![https://media.vlpt.us/images/goban/post/5717ceb7-79f2-41d3-86e5-7e48bfd6ac58/DNSLogic.png](https://media.vlpt.us/images/goban/post/5717ceb7-79f2-41d3-86e5-7e48bfd6ac58/DNSLogic.png)

웹 브라우저에 www.naver.com을 입력하면 Local DNS에게 "www.naver.com"이라는 hostname"에 대한 IP 주소를 질의하여 Local DNS에 없으면 다른 DNS name 서버 정보를 받는다.(**Root DNS** 정보 전달 받는다)

Root DNS 서버에 "www.naver.com" 질의한다.

Root DNS 서버로 부터 "com 도메인"을 관리하는 **TLD**이름 서버 정보 전달 받는다.

TLD에 "www.naver.com" 질의한다.

TLD에서 "name.com" 관리하는 DNS 정보 전달한다.

"naver.com" 도메인을 관리하는 DNS 서버에 "www.naver.com" 호스트네임에 대한 IP 주소 질의한다.

Local DNS 서버에게 "www.naver.com에 대한 IP 주소는 222.122.195.6 라고 응답한다.

Local DNS는 www.naver.com에 대한 IP 주소를 캐싱을 하고 IP 주소 정보 전달한다.

**최상위 ICANN** 아래에 **REGISTRY, NIC**이 있고 **REGISTRY 아래에 우리가 흔이 보는 gTLD** 그리고 **new gTLD가 있고 NIC아래에는 공공사이트에서 쓰는 ccTLD 도메인 주소**가 있다.
