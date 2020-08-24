package com.woongjin.woongs.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CartDao extends SqlSessionDaoSupport {

	public List<CartDto> getCartList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.cart");
	}
	
	public void insertCart (CartDto dto) {
		getSqlSession().insert("CartMapper.insertCart",dto);
	}

	public List<PostDto> getWishList(String user_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("CartMapper.wishList", user_id);
	}
	
	public void deleteCart (Map<String, String> map) {
		getSqlSession().delete("CartMapper.deleteCart",map);
	}
	
}
