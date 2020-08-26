package com.woongjin.woongs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.EstimateDao;
import com.woongjin.woongs.model.EstimateDto;
import com.woongjin.woongs.model.Sub_TagDto;



@Service
public class EstimateService {

	
	@Autowired
	EstimateDao ed;
	
	public void estimateAdd(EstimateDto edto){
		ed.estimateAdd(edto);
	}
	
	public List<EstimateDto> estimateAll(){
		return ed.estimateAll();
	}
	
	public List<EstimateDto> estimateSelect(int no){
		return ed.estimateSelect(no);
	}
	
	public void estimateUpdate(EstimateDto edto){
		 ed.estimateUpdate(edto);
	}
	
	public void estimateDelete(int no) {
		 ed.estimateDelete(no);
	}

	public EstimateDao getEd() {
		return ed;
	}

	public void setEd(EstimateDao ed) {
		this.ed = ed;
	}

	
	
}
