package com.test.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.mybatis.dto.AddressDTO;
import com.test.mybatis.mapper.AddressMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddressDAOImpl implements AddressDAO {

	
	// 1. 기존 > SqlSessionTemplate 
	// 2. 현재 > AddressMapper 쿼리 담당
	private final AddressMapper mapper;
	
	@Override
	public AddressDTO get(String seq) {
		
		return mapper.get(seq);
	}
	
	@Override
	public List<AddressDTO> list() {
			
		return mapper.list();
	}
	
}
