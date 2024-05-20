package com.test.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.test.mybatis.dto.MyBatisDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyBatisDAOImpl implements MyBatisDAO {

	private final SqlSessionTemplate template;
	
	@Override
	public void m1() {
	
		//Statement + ResultSet
		
		/*
			1. executeUpdate()
				- template.insert()
				- template.update()
				- template.delete()
			
			2. executeQuery()
				- template.selectOne()
				- template.selectList()
		
		*/
		template.insert("mybatis.m1");
		
		
	}
	
	@Override
	public int m2(String seq) {
		
		//delete from tblAddress where seq = ?
		return template.delete("mybatis.m2", seq);
	}
	
	@Override
	public int m3(Map<String, String> map) {
		
		//insert into tblAddress values (seqAddress.nextVal, ?, ?, ?, ?)
		return template.insert("mybatis.m3", map);
	}
	
	@Override
	public int add(MyBatisDTO dto) {
		
		return template.insert("mybatis.add", dto);
	}
	
	@Override
	public int m4() {
		
		/*
			String sql = "select..";
			stat = conn.createStatement();
			rs = stat.executeQuery();
			if (rs.next()) {
				return rs.getInt("count");
			}
			
			template
			- selectOne() > 레코드 1개
			- selectList() > 레코드 N개
		*/
		return template.selectOne("mybatis.m4");
	}
	
	@Override
	public MyBatisDTO m5(String seq) {
		/*
			String sql = "select..";
			stat = conn.prepareStatement();
			stat.setString(1, seq)
			rs = stat.executeQuery();
			if (rs.next()) {
				MyBatisDTO dto;
				dto.setName()
				dto.setSeq()
				return dto;
			}
			
			
			template
			- selectOne() > 레코드 1개
			- selectList() > 레코드 N개
		*/
		
		return template.selectOne("mybatis.m5", seq);
	}
	
	@Override
	public List<String> m6() {
		/*
			String sql = "select name";
			stat = conn.prepareStatement();
			rs = stat.executeQuery();
			List<String> list = new List<String>();
			while (rs.next()) {
				list.add(rs.getString("name"");
			}
			return list;
			
			
			template
			- selectOne() > 레코드 1개
			- selectList() > 레코드 N개
		*/
		
		return template.selectList("mybatis.m6");
	}
	
	@Override
	public List<MyBatisDTO> m7() {
		
		return template.selectList("mybatis.m7");
	}
	
	@Override
	public int m8(String table) {
		
		return template.selectOne("mybatis.m8", table);
	}
	
	@Override
	public List<MyBatisDTO> m9() {
		
		return template.selectList("mybatis.m9");
	}
	
	@Override
	public List<MyBatisDTO> m10(String search) {
		
		return template.selectList("mybatis.m10", search);
	}
	
	@Override
	public List<MyBatisDTO> m11(String gender) {
		
		
		return template.selectList("mybatis.m11", gender);
	}
	
	@Override
	public List<MyBatisDTO> m12(String gender) {

		
		return template.selectList("mybatis.m12", gender);
	}
	
	@Override
	public List<MyBatisDTO> m13(MyBatisDTO dto) {
	
		
		return template.selectList("mybatis.m13", dto);
	}
	
	@Override
	public List<MyBatisDTO> m14(Integer type) {
	
		
		return template.selectList("mybatis.m14", type);
	}
	
	
	@Override
	public List<MyBatisDTO> m15(Map<String, String> map) {
		
		
		return template.selectList("mybatis.m15", map);
		
	}
	
	@Override
	public List<MyBatisDTO> m16(MyBatisDTO dto) {
	
		
		return template.selectList("mybatis.m16", dto);
	}
	
	@Override
	public void m17(MyBatisDTO dto) {
		
		template.update("mybatis.m17", dto);
		
	}
	
	@Override
	public List<MyBatisDTO> m18(List<String> name) {
			
		return template.selectList("mybatis.m18", name);

	}
	
}




























