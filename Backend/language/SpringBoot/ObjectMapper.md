# ObjectMapper

## π μ μ

+ Java κ°μ²΄λ₯Ό JSONμΌλ‘ serialization νκ±°λ JSONμ Java κ°μ²΄λ‘ deserialization  ν  λ μ¬μ©νλ Jackson λΌμ΄λΈλ¬λ¦¬μ ν΄λμ€μ΄λ€.

## β‘ μμ 

### Java Object β  JSON

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

### JSON β Java Object 

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

## β  μ£Όμμ¬ν­

+ **μ­μ§λ ¬ν μν¬ ν΄λμ€**μ JSONμ νμ±ν κ²°κ³Όλ₯Ό μ λ¬ν  **μμ±μ**κ° μμ΄μΌ νλ€.

+ μμ±μμ Jackson λΌμ΄λΈλ¬λ¦¬μ `@JsonCreator` μ΄λΈνμ΄μμ μ°λ λ± λ€μν λ°©λ²μ΄ μλ€.