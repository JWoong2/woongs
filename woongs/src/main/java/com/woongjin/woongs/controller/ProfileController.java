package com.woongjin.woongs.controller;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.woongjin.woongs.model.CareerDto;
import com.woongjin.woongs.model.CertiDto;
import com.woongjin.woongs.model.ProfileDto;
import com.woongjin.woongs.model.ProfileMainDto;
import com.woongjin.woongs.model.SubTagDto;
import com.woongjin.woongs.model.TagDto;
import com.woongjin.woongs.model.TagNameDto;
import com.woongjin.woongs.service.ProfileService;

@Controller
public class ProfileController {

	@Autowired
	ProfileService profile;

	@RequestMapping("/introduction")
	public String profile() {
		return "introduction";
	}

	@RequestMapping("/profileMain")
	public String profileMain(HttpSession session, Model m) {
		String user_id = (String) session.getAttribute("user_id");
		System.out.println(user_id);
		ProfileMainDto dto = profile.profileMain(user_id);

		m.addAttribute("dto", dto);

		System.out.println(user_id);

		session.setAttribute("user_profile", dto);

		return "profileMain";

	}

	   @RequestMapping("/intro")
	   public String pulsIntro(String nick_name, String introduce, MultipartFile report, HttpServletRequest request,Model m) {
	      Map<String, String> map = new HashMap<String, String>();

	      // 이미지 경로 저장위치에 따라 바꿔야함
	      String path = "C:\\Users\\gusql\\Documents\\workspace-spring-tool-suite-4-4.7.0.RELEASE\\profile\\src\\main\\webapp\\resources\\Images";
	      String alterpath = "resources\\Images\\";

	      File file = new File(path);

	      if (!file.exists()) {
	         file.mkdirs();
	      }

	      path += "\\" + report.getOriginalFilename();
	      alterpath += report.getOriginalFilename();

	      file = new File(path);

	      try {
	         report.transferTo(file);
	      } catch (IllegalStateException | IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      String user_id = (String) request.getSession().getAttribute("user_id");
	      // String user_id = "jun"; 테스트용

	      map.put("nick_name", nick_name);
	      map.put("introduce", introduce);
	      map.put("image", alterpath);
	      map.put("user_id", user_id);

	      profile.updateintro(map);
	      
	      
	      ProfileMainDto dto1 =  profile.selectprofile(user_id);
	      System.out.println(dto1.getIntroduce());
	      m.addAttribute("dto1",dto1);

	      return "specialForm";
	   }

	// 상위 카톄고리
	@RequestMapping(value = "/tags", method = RequestMethod.POST)
	public void tagList(HttpServletResponse resp) throws Exception {
		List<TagDto> list = profile.selectTags();
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}

	// 하위 카테고리
	@RequestMapping(value = "/sub_tags", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String tagList(int tag_no) throws Exception {
		List<SubTagDto> list = profile.selectSub_tags(tag_no);
		Gson json = new Gson();
		System.out.println(json.toJson(list));
		return json.toJson(list);
	}

	// 카테고리 폼
	@RequestMapping(value = "/specialtag", method = RequestMethod.POST)
	public String pulsUpdate(int tag, int sub_tag, HttpServletRequest request) {
		ProfileDto dto = new ProfileDto();
		String user_id = (String) request.getSession().getAttribute("user_id");
		// String user_id = "jun";
		dto.setUser_id(user_id);
		dto.setTag(tag);
		dto.setSub_tag(sub_tag);

		profile.updatetag(dto);

		return "skillForm";
	}

	// 카테고리 설정 완료시 ajax로 값 표시
	@RequestMapping(value = "/sub_tagOne", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String sub_tagOne(int no) throws Exception {
		TagNameDto list = profile.selectTag(no);
		Gson json = new Gson();
		return json.toJson(list);
	}

	// 보유 기술
	@RequestMapping("/skill")
	public String pulsSkill(String skill, HttpServletRequest request) {
		ProfileDto dto = new ProfileDto();
		String user_id = (String) request.getSession().getAttribute("user_id");

		// String user_id = "jun";
		dto.setUser_id(user_id);
		dto.setSkill(skill);

		profile.updateskill(dto);

		return "updateForm";
	}

	@RequestMapping("/updateForm")
	public String updateform() {
		return "updateForm";
	}

	@RequestMapping("/certiForm")
	public String certiForm() {
		return "certiForm";
	}

	@RequestMapping("/careerForm")
	public String careerform() {
		return "careerForm";
	}

	// 전공, 대학교, 대학교 졸업 유무 부분. /* @수정 완료@ */
	@RequestMapping(value = "/univtags", method = RequestMethod.POST)
	public String univupdate(ProfileDto dto, HttpSession request) {

		String user_id = (String) request.getAttribute("user_id");
		dto.setUser_id(user_id);
		profile.updateunivtag(dto);

		return "certiForm";
	}

	// 자격증 수정항목 부분
	@RequestMapping(value = "/certi", method = RequestMethod.POST)
	public String CertiUpdate(CertiDto dto, HttpSession request) {

		String user_id = (String) request.getAttribute("user_id");
		dto.setUser_id(user_id);
		profile.updatecerti(dto);
		System.out.println(dto);

		return "careerForm";
	}

	// 회사명, 부서명, 직위, 년월 부분
	@RequestMapping(value = "/career", method = RequestMethod.POST)
	public String CareerUpdate(CareerDto dto, HttpSession request) {

		String user_id = (String) request.getAttribute("user_id");
		System.out.println(user_id);
		dto.setUser_id(user_id);

		profile.updatecareer(dto);

		return "redirect:/profileMain";
	}
}