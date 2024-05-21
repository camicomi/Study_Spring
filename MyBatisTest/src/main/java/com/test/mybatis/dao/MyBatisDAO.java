package com.test.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.test.mybatis.dto.AddressDTO;
import com.test.mybatis.dto.DetailDTO;
import com.test.mybatis.dto.MyBatisDTO;
import com.test.mybatis.dto.UserDTO;

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

	List<MyBatisDTO> m11(String gender);

	List<MyBatisDTO> m12(String gender);

	List<MyBatisDTO> m13(MyBatisDTO dto);

	List<MyBatisDTO> m14(Integer type);

	List<MyBatisDTO> m15(Map<String, String> map);

	List<MyBatisDTO> m16(MyBatisDTO dto);

	void m17(MyBatisDTO dto);

	List<MyBatisDTO> m18(List<String> name);

	void addUser(UserDTO udto);

	void addDetail(DetailDTO ddto);

	String getSeq();

	List<AddressDTO> m20();

	List<AddressDTO> m21();

	List<AddressDTO> m22();

}
