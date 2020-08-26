package com.woongjin.woongs.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.UserDao;
import com.woongjin.woongs.model.UserDto;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public void register(UserDto dto) throws Exception {
		Date today = new Date();
		dto.setReg_Date(today);
		dao.register(dto);
	}

	public int userPassFind(UserDto vo) throws Exception {
		return dao.userPassFind(vo);
	}

	public UserDto userLogin(UserDto vo) throws Exception {
		return dao.userLogin(vo);
	}

	public void userDelete(UserDto vo) throws Exception {
		dao.userDelete(vo);
	}
	
	public void sendCode(Map<String, String> map) {
		dao.sendCode(map);
	}

	public int insertCode(Map<String, String> map) throws Exception {
		return dao.insertCode(map);
	}

	public void deleteCode(Map<String, String> map) {
		dao.deleteCode(map);
	}

	public void updateCode(Map<String, String> map) {
		dao.updateCode(map);

	}
	
	public int getUserCount() {
		// TODO Auto-generated method stub
		return dao.getUserCount();
	}
}