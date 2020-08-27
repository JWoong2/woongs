package com.woongjin.woongs.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woongjin.woongs.service.UserEmailService;
import com.woongjin.woongs.service.UserService;

import randomWord.RandomWord;

import com.fasterxml.jackson.databind.JsonNode;
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
			email.setSubject("비밀번호 오류입니다");
			email.setContent("인증번호는 : " + temp.toString());

			boolean result = emailService.sendMail(email);

			request.getSession().setAttribute("user_id", vo.getEmail());
			return "member/code";

		} else {
			return "member/findFalse";
		}

	}

	@RequestMapping(value = "/kakaologinTEST", method = RequestMethod.GET)
	public String getkakaoLogin(@RequestParam("code") String code) throws Exception {
		System.out.println("code : " + code);
		return "main";
	}
	@RequestMapping(value = "/kakaologin", produces = "application/json", method = { RequestMethod.GET,
			RequestMethod.POST })
	public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		// 결과값을 node에 담아줌
		JsonNode node = KakaoController.getAccessToken(code);

		// accessToken에 사용자의 로그인한 모든 정보가 들어있음
		JsonNode accessToken = node.get("access_token");

		// 사용자의 정보
		JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
		System.out.println(userInfo);
		String email = null;
		String user_name = null;
		String gender = null;
		String birthday = null;
		String age = null;
		String image = null;
		// 유저정보 카카오에서 가져오기 Get properties
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");

		email = kakao_account.path("email").asText();
		System.out.println(email);
		user_name = properties.path("nickname").asText();
		System.out.println(user_name);
		image = properties.path("profile_image").asText();
		System.out.println(image);
		gender = kakao_account.path("gender").asText();
		System.out.println(gender);
		birthday = kakao_account.path("birthday").asText();
		System.out.println(birthday);
		age = kakao_account.path("age_range").asText();
		System.out.println(age);
		String thumbnail = kakao_account.path("thumbnail_image").asText();
		System.out.println(thumbnail);

		int x = service.IsUser(email);
		System.out.println("already user ? : " + x);
		UserDto dto = new UserDto();
		dto.setUser_name("");
		dto.setEmail(email);

		dto.setUser_name(user_name);
		dto.setImage(thumbnail);

		System.out.println(dto);

        // JsonNode트리형태로 토큰받아온다
        JsonNode jsonToken = KakaoController.getKakaoAccessToken(code);
        // 여러 json객체 중 access_token을 가져온다
        accessToken = jsonToken.get("access_token");
 
        System.out.println("access_token : " + accessToken);
		
		userInfo = KakaoController.getKakao_UserInfo(accessToken);

		// Get id
		String id = userInfo.path("id").asText();
		String name = null;
		email = null;
        
		// 유저정보 카카오에서 가져오기 Get properties
		JsonNode properties2 = userInfo.path("properties");
		JsonNode kakao_account2 = userInfo.path("kakao_account");

		name = properties2.path("nickname").asText();
		email = kakao_account2.path("email").asText();

		System.out.println("id : " + id);
		System.out.println("name : " + name);
		System.out.println("email : " + email);

//		if (x == 0) {
//			service.register(dto);
//			request.getSession().setAttribute("userInfo", dto);
//			request.getSession().setAttribute("user_id", email);
//		} else {
//			request.getSession().setAttribute("userInfo", dto);
//			request.getSession().setAttribute("user_id", email);
//		}

		mav.setViewName("main");
		return mav;
	}// end kakaoLogin()

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
			} else {
				request.getSession().setAttribute("admin", false);
			}

			request.getSession().setAttribute("userInfo", dto);

			return "main";
		} else {
			return "member/loginFalse";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
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

		service.updateCode(map);

		return "member/updateDone";
	}

	@RequestMapping(value = "/callbackTEST")
	public String navLogin(HttpServletRequest request) throws Exception {
		return "callback";
	}

	@RequestMapping(value = "/callback")
	public void personalInfo(HttpServletRequest request) throws Exception {
		String token = "AAAAOAFvUr6A81Tzn_Jo3SrCkWt35va719qFkaK0g-l9xgxVVIUbzrX84NlGOmxsutH6ZqWPXvyL8Jfia8wlv38wGyc";// 네이버로그인접근토큰;여기에복사한토큰값을넣어줍니다.
		String header = "Bearer " + token; // Bearer 다음에 공백 추가
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println("info : response " + response.toString());

			JSONObject jsonObject = null;

			try {
				jsonObject = new JSONObject(response.toString());
			} catch (JSONException err) {
				System.out.println(err);
			}

			System.out.println(jsonObject);

			JSONObject userInfo = jsonObject.getJSONObject("response");

			String email = (String) userInfo.get("email");
			String nick_name = (String) userInfo.get("nickname");
			String user_name = (String) userInfo.get("name");

			System.out.println("email : " + email);

			int x = service.IsUser(email);
			System.out.println("already user ? : " + x);
			UserDto dto = new UserDto();
			dto.setUser_name(user_name);
			dto.setEmail(email);
			dto.setNick_name(nick_name);
			dto.setImage("resources/default.png");

			System.out.println(dto);

			if (x == 0) {
				service.register(dto);
				request.getSession().setAttribute("userInfo", dto);
				request.getSession().setAttribute("user_id", email);
			} else {
				request.getSession().setAttribute("userInfo", dto);
				request.getSession().setAttribute("user_id", email);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}