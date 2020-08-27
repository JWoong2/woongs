package spring.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.DeptDto;
import spring.model.EmpDto;
import spring.model.Sub_tagDto;
import spring.model.TagDto;

public class TagDao extends SqlSessionDaoSupport {

	public List<TagDto> selectTags() {
		return getSqlSession().selectList("tag.tags");
	}

	public List<Map<String, Object>> selectSub_tags(int tag_num) {
		return getSqlSession().selectList("tag.sub_tags", tag_num);
	}

	public Sub_tagDto selectSub_tagOne(int num) {
		return getSqlSession().selectOne("tag.sub_tagOne", num);
	}
}