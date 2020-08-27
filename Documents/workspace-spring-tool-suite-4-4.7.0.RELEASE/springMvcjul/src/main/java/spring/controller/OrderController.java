package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/view/order/order.do")
public class OrderController {

//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		return "view/order/orderForm";
	}

//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String submit(OrderCommand orderCommand) {
		return "view/order/orderCompletion";
	}
}