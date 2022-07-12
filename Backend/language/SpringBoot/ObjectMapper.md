# ObjectMapper

## 📌 정의

+ Java 객체를 JSON으로 serialization 하거나 JSON을 Java 객체로 deserialization  할 때 사용하는 Jackson 라이브러리의 클래스이다.

## ⚡ 예제

### Java Object →  JSON

```java
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectMapperEx {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

	// Java Object ->  JSON
        Person person = new Person("zooneon", 25, "seoul");
        try {
            objectMapper.writeValue(new File("src/person.json"), person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### JSON → Java Object 

```java
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperEx {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        // JSON -> Java Object
        String json = "{\"name\":\"zooneon\",\"age\":25,\"address\":\"seoul\"}";
        try {
            Person deserializedPerson = objectMapper.readValue(json, Person.class);
            System.out.println(deserializedPerson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
```

## ⚠ 주의사항

+ **역직렬화 시킬 클래스**에 JSON을 파싱한 결과를 전달할 **생성자**가 있어야 한다.

+ 생성자에 Jackson 라이브러리의 `@JsonCreator` 어노테이션을 쓰는 등 다양한 방법이 있다.