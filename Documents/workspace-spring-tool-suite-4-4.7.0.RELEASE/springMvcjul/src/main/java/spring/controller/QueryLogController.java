package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.model.QueryLogCommand;

@Controller
public class QueryLogController {

	@ModelAttribute("command")
	public QueryLogCommand formBacking() {
		return new QueryLogCommand();
	}

	@RequestMapping("/log/query.do")
	public String query(@ModelAttribute("command") QueryLogCommand command, BindingResult result) {
		return "log/logList";
	}
}