package com.test.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.test.mybatis.dto.AddressDTO;

public interface AddressMapper {

	// http://localhost:8080/mybatis/get?seq=1
	@Select("select * from tblAddress where seq = #{seq}")
	AddressDTO get(String seq);

	// AddressMapper.xml 에 쿼리 작성
	// http://localhost:8080/mybatis/list
	List<AddressDTO> list();
	

}
