package com.test.security.mapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {

	@Select("select sysdate from dual")
	String time();
	
}
