package spring.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import spring.model.Sub_tagDto;
import spring.model.TagDto;
import spring.service.TagService;

@Controller
public class TagController {

	@Autowired
	TagService tag;

	@RequestMapping(value = "/tag/tagInfo.do")
	public String emp() throws Exception {
		return "tag/tagInfo";
	}

	@RequestMapping(value = "/tag/tags.do", method = RequestMethod.POST)
	public void tagList(HttpServletResponse resp) throws Exception {
		List<TagDto> list = tag.selectTags();
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(json.toJson(list));
	}

	@RequestMapping(value = "/tag/sub_tags.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String tagList(int tag_num) throws Exception {
		List<Map<String, Object>> list = tag.selectSub_tags(tag_num);
		Gson json = new Gson();
		return json.toJson(list);
	}

	public void setTag(TagService tag) {
		this.tag = tag;
	}

}