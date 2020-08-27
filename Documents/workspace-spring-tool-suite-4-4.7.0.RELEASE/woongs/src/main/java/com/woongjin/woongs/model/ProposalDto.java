package com.woongjin.woongs.model;

public class ProposalDto {
	private int idx;
	private String original_file_name;
	private String stored_file_name;
	private String alterpath_file_name;
	private int file_size;
	private int post_no;
	private String user_id;

	public String getAlterpath_file_name() {
		return alterpath_file_name;
	}

	public void setAlterpath_file_name(String alterpath_file_name) {
		this.alterpath_file_name = alterpath_file_name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getOriginal_file_name() {
		return original_file_name;
	}

	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}

	public String getStored_file_name() {
		return stored_file_name;
	}

	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
