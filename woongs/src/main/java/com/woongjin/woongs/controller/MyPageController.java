package com.woongjin.woongs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.woongjin.woongs.model.EstimateDto;
import com.woongjin.woongs.model.MyPageDao;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.QuoteDto;
import com.woongjin.woongs.service.MyPageService;
import com.woongjin.woongs.service.PostService;

@Controller
public class MyPageController {
	@Autowired
	MyPageService service;

	@Autowired
	PostService post;
	
	public void setService(MyPageService service) {
		this.service = service;
	}

	@RequestMapping(value = "/buyer")
	public String buyerMyPage() {
		return "buyer/order";
	}

	@RequestMapping(value = "/seller")
	public String sellerMyPage() {
		return "seller/selling_history";
	}

	@RequestMapping(value = "/sentEstimate")
	public ModelAndView viewEstimate(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String user_id = (String) session.getAttribute("user_id");

		List<EstimateDto> list = service.selectEstimate(user_id);
		List<PostDto> postlist = new ArrayList<PostDto>();
		
		for(int i=0; i<list.size(); i++) {
			postlist.add(post.getPosts(list.get(i).getNo()));
		}
		
		mav.addObject("postList", postlist);
		mav.addObject("estimateList", list);
		mav.setViewName("seller/sentEstimate");

		return mav;
	}
	
	@RequestMapping(value = "/myService")
	public ModelAndView viewMyPost(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<PostDto> list = post.getPostsById((String)request.getSession().getAttribute("user_id"));
		
		mav.addObject("postList", list);
		mav.setViewName("seller/myService");
		return mav;
	}
	
}
