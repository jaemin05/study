# 정규화

## 📌정의

테이블 간에 **중복된 데이터를 허용하지 않는 것**을 말한다. 

데이터의 값이 **정확하고(무결성)** DB의 저장 **용량도 줄일 수 있다.**

## 📄제1 정규화

테이블의 컬럼이 **원자값(하나의 값)을 갖도록** 테이블을 분해하는 것이다. 

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c2175a7e-be4a-4a6f-ad6f-a41b88ba9e4c/Untitled.png)

## 📄제2 정규화

제1 정규화를 진행한 테이블에 대해서 **완전 함수 종속을 만족하도록 테이블을 분해**하는 것이다.

완전 함수 종속이란 기본키의 부분 집합이 결정자가 되어선 안된다는 것이다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2937390a-2fb8-4124-a73f-f6bc65a1a4ab/Untitled.png)

## 📄제3 정규화

제2 정규화를 진행한 테이블에 대해서 **이행적 종속을 없애도록 테이블을 분해**한 것이다.

**이행적 종속**이란 A → B, B → C가 성립할 때 A → C가 성립되는 것을 의미한다.

이행적 종속을 없애는 이유는 만약 **이행적 종속이 존재한다면** **501번 학생**이 **수강하는 강좌가 변경 된다면** **수강료도 값이 변경될 것이다**. 이런 번거러움을 해결하기 위해 제3 정규화를 한다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f27ac997-fce3-4fdd-a516-71c7116c31db/Untitled.png)

## 📄BCNF 정규화

제3 정규화를 진행한 테이블에 대해 **모든 결정자가 후보키가 되도록 테이블을 분해**하는 것이다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b49ca29f-833c-44b3-a782-4b0ab475ddc8/Untitled.png)
