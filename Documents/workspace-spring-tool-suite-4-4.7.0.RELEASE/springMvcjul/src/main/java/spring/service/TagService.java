package spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.Sub_tagDto;
import spring.model.TagDto;

@Service
public class TagService {
	@Autowired
	TagDao dao;

	public TagService(TagDao dao) {
		this.dao = dao;
	}

	public List<TagDto> selectTags() {
		return dao.selectTags();
	}

	public List<Map<String, Object>> selectSub_tags(int tag_num) {
		return dao.selectSub_tags(tag_num);
	}


}