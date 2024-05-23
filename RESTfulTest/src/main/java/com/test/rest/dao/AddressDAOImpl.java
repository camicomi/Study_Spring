package com.test.rest.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.test.rest.dto.AddressDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddressDAOImpl implements AddressDAO {

	private final SqlSessionTemplate template;
	
	@Override
	public AddressDTO m1() {
		
		return template.selectOne("rest.m1");
	}
	
	@Override
	public int add(AddressDTO dto) {
		
		return template.insert("rest.add", dto);
	}
	
	@Override
	public List<AddressDTO> list() {
		
		return template.selectList("rest.list");
	}
	
	@Override
	public int edit(AddressDTO dto) {
	
		return template.update("rest.edit", dto);
	}
	
	@Override
	public int del(String seq) {
		
		return template.delete("rest.del", seq);
	}
	
	@Override
	public AddressDTO get(String seq) {
		
		return template.selectOne("rest.get", seq);
	}
	
}









