# 캐시(Cache)

## 📌정의

한 번 읽어온 데이터를 **임의의 공간에 저장하여** 다음에 읽을 때는 **빠르게 결과값을 받을 수 있도록 도와주는 공간**을 말한다. 

→ DB만으로 부하를 견딜 수 없다고 생각이 들 때 사용한다.

## 📄구조

**⚡보편적인 캐시 사용 패턴**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6599fe60-2620-44d2-b089-e87835f4a9f3/Untitled.png)

**클라이언트가 웹서버에 요청을 보내면**, 서버는 데이터를 DB에서 가져오기 전에 C**ache에 데이터가 있는지 확인부터 한다.** 

**Cache 서버에 데이터가 있으면**, 데이터를 **DB에 요청하지 않고 바로 클라이언트에 반환**한다. 

→ **cache Hit**

**Cache 서버에 데이터가 없으면,** DB에 해당 데이터를 요청한다. 서버는 **DB로부터 반환된 데이터를 캐시에 저장한 후** 클라이언트에 반환한다. 

**→ cache Miss**

Static한 파일을 캐시해주는 CDN서비스와도 동일한 구조이다.

⚡**동시 다발적인 쓰기가 가능한 패턴**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/793d0c69-14c9-4322-8ff8-3e1dc5553bb9/Untitled.png)

클라이언트가 서버에 요청을 하고, **서버는 Cache에 데이터를 쓴 후 바로 결과를 리턴한다**. 워커 서버들은 **Cache 서버에 있는 데이터를 가져와서 작업을 수행하고 DB에 쓴다.** 

→ **순차적으로 Transaction을 처리할 수 있다.**
