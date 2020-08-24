package com.woongjin.woongs.model;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;


public class UserDao extends SqlSessionDaoSupport{
	
	public void register(UserDto vo) throws Exception {
		getSqlSession().insert("userMapper.register", vo);
	}
	
	public int userPassFind(UserDto vo) throws Exception {
		return getSqlSession().selectOne("userMapper.find", vo);
	}
	
	public UserDto userLogin(UserDto vo) throws Exception {
		return getSqlSession().selectOne("userMapper.login", vo);
	}

	public void sendCode(Map<String, String> map) {
		getSqlSession().insert("userMapper.sendCode", map);
		
	}

	public int insertCode(Map<String, String> map) {
		return getSqlSession().selectOne("userMapper.insertCode", map);
	}

	public void deleteCode(Map<String, String> map) {
		getSqlSession().delete("userMapper.deleteCode", map);
	}

	public void updateCode(Map<String, String> map) {
		getSqlSession().update("userMapper.updatePassword", map);		
	}

	public int getUserCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("userMapper.userCount");
	}

	public UserDto getUserInfo(String user_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("userMapper.getUserInfo", user_id);
	}
}
