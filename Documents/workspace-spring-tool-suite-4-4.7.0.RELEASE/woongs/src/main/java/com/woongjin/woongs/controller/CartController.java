package com.woongjin.woongs.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.woongjin.woongs.model.BuyListDto;
import com.woongjin.woongs.model.CartDto;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService service;

	@RequestMapping(value = "/cart", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String insertCart(int post_no, HttpServletRequest request) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("post_no", Integer.toString(post_no));
		map.put("user_id", (String) request.getSession().getAttribute("user_id"));
		System.out.println("post_no : " + post_no);
		service.insertCart(map);

		return "main";
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String buy(HttpServletRequest request, String[] report) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");
	
		for (int i = 0; i < report.length; i++) {
			System.out.println(report[i] + "가져와주라");
		}

		Map<String, String> map = new HashedMap<String, String>();
		map.put("user_id", user_id);

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("buy_date", format.format(now));
		
		for (int i = 0; i < report.length; i++) {
			map.put("post_no", report[i]);
			service.buy(map);
		}
		List<BuyListDto> buyList = new ArrayList<BuyListDto>();
		for(int i=0; i<report.length; i++) {
			 buyList.add(service.showBuy(report[i]));	
		}
		request.getSession().setAttribute("buyList", buyList);
		
		return "buyer/buy";
	}
	
	
	@RequestMapping(value = "/buylist", method = RequestMethod.GET)
	public String buylist(HttpSession session) throws Exception {
		String user_id = (String) session.getAttribute("user_id");
		
		List<BuyListDto> list = service.showRecentBuyList(user_id);
		session.setAttribute("recentBuyList", list);
		
		return "buyer/addlist";
	}
	@RequestMapping(value = "/showbuy", method = RequestMethod.POST)
	public void showbuy(HttpServletResponse resp, HttpServletRequest request) throws Exception {
		String post_no = (String) request.getSession().getAttribute("user_id");
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("post_no", post_no);
		
		service.showBuy(post_no);
		
	}
	
	
	@RequestMapping(value = "/wishList", method = RequestMethod.GET)
	public String wishList() throws Exception {
		return "/wishlist";
	}

	// wish load
	@RequestMapping(value = "/wishList", method = RequestMethod.POST)
	public void wishList(HttpServletResponse resp, HttpServletRequest request) throws Exception {
		// session;
		String user_id = (String) request.getSession().getAttribute("user_id");

		List<PostDto> list = service.getWishList(user_id);
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print(json.toJson(list));
	}

	@RequestMapping(value = "/deleteCart", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String deleteCart(HttpServletRequest request, String[] report) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");

		for (int i = 0; i < report.length; i++) {
			System.out.println(report[i] + " ");
		}

		Map<String, String> map = new HashedMap<String, String>();
		map.put("user_id", user_id);

		for (int i = 0; i < report.length; i++) {
			map.put("report", report[i]);
			service.deleteCart(map);
			map.remove("report");
		}

		return "wishlist";
	}

	@RequestMapping(value = "/checkNum", method = RequestMethod.GET)  //??
	public void checkNum() throws Exception {
	}

	
	@RequestMapping(value = "/check", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String check(HttpServletRequest request, CartDto dto) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");
		Map<String, Object> paramMap = new HashMap();
		
		paramMap.put("user_id", user_id);
		paramMap.put("post_no", dto.getPost_no());
		try {
			service.check(paramMap);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping(value = "/check_cancel", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	 @ResponseBody 
	public String check_Cancel(HttpServletRequest request, CartDto dto) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");
		Map<String, Object> paramMap = new HashMap();
		
		paramMap.put("user_id", user_id);
		paramMap.put("post_no", dto.getPost_no());
		try {
			service.check_cancel(paramMap);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
	
	

}
