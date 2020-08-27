package com.woongjin.woongs.service;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.PostDao;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.Sub_TagDto;
import com.woongjin.woongs.model.TagDao;
import com.woongjin.woongs.model.TagDto;

@Service
public class TagService{


	@Autowired
	TagDao wd;
	
	@Autowired
	PostDao pd;
	
	public void addTag(String td) {
		wd.addTag(td);
	}
	
	public List<TagDto> selectTag(){
		return wd.selectTag();
	}
	
	public void addSubTag(Sub_TagDto dto) {
		wd.addSubTag(dto);
	}
	
	public void deleteTag(TagDto dto) {
		wd.deleteTag(dto);
	}
	
	public void deleteSubTag(int sdto) {
		wd.deleteSubTag(sdto);
	}

	public  List<Sub_TagDto> selectSubTag(int subTag ){
		return wd.selectSubTag(subTag);
	}
	
	public List<PostDto> selectAllPost(Map<String, Integer> map){
	      return pd.selectPost(map);
	}
	
	public List<PostDto> tagSelectPost(int post){
	      return pd.tagSelectPost(post);
	}
	
	public List<PostDto> checkPost(int post){
		return pd.checkPost(post);
	}
	
	public List<PostDto> orderPost() {
		 return pd.orderPost();
	}

	public TagDao getWd() {
		return wd;
	}

	public void setWd(TagDao wd) {
		this.wd = wd;
	}

	public PostDao getPd() {
		return pd;
	}

	public void setPd(PostDao pd) {
		this.pd = pd;
	}

	
	

}
