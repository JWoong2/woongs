package com.woongjin.woongs.model;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class UserDao extends SqlSessionDaoSupport{
	
	public void register(UserDto vo) throws Exception {
		getSqlSession().insert("memberMapper.register", vo);
	}
	
	public int userPassFind(UserDto vo) throws Exception {
		return getSqlSession().selectOne("memberMapper.find", vo);
	}
	
	public int userLogin(UserDto vo) throws Exception {
		return getSqlSession().selectOne("memberMapper.login", vo);
	}

	public void sendCode(Map<String, String> map) {
		getSqlSession().insert("memberMapper.sendCode", map);
		
	}

	public int insertCode(Map<String, String> map) {
		return getSqlSession().selectOne("memberMapper.insertCode", map);
	}

	public void deleteCode(Map<String, String> map) {
		getSqlSession().delete("memberMapper.deleteCode", map);
	}

	public void updateCode(Map<String, String> map) {
		getSqlSession().update("memberMapper.updatePassword", map);		
	}

	public UserDto isUser(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}
}
