package com.woongjin.woongs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woongjin.woongs.model.MyPageDao;

@Controller
public class MyPageController {
	@Autowired
	MyPageDao dao;

	public void setDao(MyPageDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="/myPage")
	public String myPage() {
		return "myPage";
	}
	
}
