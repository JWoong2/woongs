package com.woongjin.woongs.model;

public class ProfileDto {

	String user_id;
	String introduce;
	int tag;
	int sub_tag;
	String skill;
	String univ_name;
	String univ_major;
	int univ_status;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getTag() {
		return tag;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public int getSub_tag() {
		return sub_tag;
	}

	public void setSub_tag(int sub_tag) {
		this.sub_tag = sub_tag;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getUniv_name() {
		return univ_name;
	}

	public void setUniv_name(String univ_name) {
		this.univ_name = univ_name;
	}

	public String getUniv_major() {
		return univ_major;
	}

	public void setUniv_major(String univ_major) {
		this.univ_major = univ_major;
	}

	public int getUniv_status() {
		return univ_status;
	}

	public void setUniv_status(int univ_status) {
		this.univ_status = univ_status;
	}

}
