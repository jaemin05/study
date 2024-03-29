# CHAR vs VARCHAR

## 📑 차이점

### 고정 길이 vs 가변 길이

+ **CHAR 유형**은 **고정 길이**이다. 

+ **VARCHAR 유형**은 **가변 길이**이다. 
  + 필요한 영역은 실제 데이터 크기 뿐이다.
  + 다양한 칼럼이나 **정의된 길이와 실제 데이터 길이에 차이**가 있는 컬럼에 적합하다.

### 비교 방법

+ **CHAR 유형**은 **짧은 쪽**의 끝에 **공백을 추가**해 2개의 데이터가 같은 길이가 되도록 한다.
+ **VARCHAR 유형**은 **공백도 하나의 문자**로 취급한다. 

```java
CHAR 유형 'A' = 'A ' 

VARCHAR 유형 'A' ≠ 'A '
```

