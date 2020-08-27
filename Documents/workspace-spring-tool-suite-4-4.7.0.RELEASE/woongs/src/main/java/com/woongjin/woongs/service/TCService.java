package com.woongjin.woongs.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.TCDao;
import com.woongjin.woongs.model.TCDto;
import com.woongjin.woongs.model.TCListModel;

@Service
public class TCService {

	@Autowired
	TCDao dao;

	public void setDao(TCDao dao) {
		this.dao = dao;
	}
	
	public TCDto update(int no) {
		return dao.getContent(no);
	}
	
	public void insert(TCDto dto, HttpServletRequest request) {
		/* int number = dao.selectMax()+1; */
		/* int no = dto.getNo(); */
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));
		dao.insert(dto);
	}
	
	public void update(TCDto dto) {
		dao.update(dto);
	}
	
	/*
	 * public void delete(TCDto dto) { dao.delete(dto); }
	 */
	
	
	public void delete(int no) { 
		dao.delete(no); 
	}
	 
	
	/*
	 * public void delete(HttpServletRequest request) { dao.delete(request); }
	 */
	
	public TCDto getcontent(int no) {
		return dao.getContent(no);
	}
	
	 public List<TCDto> selecttc() { return dao.selecttc(); } 
	 
	
	public TCListModel list(int pageNum, int per){
		int count = dao.count();
		if(count == 0) {
			return new TCListModel();
		}
		
		int start = (pageNum - 1) * per;	
		List<TCDto> list = dao.getList(start, per);
		
		Paging p = new Paging().paging(pageNum, count, per);
		return new TCListModel(list,pageNum,p.totalPageCount,start,p,count);
	}
}