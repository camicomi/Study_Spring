package com.test.security.mapper;

import com.test.security.dto.AuthDTO;
import com.test.security.dto.MemberDTO;

public interface MemberMapper {

	void register(MemberDTO dto);

	void registerAuth(AuthDTO adto);

	MemberDTO read(String username);

}
