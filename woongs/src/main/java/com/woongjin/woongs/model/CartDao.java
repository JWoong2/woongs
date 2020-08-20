package com.woongjin.woongs.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CartDao extends SqlSessionDaoSupport {

	public List<CartDto> getCartList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.cart");
	}
	
	public void insertCart (Map<String, String> map) {
		getSqlSession().insert("CartMapper.insertCart",map);
	}

	public List<PostDto> getWishList(String user_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("CartMapper.wishList", user_id);
	}
	
	public void deleteCart (Map<String, String> map) {
		getSqlSession().delete("CartMapper.deleteCart",map);
	}

	public int getCheck(CartDto dto) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("CartMapper.checkNum", dto);
	}

	public void check_cancel(Map<String, Object> map) {
		// TODO Auto-generated method stub
		getSqlSession().delete("CartMapper.check_cancel",map);
		
	}

	public void check(Map<String, Object> Map) {
		// TODO Auto-generated method stub
		getSqlSession().insert("CartMapper.check",Map);
	}
	
	
	
	
	
}
