package com.woongjin.woongs.model;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class EstimateDao extends SqlSessionDaoSupport {
	
	public void estimateAdd(EstimateDto edto){
		 getSqlSession().insert("estimate.estimateAdd",edto);
	}
	
	public List<EstimateDto> estimateAll(){
		return getSqlSession().selectList("estimate.estimateAll");
	}
	
	
	public List<EstimateDto> estimateSelect(int no){
		return getSqlSession().selectList("estimate.estimateSelect", no);
	}
	
	public void estimateUpdate(EstimateDto edto){
	    getSqlSession().update("estimate.estimateUpdate",edto);
	}
	
	public int estimateDelete(int no) {
		return getSqlSession().delete("estimate.estimateDelete",no);
	}
}
