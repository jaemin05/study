# SOP, CORS, CSP 



## ๐ ์ ์

### SOP (Same Origin Policy)

+ **๋ค๋ฅธ ๊ธฐ์์์ ์จ ์์์ ์ ํ**ํ๋ ์ ์ฑ์ด๋ค. 

+ ๋์ผํ ํ๋กํ ์ฝ, ํธ์คํธ, ํฌํธ๋ง ๋ฆฌ์์ค๋ฅผ ๊ณต์  ๊ฐ๋ฅํ๋ค.



### CORS (Cross Origin Resource Sharing)

+ SOP ์ ์ฝ์ฌํญ์ ์ํํด์ค๋ค. **๋ค๋ฅธ Origin์ด์ฌ๋ ๋ฆฌ์์ค๋ฅผ ๊ณต์ **ํ  ์ ์๋๋ก ํด์ค๋ค. 
+ ์ถ๊ฐ HTTP ํค๋๋ฅผ ์ฌ์ฉํด, ํ ์ถ์ฒ์์ ์คํ ์ค์ธ ์น ์ ํ๋ฆฌ์ผ์ด์์ด ๋ค๋ฅธ ์ถ์ฒ์ ์ ํํ ์์์ ์ ๊ทผํ  ์ ์๋ ๊ถํ์ ๋ถ์ฌํ๋๋ก ๋ธ๋ผ์ฐ์ ์ ์๋ ค์ฃผ๋ ์ฒด์ ์ด๋ค. 
+ Access-Control-Allow-Origin ํค๋์ ์๋ง์ ๊ฐ์ ์ธํํ๋ฉด ํด๊ฒฐํ  ์ ์๋ค. (ํ๋๋ง ๊ฐ๋ฅ, ์ฌ๋ฌ๊ฐ๋  *)



### CSP (Content Security Policy)

+ ์ฃผ๋ก XSS๋ Data Injection, Click Jacking ๋ฑ ์น ํ์ด์ง์ ์์ฑ ์คํฌ๋ฆฝํธ๋ฅผ ์ฝ์ํ๋ ๊ณต๊ฒฉ์ ๋ง๊ธฐ ์ํจ์ด๋ค.
+ **ํน์  ๋ฆฌ์์ค๊ฐ ์ด๋์ ์๋์ง ๊ฒ์ฌํ๊ณ  ๊ฒํ **ํ๋ค.
+ 'Content-Security-Policy: '๋ฅผ ํค๋์ ์ถ๊ฐํ๋ค. 



**Content-Security-Policy: (Directive Refrence) (Source List Refence)**



+ **Directive Refrence**
  - **default-src**: ๋ง์ฝ ๋ค๋ฅธ CSP๋ค์ด ๊ฑธ๋ ค ์์ง ์๋ค๋ฉด Default๋ก ์ค์ ๋๋ CSP๋ค.  ๋ค์ํ ๊ฐ๋ค์ ๊ด๋ฆฌํ๋ค.
  - **style-src**: Stylesheet๊ฐ ๋ช์๋ ์ฃผ์์์ ์๋์ง ๊ฒ์ฌํ๋ค.
  - **img-src**: ์ด๋ฏธ์ง๊ฐ ๋ช์๋ ์ฃผ์์์ ์๋์ง ๊ฒ์ฌํ๋ค.
+ **Source List Refrence**
  - **none**: ์ด๋๋  source๋ฅผ ๊ฐ์ง๊ณ  ์ค์ง ์๋๋ค. 
  - **self**: ๊ฐ์ ๊ธฐ์์์๋ง ๊ฐ์ ธ์จ๋ค.





