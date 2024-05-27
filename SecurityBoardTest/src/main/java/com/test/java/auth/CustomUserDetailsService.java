package com.test.java.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.java.dto.MemberDTO;
import com.test.java.mapper.MemberMapper;
import com.test.java.dto.CustomUser;

//@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("loadUserByUsername >>>>>>>>>>>> " + username);
		System.out.println("mapper: " + mapper);
		
		MemberDTO dto = mapper.read(username);
		
		System.out.println("dto >>>>>>>>>> " + dto);
	
		return dto != null ? new CustomUser(dto) : null;
	}
	
}






