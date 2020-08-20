package com.woongjin.woongs.model;

public class QuoteDto {
	int no;
	String user_id;
	String worker_id;
	int post_no;
	String detail;
	int estimate_price;
	int final_price;
	int work_time;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getWorker_id() {
		return worker_id;
	}

	public void setWorker_id(String worker_id) {
		this.worker_id = worker_id;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getEstimate_price() {
		return estimate_price;
	}

	public void setEstimate_price(int estimate_price) {
		this.estimate_price = estimate_price;
	}

	public int getFinal_price() {
		return final_price;
	}

	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}

	public int getWork_time() {
		return work_time;
	}

	public void setWork_time(int work_time) {
		this.work_time = work_time;
	}

}
