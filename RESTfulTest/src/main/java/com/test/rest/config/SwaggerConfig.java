package com.test.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //환경 설정 클래스 역할
//@EnableWebMvc
@EnableSwagger2 //Swagger2 > API 기반으로 문서를 생성
public class SwaggerConfig {
	
	//API 명세를 만들기 위한 설정
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(getApiInfo()) //API 기본 정보(메타 데이터)
					.select() //Docket 객체의 빌더 시작
					.apis(RequestHandlerSelectors.basePackage("com.test.rest"))
					//.paths(PathSelectors.ant("/address/**"))
					.paths(PathSelectors.any()) //모든 경로를 대상
					.build();
		
	}

	//문서의 제목, 버전, 설명 등..
	private ApiInfo getApiInfo() {
		
		return new ApiInfoBuilder()
					.title("Address REST API")
					.version("0.0.1")
					.description("Address 데이터에 대한 REST API 명세서입니다.")
					.build();
	}

}
















