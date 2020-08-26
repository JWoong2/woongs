package com.woongjin.woongs.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PostDao extends SqlSessionDaoSupport {

	public List<TagDto> getTagList() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.tags");
	}

	public List<SubTagDto> getSubTagList(int no) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.subtags", no);
	}

	public void insertPost(PostDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("woongs.insertPost", dto);
	}

	public List<PostDto> getPosts() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.selectPost");
	}

	public PostDto getPosts(int no) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("woongs.selectPostByNo", no);
	}

	public List<PostDto> getPostsByTag(int no) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.getPostsByTag", no);
	}

	public List<PostDto> getPostsBySubTag(SubTagDto dto) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.getPostsBySubTag", dto);
	}

	public List<PostDto> getPostsById(String user_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("woongs.getPostsById", user_id);
	}

	public void updatePost(PostDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("woongs.updatePost", dto);
	}

	public PostDto getRecentPostById(String attribute) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("woongs.selectRecentPostById", attribute);
	}

	
	//
	
	public List<PostDto> selectPost(Map<String, Integer> map){
		return getSqlSession().selectList("Tag.selectPost",map);
	}
	
	public List<PostDto> tagSelectPost(int post){
		return getSqlSession().selectList("Tag.tagSelectPost",post);
	}
	
	public List<PostDto> checkPost(int post){
		return getSqlSession().selectList("Tag.checkPost", post);
	}
	
	public List<PostDto> orderPost() {
		 return getSqlSession().selectList("Tag.orderPost");
	}
	
	
	
	
}
