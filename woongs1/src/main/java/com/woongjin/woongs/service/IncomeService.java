package com.woongjin.woongs.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.IncomeDao;

@Service
public class IncomeService {

	@Autowired
	IncomeDao dao;

	public List<Map<String, Object>> findIncomeById(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return dao.findIncomeById(info);
	}
	
	public List<Map<String, Object>> findAccountInfoByUserId(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return dao.findAccountInfoByUserId(info);
	}
	
	
	
}