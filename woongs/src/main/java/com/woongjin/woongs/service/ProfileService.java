package com.woongjin.woongs.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.CareerDto;
import com.woongjin.woongs.model.CertiDto;
import com.woongjin.woongs.model.ProfileDao;
import com.woongjin.woongs.model.ProfileDto;
import com.woongjin.woongs.model.ProfileMainDto;
import com.woongjin.woongs.model.SubTagDto;
import com.woongjin.woongs.model.TagDto;
import com.woongjin.woongs.model.TagNameDto;
import com.woongjin.woongs.model.UserDto;

@Service
public class ProfileService {
	
	@Autowired
	ProfileDao dao;

	public void setDao(ProfileDao dao) {
		this.dao = dao;
	}

	public void updateintro(Map<String, String> map) {
		dao.updateintro(map);
	}

	public void updatetag(ProfileDto dto) {
		dao.updatetag(dto);
	}

	public List<TagDto> selectTags() {
		return dao.selectTags();
	}

	public List<SubTagDto> selectSub_tags(int tag_no) {
		return dao.selectSub_tags(tag_no);
	}

	public void updateImage(UserDto dto) {
		dao.updateImage(dto);
	}

	public void updateskill(ProfileDto dto) {
		dao.updateskill(dto);
	}

	public TagNameDto selectTag(int no) {
		return dao.selectTag(no);
	}

	public void updateunivtag(ProfileDto dto) {
		dao.updateunivtag(dto);
	}

	// 자격증
	public void updatecerti(CertiDto dto) {
		dao.updatecerti(dto);
	}

	public void updatecareer(CareerDto dto) {
		dao.updatecareer(dto);
	}

	public ProfileMainDto profileMain(String user_id) {
		return dao.profileMain(user_id);
	}

	public ProfileMainDto selectprofile(String user_id) {
		// TODO Auto-generated method stub
		return dao.selectprofile(user_id);
	}
	


}