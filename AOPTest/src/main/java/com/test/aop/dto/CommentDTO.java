package com.test.aop.dto;

import lombok.Builder;
import lombok.ToString;


@Builder
@ToString
public class CommentDTO {
	
	
	private String seq;
	private String name;
	private String subject;
	private String content;
	private String regdate;
	

}
