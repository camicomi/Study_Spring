package com.test.aop.dto;

import lombok.ToString;

@ToString
public class BoardDTO {

	
	private String seq;
	private String name;
	private String subject;
	private String content;
	private String regdate;
	
	
	// 생성자
	private BoardDTO(BoardDTOBuilder builder) {
		
		
		this.seq = builder.seq;
		this.name = builder.name;
		this.subject = builder.subject;
		this.content = builder.content;
		this.regdate = builder.regdate;
		
		
	}
	
	// BoardDTO 의 멤버 Class
	// Nested Class > 역할 Builder Class
	public static class BoardDTOBuilder {
		
		
		private String seq;
		private String name;
		private String subject;
		private String content;
		private String regdate;
		
		
		public BoardDTOBuilder setSeq(String seq) {
			this.seq = seq;
			return this;
		}
		public BoardDTOBuilder setName(String name) {
			this.name = name;
			return this;
			
		}
		public BoardDTOBuilder setSubject(String subject) {
			this.subject = subject;
			return this;
		}
		public BoardDTOBuilder setContent(String content) {
			this.content = content;
			return this;
		}
		public BoardDTOBuilder setRegdate(String regdate) {
			this.regdate = regdate;
			return this;
		}
		
		
		// 마지막 으로 return  
		public BoardDTO build() {
			
			return new BoardDTO(this);
		}
		
		
	}
	
	
}


















