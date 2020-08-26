package com.woongjin.woongs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class TCDao extends SqlSessionDaoSupport {

	public void insert(TCDto dto) {
		getSqlSession().insert("tc.insert", dto);
	}

	public void update(TCDto dto) {
		getSqlSession().update("tc.update", dto);
	}
	
	
	public void delete(int no) { 
		getSqlSession().delete("tc.delete", no); 
	}
	 

	/*
	 * public void delete(HttpServletRequest request) {
	 * getSqlSession().delete("tc.delete", request); }
	 */

	public TCDto getContent(int no) {
		return getSqlSession().selectOne("tc.one", no);
	}

	public int count() {
		return getSqlSession().selectOne("tc.count");
	}

	
	  public int selectMax() { return getSqlSession().selectOne("tc.max"); }
	 

	public List<TCDto> getList(int start, int per) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("start", start);
		m.put("per", per);
		return getSqlSession().selectList("tc.list", m);
	}

	
	
	
	  public List<TCDto> selecttc() { return getSqlSession().selectOne("tc.list");
	  }
	 
	 
	 
}