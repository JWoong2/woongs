package com.woongjin.woongs.model;

public class ChatRoomVO {
	private String chatroom_id;
	private String client_id;
	private String worker_id;
	private int post_no;

	public String getChatroom_id() {
		return chatroom_id;
	}

	public void setChatroom_id(String chatroom_id) {
		this.chatroom_id = chatroom_id;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
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

	@Override
	public String toString() {
		return "ChatRoomVO [chatroom_id=" + chatroom_id + ", client_id=" + client_id + ", worker_id=" + worker_id
				+ ", post_no=" + post_no + "]";
	}

}
