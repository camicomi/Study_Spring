package com.test.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.test.mybatis.dto.MyBatisDTO;

public interface MyBatisDAO {

	void m1();

	int m2(String seq);

	int m3(Map<String, String> map);

	int add(MyBatisDTO dto);

	int m4();

	MyBatisDTO m5(String seq);

	List<String> m6();

	List<MyBatisDTO> m7();

	int m8(String table);

	List<MyBatisDTO> m9();

	List<MyBatisDTO> m10(String search);

}
