package com.test.mybatis.dao;

import java.util.List;

import com.test.mybatis.dto.AddressDTO;

public interface AddressDAO {

	AddressDTO get(String seq);

	List<AddressDTO> list();

}
