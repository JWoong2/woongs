package com.woongjin.woongs.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.google.gson.Gson;
import com.woongjin.woongs.model.CartDto;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService service;

	@RequestMapping(value = "/cart", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void insertCart(CartDto dto) throws Exception {
		System.out.println("id : " + dto.getUser_id());
		service.insertCart(dto);
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String Show() throws Exception {
		return "/show";
	}

	// wish load
	@RequestMapping(value = "/wishList", method = RequestMethod.POST)
	public void wishList(HttpServletResponse resp) throws Exception {
		//session;
	
		String user_id = "dongtae141asdf";
		
		System.out.println("들어옴");
		
		List<PostDto> list = service.getWishList(user_id);
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print(json.toJson(list));
	}
	
	
	@RequestMapping(value = "/deleteCart", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String deleteCart(HttpServletRequest request, String[] report) throws Exception {
//		String user_id = (String) request.getSession().getAttribute("user_id");
		System.out.println("deleteCart 입뉘다");
		
		for(int i=0; i<report.length; i++) {
			System.out.println(report[i] + " ");
		}
		
		Map<String, String> map = new HashedMap<String, String>();
		map.put("user_id", "dongtae141asdf");
		
		for(int i=0; i<report.length; i++) {
			map.put("report", report[i]);
			service.deleteCart(map);	
			map.remove("report");
		}
		
		return "show";
	}
	

}
