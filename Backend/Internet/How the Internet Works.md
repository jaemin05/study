# 인터넷의 개념과 작동 원리

## **❓**인터넷이란?

**인터넷**은 웹의 핵심적인 기술이다. 인터넷의 가장 기본적인 것은, 컴퓨터들이 서로 통신 가능한 거대한 네트워크라는 것이다.

## **📌**단순한 네트워크

두 개의 컴퓨터가 통신이 필요할 때, 우리는 다른 컴퓨터와 **물리적**으로 (보통 [이더넷 케이블](http://en.wikipedia.org/wiki/Ethernet_crossover_cable)) 또는 **무선**으로 (예를 들어, [WiFi](http://en.wikipedia.org/wiki/WiFi) 나 [Bluetooth](http://en.wikipedia.org/wiki/Bluetooth) 시스템) 연결되어야 한다. 

![https://mdn.mozillademos.org/files/8441/internet-schema-1.png](https://mdn.mozillademos.org/files/8441/internet-schema-1.png)

이러한 네트워크는 두 대의 컴퓨터로 **제한되지 않는다**. 원하는 만큼의 컴퓨터를 연결할 수 있다. 그러나 이렇게 연결할 수록 매우 **복잡해진다**.

![https://mdn.mozillademos.org/files/8443/internet-schema-2.png](https://mdn.mozillademos.org/files/8443/internet-schema-2.png)

이 문제를 해결하기 위해 네트워크의 각 컴퓨터는 **라우터**라고하는 **특수한 소형 컴퓨터**에 연결된다. 이 **라우터**에는 단 하나의 작업만 있다.

![https://mdn.mozillademos.org/files/8445/internet-schema-3.png](https://mdn.mozillademos.org/files/8445/internet-schema-3.png)

## **📌**네트워크 속의 네트워크

컴퓨터를 라우터에 연결하고, 라우터에서 라우터로, 우리는 **무한히 확장**할 수 있다.

![https://mdn.mozillademos.org/files/8449/internet-schema-5.png](https://mdn.mozillademos.org/files/8449/internet-schema-5.png)

전력 및 전화와 같이 이미 집에 연결된 케이블이 있다. 전화기 기반의 시설은 이미 세계 어느 곳과도 연결되어 있으므로 우리가 필요로 하는 완벽한 배선이라고 할 수 있다. 따라서 우리의 네트워크를 전화 시설과 연결하기 위해서는, **모뎀**이라는 특수 장비가 필요한다. 이 **모뎀**은 우리 네트워크의 정보를 전화 시설에서 처리 할 수있는 정보로 바꾸며, 그 반대의 경우도 마찬가지이다.

![https://mdn.mozillademos.org/files/8451/internet-schema-6.png](https://mdn.mozillademos.org/files/8451/internet-schema-6.png)

그래서 우리의 네트워크는 전화 시설에 연결된다. 다음 단계는 우리의 네트워크에서 도달하려는 네트워크로 메시지를 보내는 것이다. 그렇게하기 위해 네트워크를 **인터넷 서비스 제공 업체** (Internet Service Provider, **ISP**)에 연결한다. **ISP**는 모두 함께 연결되는 몇몇 특수한 **라우터를 관리**하고 **다른 ISP의 라우터에도 액세스 할 수 있는 회사**이다. 따라서 우리 네트워크의 메시지는 **ISP 네트워크**의 네트워크를 통해 대상 네트워크로 전달된다. 인터넷은 이러한 전체 네트워크 인프라로 구성된다.

![https://mdn.mozillademos.org/files/8453/internet-schema-7.png](https://mdn.mozillademos.org/files/8453/internet-schema-7.png)

## **📌**컴퓨터 찾기

컴퓨터에 메시지를 보내려면 메시지를 받을 특정 컴퓨터를 지정해야한다. 따라서 네트워크에 연결된 모든 컴퓨터에는 **IP 주소**라는 고유한 주소가 있다. 

컴퓨터는 이러한 주소로 다른 컴퓨터를 찾아가는데 문제가 없다. 그러나 IP주소를 기억하기 어렵기때문에 '**도메인 이름**'이라고하는 사람이 읽을 수 있는 IP 주소의 이름을 지정할 수 있다.

## **📌인터넷과 웹**

웹 브라우저를 사용하여 웹을 탐색할  일반적으로 **도메인 이름**을 사용하여 웹 사이트에 접속한다. 앞에서 보았듯 인터넷은 수십억대의 컴퓨터를 모두 연결하는 기술 인프라이다. 이러한 컴퓨터들 중에 일부는 '**웹 서버**'로서 웹 브라우저가 이해할 수 있는 서비스를 제공한다. 인터넷은 인프라이며, 웹은 그 인프라기반 위에 구축된 서비스이다. 웹 뿐만 아니라 인터넷 위에 구축된 다른 서비스들도 있음을 알아야한다.
