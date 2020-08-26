package com.woongjin.woongs.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.woongjin.woongs.service.UserEmailService;
import com.woongjin.woongs.service.UserService;

import randomWord.RandomWord;

import com.mysql.cj.Session;
import com.woongjin.woongs.model.EmailDto;
import com.woongjin.woongs.model.UserDao;
import com.woongjin.woongs.model.UserDto;

@Controller
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	UserEmailService emailService;
	@Autowired
	protected JavaMailSender mailSender;

	// 회원가입 get
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() throws Exception {
		return "member/register";
	}

	// 회원가입 post
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(UserDto vo) throws Exception {
		RandomWord rd = new RandomWord();
		int count = service.getUserCount();
		
		vo.setImage("resources/default.png");
		vo.setNick_name(rd.getAdjective() + rd.getNoun() + count);
		service.register(vo);
		return "member/registerDone";
	}

	// 패스워드 찾기 get
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String getFind() throws Exception {
		return "member/find";
	}

	// 패스워드 찾기 post
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public String postFind(UserDto vo, HttpServletRequest request) throws Exception {
		System.out.println("들어옴" + vo.getUser_name() + " " + vo.getEmail());
		int x = service.userPassFind(vo);
		System.out.println("x : " + x);
		if (x == 1) {
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 16; i++) {
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}

			Map<String, String> map = new HashMap<String, String>();
			map.put("user_id", vo.getEmail());
			map.put("code", temp.toString());

			service.sendCode(map);

			String receiver = vo.getEmail();

			EmailDto email = new EmailDto();

			email.setReceiver(receiver);
			email.setSubject("비밀번호도 까먹냐 ㅋㅋ");
			email.setContent("사랑합니다. 저거 인증번호는 이겁니다 : " + temp.toString());

			boolean result = emailService.sendMail(email);

			request.getSession().setAttribute("user_id", vo.getEmail());
			return "member/code";

		} else {
			return "member/findFalse";
		}

	}

	// 로그인 페이지 이동 get
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() throws Exception {
		return "member/login";
	}

	// 로그인 폼 입력 후 post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request, UserDto vo) throws Exception {
		System.out.println("들어옴" + vo.getEmail() + " " + vo.getPassword());
		UserDto dto = service.userLogin(vo);

		if (dto != null) {
			request.getSession().setAttribute("user_id", vo.getEmail());

			if (vo.getIsAdmin() == 1) {
				request.getSession().setAttribute("admin", true);
				return "../index";
			} else {
				request.getSession().setAttribute("admin", false);
			}

			request.getSession().setAttribute("userInfo", dto);
			
			return "main";
		} else {
			return "member/loginFalse";
		}
	}

	// 코드입력 post
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public String postCode(HttpServletRequest request, String code) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("code", code);
		int x = service.insertCode(map);

		if (x == 1) {
			service.deleteCode(map);
			return "member/update";
		} else {
			return "member/codeFalse";
		}
	}

	// 코드입력 post
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(HttpServletRequest request, String password) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("password", password);
		System.out.println("들어옴" + user_id);
		service.updateCode(map);
		System.out.println(password);
		return "member/updateDone";
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "main";
    }
	// 탈퇴페이지 이동 get
	@RequestMapping(value = "/userDelete", method = RequestMethod.GET)
	public String userDelete() throws Exception {
		return "member/signout";
	}
	
	@RequestMapping(value="/userDelete", method = RequestMethod.POST)
	public String userDelete(HttpSession session,HttpServletRequest request, UserDto vo, String password) throws Exception {
		System.out.println("pass"+vo.getEmail());
		System.out.println(vo.toString());
		System.out.println("pass"+vo.getPassword());
		
		String pass = vo.getPassword();
		String passwordchk = request.getParameter("password");
		if(!(pass.equals(passwordchk))) {
			System.out.println("비밀번호가 틀립니다");
			return "member/signout";
		}
			service.userDelete(vo);
			session.invalidate();
			return "main";
		
		}
	
	
}
