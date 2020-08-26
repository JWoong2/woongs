package com.woongjin.woongs.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class IncomeDao extends SqlSessionDaoSupport {
	public List<Map<String, Object>> findIncomeById(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("income.findIncomeById", info);
	}
	
	public List<Map<String, Object>> findAccountInfoByUserId(Map<String, Object> info) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("income.findAccountInfoByUserId", info);
	}
}
