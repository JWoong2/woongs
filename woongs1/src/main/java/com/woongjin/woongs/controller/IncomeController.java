package com.woongjin.woongs.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woongjin.woongs.service.IncomeService;

@Controller
public class IncomeController {

	@Autowired
	IncomeService incomeService;
	@RequestMapping(value = "/income", method = RequestMethod.GET)
	public String manageIncome() {
		return "manageIncome";
	}
	
	@RequestMapping(value = "/findIncomeByUserId", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> findIncomeByUserId( HttpServletRequest request ) {
		
		String userId = (String) request.getSession().getAttribute("user_id");
		
		userId = "LDS";
		Map<String, Object >map = new HashMap<>();
		map.put("USER_ID", userId);
		return incomeService.findIncomeById(map);
	}
	
	@RequestMapping(value = "/findAccountInfoByUserId", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> findAccountInfoByUserId( HttpServletRequest request ) {
		
		String userId = (String) request.getSession().getAttribute("user_id");
		
		userId = "LDS";
		Map<String, Object >map = new HashMap<>();
		map.put("USER_ID", userId);
		return incomeService.findAccountInfoByUserId(map);
	}
	
	
}
