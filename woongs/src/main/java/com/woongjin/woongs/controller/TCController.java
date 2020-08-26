package com.woongjin.woongs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.woongjin.woongs.model.TCDto;
import com.woongjin.woongs.model.TCListModel;
import com.woongjin.woongs.service.TCService;

import com.woongjin.woongs.service.TCService;

@Controller
public class TCController {
	
	@Autowired
	TCService service;
	
	/*
	 * @RequestMapping(value = "/tcmain", method = RequestMethod.GET) public String
	 * TCList() { return "tcmain"; }
	 */
	
	
	/*
	 * @RequestMapping(value = "/tcwriteForm", method = RequestMethod.GET) public
	 * String writeForm() { return "tcwriteForm"; }
	 * 
	 * 
	 * @RequestMapping(value = "tcwriteForm", method = RequestMethod.POST) public
	 * String addtc(TCDto dto, HttpSession request) { String admin_id = (String)
	 * request.getAttribute("user_id"); dto.setAdmin_id(admin_id);
	 * 
	 * service.insertTc(dto); System.out.println(dto); return "redirect:/tcmain";
	 * 
	 * }
	 */
	
	@GetMapping("/tcwriteForm")
	public String writeForm(@ModelAttribute("dto") TCDto dto) {
		return "tcwriteForm";
	}
	
	@GetMapping("/tccontent")
	public String content(@RequestParam(value = "p") int pageNum, int no, Model m) {
		TCDto dto = service.getcontent(no);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum", pageNum);
		return "tccontent";
	}
	
	@GetMapping("/tcupdateForm")
	public String updateForm(int no, int p, Model m) {
		TCDto dto = service.update(no);
		m.addAttribute("article", dto);
		m.addAttribute("pageNum", p);
		return "tcupdateForm";
	}
	
	
	@GetMapping("/tcdeleteForm") 
	public String deleteForm(int no, int p, Model m){ 
	m.addAttribute("no", no); 
	m.addAttribute("pageNum", p);
	  
	  return "tcdeleteForm"; }
	 
	
	@GetMapping("/tcmain")
	public String list(@RequestParam(value = "p", defaultValue = "1") int pageNum,
			@RequestParam(value = "per", defaultValue = "10") int per, Model m) {
		// System.out.println("per::"+per);
		TCListModel list = service.list(pageNum, per);
		m.addAttribute("list", list);
		int number = list.getCount() - (pageNum - 1) * per;
		m.addAttribute("number", number);
		return "tcmain";
	}
	
	// put 메소드
	@PutMapping("/tcmain")
	public String update(TCDto dto) {
		System.out.println(dto.getNo() + dto.getContent());
		service.update(dto);

		return "redirect:/tcmain";
	}
	
	// post 메소드	
	@PostMapping("/tcmain")
	public String write(TCDto dto, HttpServletRequest request) {
		System.out.println("tcMain write form : " + dto.getSubject());
		service.insert(dto, request);
		
		return "redirect:/tcmain";
	}
	
	
	
	 @DeleteMapping("/tcmain/{no}") 
	 public String delete(@PathVariable("no") int no) {
		 System.out.println("no::"+no);
		 service.delete(no);
		 return "redirect:/tcmain";
	 }
	 
	
	/*
	 * @RequestMapping(value = "/tcdeleteForm", method = RequestMethod.GET) public
	 * String delete(@RequestParam(value ="no") int no) { service.delete(no); return
	 * "redirect:/tcmain"; }
	 */
	 
	
	/*
	 * @RequestMapping(value = "/tcdeleteForm", method = RequestMethod.GET) public
	 * String delete(HttpServletRequest request, RedirectAttributes attr, int no) {
	 * service.delete(request, no); attr.addFlashAttribute("msg","삭제"); return
	 * "redirect:/tcmain"; }
	 */
	
	public void setService(TCService service) {
		this.service = service;
	}
}
