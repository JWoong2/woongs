package com.woongjin.woongs.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;

import com.woongjin.woongs.service.UserEmailService;
import com.woongjin.woongs.service.UserService;
import com.woongjin.woongs.model.CartDto;
import com.woongjin.woongs.model.EmailDto;
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
	      vo.setImage("default.png");
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

	// 패스워드 찾기 post
		@RequestMapping(value = "/findTEST", method = RequestMethod.POST)
		public ModelAndView postFindTEST(UserDto vo) throws Exception {
			System.out.println("들어옴" + vo.getUser_name() + " " + vo.getEmail());
			int x = service.userPassFind(vo);
			
			ModelAndView mv = new ModelAndView();
			
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

				mv.addObject("user_id", vo.getEmail());
				mv.addObject("code", temp.toString());
				
				String receiver = vo.getEmail();

				EmailDto email = new EmailDto();

				email.setReceiver(receiver);
				email.setSubject("비밀번호도 까먹냐 ㅋㅋ");
				email.setContent("사랑합니다. 저거 인증번호는 이겁니다 : " + temp.toString());

				//boolean result = emailService.sendMail(email);

				mv.setViewName("member/code");
				return mv ;

			} else {
				
				mv.setViewName("member/findFalse");
				return mv ;
			}

		}

	
	// 로그인 페이지 이동 get
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() throws Exception {
		return "member/login";
	}

	// 로그인 폼 입력 후 post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpSession session, UserDto vo) throws Exception {
		UserDto dto = service.userLogin(vo);

		if (dto != null) {
			session.setAttribute("user_id", dto.getEmail());

			if (dto.getIsAdmin() == 1) {
				session.setAttribute("admin", true);
				System.out.println(session.getAttribute("admin"));
			} else {
				session.setAttribute("admin", false);
			}

			List<Integer> cart =  service.selectWishList(dto.getEmail());
			System.out.println(cart.size());
			session.setAttribute("userInfo", dto); 
			session.setAttribute("wishlist", cart); 
			return "main";
		} else {
			return "member/loginFalse";
		}
	}

	// 코드입력 post
	@RequestMapping(value = "/code", method = RequestMethod.POST)
	public String postCode(HttpServletRequest request, String code) throws Exception {
		/*
		 * String user_id = (String) request.getSession().getAttribute("user_id");
		 * 
		 * Map<String, String> map = new HashMap<String, String>(); map.put("user_id",
		 * user_id); map.put("code", code); int x = service.insertCode(map);
		 * 
		 * if (x == 1) { service.deleteCode(map);
		 */
			return "member/update";
			/*
			 * } else { return "member/codeFalse"; }
			 */
	}

	// 코드입력 post

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String postUpdate(HttpServletRequest request, String password) throws Exception {
		String user_id = (String) request.getSession().getAttribute("user_id");

		Map<String, String> map = new HashMap<String, String>();
		map.put("user_id", user_id);
		map.put("password", password);

		System.out.println("id" + map.get("user_id"));
		System.out.println("pw" + map.get("password"));

		service.updateCode(map);

		return "member/updateDone";
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "main";
    }

}