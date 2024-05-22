package com.test.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.test.aop.dto.AOPDTO;


@Repository
// @Component > Spring 관리 중인 <bean>
public class AOPDAOImpl implements AOPDAO {
	
	@Override
	public void list() {
		
		AOPDTO dto1 = new AOPDTO();
		dto1.setName("강아지");
		dto1.setAge("3");
		dto1.setColor("검정");
		
		AOPDTO dto2 = new AOPDTO();
		dto2.setName("고양이");
		dto2.setAge("2");
		dto2.setColor("주황");
		
		List<AOPDTO> list = new ArrayList<AOPDTO>();
		
		list.add(dto1);
		list.add(dto2);
		
		System.out.println(list);
		
		
	}
	

	@Override
	public void add(AOPDTO dto) {
		
		
		System.out.println(dto);
		
	}
	
	@Override
	public void view() {
		
		AOPDTO dto1 = new AOPDTO();
		dto1.setName("강아지");
		dto1.setAge("3");
		dto1.setColor("검정");
		
		System.out.println(dto1);
		
		
	}
	

}
