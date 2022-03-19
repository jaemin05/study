# 프로토타입 (Prototype)

## 📌 정의

+ ​	**미리 만들어진 객체**를 복사해서 객체를 생성하는 패턴이다.

**👍 장점**

+ 다수의 객체 생성시 객체 생성 비용을 줄일 수 있다.

```java
public class Item extends Cloneable{
    String name;
    int price;
    
    public Item(name, price){
        this.name = name;
        this.price = price;
    }
    
    @Override
    public Item clone(){
        Item item = (Item)super.clone();
    }
    
Item item = new Item("coffee", 1000);
    
Item sonItem = item.clone();
sonItem.setPrice(2000);
```