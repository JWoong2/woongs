package com.woongjin.woongs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.BuyListDto;
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

public void insertCart(Map<String, String> map) {
	// TODO Auto-generated method stub
	dao.insertCart(map);
}

public List<PostDto> getWishList(String user_id) {
	// TODO Auto-generated method stub
	return dao.getWishList( user_id);
}

public void deleteCart(Map<String, String> map) {
	// TODO Auto-generated method stub
	dao.deleteCart(map);
}

public void check(Map<String, Object> paramMap) {
	// TODO Auto-generated method stub
	dao.check(paramMap);
	}

public void check_cancel(Map<String, Object> paramMap) {
	// TODO Auto-generated method stub
	dao.check_cancel(paramMap);
	}


public void buy(Map<String, String> map) {
	// TODO Auto-generated method stub
	dao.buy(map);
}

public BuyListDto showBuy(String post_no) {
	// TODO Auto-generated method stub
	return dao.showBuy(post_no);
}

public List<BuyListDto> showRecentBuyList(String user_id) {
	// TODO Auto-generated method stub
	return dao.showRecentBuyList(user_id);
}


}