# OAuth2.0

## ๐์ ์

**๋ค์ํ ํ๋ซํผ ํ๊ฒฝ**์์ **๊ถํ ๋ถ์ฌ**๋ฅผ ์ํ **์ฐ์ ํ์ค ํ๋กํ ์ฝ**์ด๋ค.

## ๐์ธ์ฆ ๊ณผ์ 

![https://developers.payco.com/static/img/@img_guide2.jpg](https://developers.payco.com/static/img/@img_guide2.jpg)

## ๐์ธ์ฆ ์ข๋ฅ

**Authorization Code Grant**

์๋ฒ์ฌ์ด๋ ์ฝ๋๋ก ์ธ์ฆํ๋ ๋ฐฉ์์ด๋ค.

๋ก๊ทธ์ธ์ ํ์ด์ง URL์ response_type = code๋ผ๊ณ  ๋๊ธด๋ค.

**Implicit Grant**

๊ถํ์ฝ๋ ์์ด ๋ฐ๋ก ๋ฐ๊ธ๋๋ค.

์ฃผ๋ก Read only์ธ ์๋น์ค์์ ์ฌ์ฉ๋๋ค.

๋ก๊ทธ์ธ์ ํ์ด์ง URL์ response_type = token์ด๋ผ๊ณ  ๋๊ธด๋ค.

**Password Credentials Grant**

Client์ ์์ด๋,ํจ์ค์๋๋ฅผ ์ ์ฅํด ๋๊ณ  ์์ด๋,ํจ์ค์๋๋ก ์ง์  access token์ ๋ฐ์์ค๋ ๋ฐฉ์์ด๋ค.

๋ก๊ทธ์ธ์ API์ POST๋ก grant_type = password ๋ผ๊ณ  ๋๊ธด๋ค.

**Client Credentials Grant**

์ดํ๋ฆฌ์ผ์ด์์ด Confidential Client์ผ ๋ id ์ secret์ ๊ฐ์ง๊ณ  ์ธ์ฆํ๋ ๋ฐฉ์์ด๋ค.

๋ก๊ทธ์ธ์ API์ POST๋ก grant_type = client_credentials ๋ผ๊ณ  ๋๊ธด๋ค.
