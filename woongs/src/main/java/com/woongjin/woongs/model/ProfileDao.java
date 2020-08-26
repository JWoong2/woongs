package com.woongjin.woongs.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ProfileDao extends SqlSessionDaoSupport {

	public void updateintro(Map<String, String> map) {
		getSqlSession().update("profile.updateintro", map);
	}

	public void updatetag(ProfileDto dto) {
		getSqlSession().update("profile.updatetag", dto);
	}

	public List<TagDto> selectTags() {
		return getSqlSession().selectList("profile.tags");
	}

	public List<SubTagDto> selectSub_tags(int tag_no) {
		return getSqlSession().selectList("profile.sub_tags", tag_no);
	}

	public void updateImage(UserDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("profile.updateImage", dto);
	}

	public void updateskill(ProfileDto dto) {
		getSqlSession().update("profile.updateskill", dto);
	}

	public TagNameDto selectTag(int no) {
		return getSqlSession().selectOne("profile.sub_tagOne", no);

	}

	public void updateunivtag(ProfileDto dto) {
		getSqlSession().update("profile.univtags", dto);
	}

	// 자격증
	public void updatecerti(CertiDto dto) {
		getSqlSession().update("profile.updatecerti", dto);
	}

	public void updatecareer(CareerDto dto) {
		getSqlSession().update("profile.updatecareer", dto);
	}

	public ProfileMainDto profileMain(String user_id) {
		return getSqlSession().selectOne("profile.profileMain", user_id);

	}

	/*
	 * public ProfileMainDto selectOne(String string, String user_id) { // TODO
	 * Auto-generated method stub return null; }
	 */

}