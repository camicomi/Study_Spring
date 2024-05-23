REST API


1. 새 프로젝트
- Project name: "RESTfulTest"
- Templates: Spring MVC Project
- Enter a topLevelPackage: "com.test.rest"


2. 스프링/자바 버전 변경하기
- pom.xml
- <org.springframework-version>5.0.7.RELEASE</org.springframework-version>
- <java-version>11</java-version>
- <source>11</source>
  <target>11</target>
- 패키지 탐색기 > 우클릭 > Properties > Project Facets > Java > 11


3. 서블릿/JSP 버전 변경하기
- pom.xml
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>3.1.0</version>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>javax.servlet.jsp</groupId>
	<artifactId>javax.servlet.jsp-api</artifactId>
	<version>2.3.3</version>
	<scope>provided</scope>
</dependency>


4. jUnit
<!-- Test -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.13.2</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>${org.springframework-version}</version>
</dependency>

5. Lombok
- pom.xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>

6. MyBatis 의존성 추가
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis</artifactId>
	<version>3.5.2</version>
</dependency>
<dependency>
	<groupId>org.mybatis</groupId>
	<artifactId>mybatis-spring</artifactId>
	<version>1.3.2</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-tx</artifactId>
	<version>${org.springframework-version}</version>
</dependency>
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-jdbc</artifactId>
	<version>${org.springframework-version}</version>
</dependency>


7. ojdbc8.jar


8. HikariCP
- pom.xml
<dependency>
	<groupId>com.zaxxer</groupId>
	<artifactId>HikariCP</artifactId>
	<version>2.7.4</version>
</dependency>


9. Log4j2
- 로깅 라이브러리
- Log4j > Logback > Log4j2

- pom.xml > 기존의 log4j 의존성을 제거한다.
- pom.xml > log4j2 의존성을 추가한다.
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-api</artifactId>
	<version>2.23.1</version>
</dependency>
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-core</artifactId>
	<version>2.23.1</version>
</dependency>
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-slf4j-impl</artifactId>
	<version>2.23.1</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.bgee.log4jdbc-log4j2</groupId>
	<artifactId>log4jdbc-log4j2-jdbc4</artifactId>
	<version>1.16</version>
</dependency>

- src/main/resources > log4j.xml > log4j2.xml
- src/main/resources > log4jdbc.log4j2.properties




결과 = Spring MVC Project + MyBatis + log4j2 + Lombok + jUnit


10. 파일 생성
- RESTfulTest > "script.sql"

- "com.test.rest.controller" > "AddressController.java"
- "com.test.rest.dao" > "AddressDAO.java"(I)
                      > "AddressDAOImpl.java"(C)
- "com.test.rest.dto" > "AddressDTO.java"

- views > 생성(X)


11. REST Client
- CURL
- Postman
- Insomnia
- VS Code(Thunder Client)
- VS Code(REST Client)
- Swagger(API 명세) > springfox, springdocs

12. Swagger
- REST Client 역할
- REST API 명세서(도움말) > 관리 용이, 제 3자 편리하게 사용
- 2011년


12.1 pom.xml
<!-- Swagger -->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>

<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>

12.2 SwaggerConfig
- "com.test.rest.config" > "SwaggerConfig.java"

12.3 servlet-context.xml
- resources location 추가

12.4 실행
- http://localhost:8080/rest/swagger-ui.html






REST API, RESTful Service
- REST, Representational State Transfer
- 웹상의 자원(문서, 이미지, 동영상, 데이터 등)을 자원명으로 표시해서 자원의 상태를 주고 받기 행위
- HTTP URI를 통해서 자원을 명시하고, HTTP Method를 통해서 자원에 대한 CRUD 처리하는 방식
- 기존에 생성하는 URL의 형식(X) > 별도의 규칙을 만족하는 URL을 생성(O)
- 표준이 없다.

URI 작성
1. 기존 방식
- GET	 http://localhost/member/list.do		목록보기
- POST	 http://localhost/member/add.do			추가하기
- POST	 http://localhost/member/edit.do?seq=1	수정하기
- POST	 http://localhost/member/del.do?seq=1	삭제하기
- GET	 http://localhost/member/list.do?w=검색어 검색하기

2. REST
- GET 	 http://localhost/member				목록보기
- POST	 http://localhost/member				추가하기
- PUT	 http://localhost/member/1				수정하기
- DELETE http://localhost/member/1				삭제하기
- GET	 http://localhost/member/검색어			검색하기

REST API 설계 규칙
1. URI에서 자원을 표시한다.
2. URI에 동사를 표시하지 않는다.(행동 표시(X))
3. HTTP Method를 사용해서 행동을 표시한다.
	a. GET: 	리소스 요청
	b. POST: 	데이터 전달 + 서버측 생성
	c. PUT: 	데이터 전달 + 서버측 수정(전체 수정)
	d. PATCH: 	데이터 전달 + 서버측 수정(일부 수정)
	e. DELETE: 	데이터 삭제
4. URI + HTTP Method = 완성
5. 구분자는 '/'를 사용한다.
6. URI의 마지막에 '/'를 적지 않는다.
7. '-' > 사용 가능(가독성)
8. '_' > 사용 비권장(가독성)
9. 확장자를 사용하지 않는다.
10. REST API의 요청 결과(반환값)는 순수 데이터만 반환한다.
	- 기본 방식: 페이지를 반환 > 브라우저 출력
	- REST 방식: 순수 데이터를 반환 > 다양한 클라이언트들이 제각기 목적과 상황에 맞게 데이터를 사용
	
	
REST API 구현 서비스
1. Ajax 용
2. Open API 










