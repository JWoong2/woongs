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

}
