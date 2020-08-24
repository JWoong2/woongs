package com.woongjin.woongs.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.SubTagDto;
import com.woongjin.woongs.model.TagDto;
import com.woongjin.woongs.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService post;

	// post upload
	@RequestMapping("/upload")
	public String upload() {
		return "postUpload";
	}

	// tag load
	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	public void tagList(HttpServletResponse resp) throws Exception {
		List<TagDto> list = post.getTagList();
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print(json.toJson(list));
	}

	// sub tag load
	@RequestMapping(value = "/subtag", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String subtagList(int tag_no) throws Exception {
		List<SubTagDto> list = post.getSubTagList(tag_no);
		Gson json = new Gson();
		return json.toJson(list);
	}

	// create service == post page move
	@RequestMapping(value = "/createService", method = RequestMethod.GET)
	public ModelAndView createPost(HttpSession session) {
		ModelAndView mav = new ModelAndView();

		// 최근 생성한 세션값을 해제
		session.removeAttribute("recent_post");
		mav.setViewName("seller/createServiceForm");

		return mav;
	}

	// post insert
	@RequestMapping(value = "/insertPost", method = RequestMethod.POST)
	public String insertPost(HttpSession session, PostDto dto, MultipartFile report) {
		dto.setUser_id((String) session.getAttribute("user_id"));

		if (report != null) {
			String path = "C:\\Users\\asd35\\Documents\\project-spring-workspace\\woongs\\src\\main\\webapp\\resources\\Images";
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

			dto.setThumbnail(alterpath);
		}
		post.insertPost(dto);
		session.setAttribute("recent_post", (PostDto) post.getRecentPostById((String) session.getAttribute("user_id")));

		return "seller/createServiceForm";
	}

	// create service == post page move
	@RequestMapping(value = "/updateService", method = RequestMethod.GET)
	public ModelAndView updatePost(HttpSession session, int no) {
		ModelAndView mav = new ModelAndView();

		PostDto dto = post.getPosts(no);

		session.setAttribute("recent_post", dto);
		mav.setViewName("seller/createServiceForm");

		return mav;
	}

	// post update
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public String updatePost(HttpSession session, PostDto dto, MultipartFile report) {
		// 다음 단계 혹은 수정할때 사용되는 곳
		if (session.getAttribute("recent_post") == null) {
			// 세션 만료 오류 처리
			System.out.println("이잉? 없는 걸 업데이트 하려고하는데?");
		} else {
			dto.setUser_id((String) session.getAttribute("user_id"));
			PostDto updateDto = (PostDto) session.getAttribute("recent_post");
			switch (dto.getStatus()) {
			case 1:
				updateDto.setCategory_first(dto.getCategory_first());
				updateDto.setCategory_second(dto.getCategory_second());
				updateDto.setTitle(dto.getTitle());
				updateDto.setDescription(dto.getDescription());
				updateDto.setPrice(dto.getPrice());
				updateDto.setWorktime(dto.getWorktime());
				updateDto.setRetouch_count(dto.getRetouch_count());
				updateDto.setStatus(dto.getStatus());
				break;
			case 2:
				updateDto.setService_description(dto.getService_description());
				updateDto.setStatus(dto.getStatus());
				break;
			case 3:
				if (report != null) {
					String path = "C:\\Users\\asd35\\Documents\\project-spring-workspace\\woongs\\src\\main\\webapp\\resources\\Images";
					String alterpath = "resources/Images/";

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

					updateDto.setThumbnail(alterpath);
				}else {
					System.out.println("이미지 에러");
				}
				updateDto.setStatus(dto.getStatus());
				break;
			case 4:
				updateDto.setRequirement(dto.getRequirement());
				updateDto.setStatus(dto.getStatus());
				break;
			}

			post.updatePost(updateDto);
			session.setAttribute("recent_post", updateDto);
		}

		if(dto.getStatus() == 4) {
			return "main";	
		}else {
			return "seller/createServiceForm";	
		}
	}

	// post viewByUser_id
	@RequestMapping(value = "/post", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String postViewByNo(HttpServletRequest request, int no) throws Exception {
		PostDto dto = post.getPosts(no);
		dto.setThumbnail(dto.getThumbnail().replace('\\', '/'));
		request.setAttribute("post", dto);

		return "post";
	}

	// get all recent post
	@RequestMapping(value = "/post", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String postList() throws Exception {
		List<PostDto> list = post.getPosts();

		for (PostDto dto : list) {
			dto.setThumbnail(dto.getThumbnail().replace('\\', '/'));
		}

		Gson json = new Gson();
		return json.toJson(list);
	}

	// get all recent post viewByCategory
	@RequestMapping(value = "/category", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String categoryList(HttpServletRequest request, int no) throws Exception {
		List<PostDto> list = post.getPostsByTag(no);

		for (PostDto post : list) {
			if(post.getStatus() == 4) {
				post.setThumbnail(post.getThumbnail().replace('\\', '/'));	
			}
		}

		request.setAttribute("post", list);

		return "category";
	}

	@RequestMapping(value = "/subcategory", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String subcategoryList(HttpServletRequest request, SubTagDto dto) throws Exception {
		System.out.println(dto.getNo() + " " + dto.getTag_no());
		List<PostDto> list = post.getPostsBySubTag(dto);
		
		for (PostDto post : list) {
			if(post.getStatus() == 4) {
				post.setThumbnail(post.getThumbnail().replace('\\', '/'));	
			}
		}

		request.setAttribute("post", list);

		return "category";
	}

}
