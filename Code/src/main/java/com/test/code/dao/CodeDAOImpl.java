package com.test.code.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.test.code.dto.CodeDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CodeDAOImpl implements CodeDAO {
	
	
	private final SqlSessionTemplate template;

	@Override
	public int add(CodeDTO dto) {
		
				
		return template.insert("code.add", dto);
	}

	@Override
	public List<CodeDTO> list() {
		
		return template.selectList("code.list");
	}

	
	@Override
	public CodeDTO view(String seq) {
		
		return template.selectOne("code.get", seq);
	}
		

}
