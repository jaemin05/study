# 4-1 API 연동의 기본

## 1️⃣설정

```bash
$ yarn add axios
```

+ axios를 사용하면 GET, PUT, POST, DELETE 등의 메서드로 API 요청을 할 수 있다. ← REST API 

**사용법**

```javascript
import axios from 'axios';

axios.get('/users/1'); //주소
```



## 2️⃣예제

```javascript
const fetchUsers = async () => {
    try {
      setError(null);
      setUsers(null);
      setLoading(true);
        
      const response = await axios.get(
        'https://jsonplaceholder.typicode.com/users'
      );
      setUsers(response.data);
    } catch (e) {
      setError(e);
    }
    setLoading(false);
  };
```