package com.woongjin.woongs.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ProposalDao extends SqlSessionDaoSupport{

	public void insertFiles(Map<String, Object> map) {
		// TODO Auto-generated method stub
		getSqlSession().insert("ProposalMapper.insertProposalFile", map);
	}

	public List<ProposalDto> getProposalsById(String user_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("ProposalMapper.getProposalsById", user_id);
	}

	public List<ProposalDto> getProposalsByNo(int post_no) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("ProposalMapper.getProposalsByNo", post_no);
	}

	public String getOriginalName(int idx) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("ProposalMapper.getOriginalName", idx);
	}

	public String getAlterpath(int idx) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("ProposalMapper.getAlterpath", idx);
	}
	
}
