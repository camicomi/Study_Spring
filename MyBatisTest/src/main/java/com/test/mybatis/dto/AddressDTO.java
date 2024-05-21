package com.test.mybatis.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO {

	
	private String seq;
	private String name;
	private String age;
	private String address;
	private String gender;

	
	// 1:1
	private InfoDTO info;
	
	// 1:N
	private List<MemoDTO> memo;
	

}
