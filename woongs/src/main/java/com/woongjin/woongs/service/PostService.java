package com.woongjin.woongs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.PostDao;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.SubTagDto;
import com.woongjin.woongs.model.TagDto;

@Service
public class PostService {
	@Autowired
	PostDao dao;

	public void setDao(PostDao dao) {
		this.dao = dao;
	}

	public List<TagDto> getTagList() {
		// TODO Auto-generated method stub
		return dao.getTagList();
	}

	public List<SubTagDto> getSubTagList(int tagno) {
		// TODO Auto-generated method stub
		return dao.getSubTagList(tagno);
	}

	public void insertPost(PostDto dto) {
		// TODO Auto-generated method stub
		dao.insertPost(dto);
	}

	public List<PostDto> getPosts() {
		// TODO Auto-generated method stub
		return dao.getPosts();
	}

	public PostDto getPosts(int no) {
		// TODO Auto-generated method stub
		return dao.getPosts(no);
	}
	
	public List<PostDto> getPostsByTag(int no) {
		// TODO Auto-generated method stub
		return dao.getPostsByTag(no);
	}

	public List<PostDto> getPostsBySubTag(SubTagDto dto) {
		// TODO Auto-generated method stub
		return dao.getPostsBySubTag(dto);
	}

	public List<PostDto> getPostsById(String user_id) {
		// TODO Auto-generated method stub
		return dao.getPostsById(user_id);
	}

	public void updatePost(PostDto dto) {
		// TODO Auto-generated method stub
		dao.updatePost(dto);
	}

	public PostDto getRecentPostById(String attribute) {
		// TODO Auto-generated method stub
		return dao.getRecentPostById(attribute);
	}

	
}
