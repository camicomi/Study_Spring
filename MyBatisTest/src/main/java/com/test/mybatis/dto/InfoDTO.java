package com.test.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InfoDTO {
	
	private String seq; // PK + FK
	private String school;
	private String country;

}
