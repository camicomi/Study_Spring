package com.test.aop.dto;


import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// @Component > DTO 는 독립성 유지 해야 하므로 빈 X
public class AOPDTO {
	

	private String name;
	private String age;
	private String color;
	

}
