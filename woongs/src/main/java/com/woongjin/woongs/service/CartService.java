package com.woongjin.woongs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.CartDao;
import com.woongjin.woongs.model.CartDto;
import com.woongjin.woongs.model.PostDto;


@Service
public class CartService {

@Autowired
CartDao dao;

public void setDao(CartDao dao) {
	this.dao = dao;
	}

public void insertCart(CartDto dto) {
	// TODO Auto-generated method stub
	dao.insertCart(dto);
}

public List<PostDto> getWishList(String user_id) {
	// TODO Auto-generated method stub
	return dao.getWishList( user_id);
}
public void deleteCart(Map<String, String> map) {
	// TODO Auto-generated method stub
	dao.deleteCart(map);
}


}