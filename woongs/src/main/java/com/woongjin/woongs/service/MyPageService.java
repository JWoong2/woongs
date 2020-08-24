package com.woongjin.woongs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.EstimateDto;
import com.woongjin.woongs.model.MyPageDao;
import com.woongjin.woongs.model.QuoteDto;

@Service
public class MyPageService {
	@Autowired
	MyPageDao dao;
	
	public void setDao(MyPageDao dao) {
		this.dao = dao;
	}

	public List<EstimateDto> selectEstimate(String user_id) {
		// TODO Auto-generated method stub
		return dao.selectEstimate(user_id);
	}

}
