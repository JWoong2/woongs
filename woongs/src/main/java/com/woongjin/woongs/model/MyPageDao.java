package com.woongjin.woongs.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyPageDao extends SqlSessionDaoSupport{

	public List<EstimateDto> selectEstimate(String user_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("myPage.selectMyEstimate", user_id);
	}
	
}
