# bookBook

--- 

#### 구현사항

- 회원가입/로그인
- 책 검색
- 검색된 책의 상세 조회(책 목록 isbn 링크의 팝업으로 제공)
- 나의 검색 히스토리(키워드, 검색 일시)를 최신 순으로 보여 주세요.
- 사용자들이 많이 검색한 최대 10개의 검색 키워드를 제공합니다.


---
#### 추가사항

- SPA(Single Page Application)으로 구현해 주세요.
    1.spa로 구현하려 시도 하였으나 미완성, 로그인 이후 페이지만 가능

- 카카오 책 검색 API에 장애가 발생한 경우, 네이버 책 검색 API를 통해 데이터 제공 (Front-end는 이 사실을 몰라야 함)
　· 네이버 책 검색 API: https://developers.naver.com/docs/search/book/
    1.Feign Fallback 지정으로 네이버 호출

--- 
#### 라이브러리
- spring-cloud-starter-netflix-hystrix
- spring-cloud-starter-netflix-ribbon
- spring-cloud-starter-openfeign
- feign-jackson
- vuejs
- vuejs plugin
- axios
- jquery 

--- 

#### 실행 관련

server.port = 10090 지정되어 있습니다.
> http://localhost:10090


[Jar 다운로드](https://github.com/circlee/bookBook/blob/master/circlee-dist/bookbook-0.0.1-SNAPSHOT.jar)
 

