# ํ์ดํ(PIPE)

## ๐์ ์

**์ด๋ค ํ๋ก๊ทธ๋จ์ ๊ฒฐ๊ณผ๊ฐ์ ๋ค๋ฅธ ํ๋ก๊ทธ๋จ์ ์๋ ฅ๊ฐ**์ผ๋ก ์ฌ์ฉํ๋ ๊ฒ์ด๋ค.

## ๐์ฌ์ฉ

```
echo "foo bar baz" | wc -w
```

![https://media.vlpt.us/images/goban/post/d4b6fc1f-3b5d-424c-aab9-b87554a37b4b/image.png](https://media.vlpt.us/images/goban/post/d4b6fc1f-3b5d-424c-aab9-b87554a37b4b/image.png)

wc: ๋ฌธ์์ด์ ๋ฌธ์์๋ฅผ ์ธ๋ ๋ช๋ น์ด

`|`๊ฐ ํ์ดํ๋ฅผ ๋ปํ๋ค. echo ์ถ๋ ฅ๊ฐ์ wc์ ์๋ ฅ๊ฐ์ผ๋ก ์ฌ์ฉํ๋ค.
