package com.woongjin.woongs.model;

import java.util.Date;

import com.google.gson.Gson;

public class MessageVO {
	private String message_id;
	private String message_sender;
	private String message_receiver;
	private String message_content;
	private String message_sendTime;
	private String message_readTime;
	
	// chatRoomVo 가 가지고 있는거
	private String chatroom_id;
	private String client_id;
	private String worker_id;
	private int post_no;
	
	private String client_image;
	private String worker_image;
	private String client_name;
	private String worker_name;

	private String title;
	private int no;
	private int unReadCount;

	public int getUnReadCount() {
		return unReadCount;
	}

	public void setUnReadCount(int unReadCount) {
		this.unReadCount = unReadCount;
	}

	@Override
	public String toString() {
		return "MessageVO [message_id=" + message_id + ", message_sender=" + message_sender + ", message_receiver="
				+ message_receiver + ", message_content=" + message_content + ", message_sendTime=" + message_sendTime
				+ ", message_readTime=" + message_readTime + ", chatroom_id=" + chatroom_id + ", client_id=" + client_id
				+ ", worker_id=" + worker_id + ", post_no=" + post_no + ", client_image=" + client_image
				+ ", worker_image=" + worker_image + ", client_name=" + client_name + ", worker_name=" + worker_name
				+ ", title=" + title + ", no=" + no + ", unReadCount=" + unReadCount + "]";
	}

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

	public String getClient_image() {
		return client_image;
	}

	public void setClient_image(String client_image) {
		this.client_image = client_image;
	}

	public String getWorker_image() {
		return worker_image;
	}

	public void setWorker_image(String worker_image) {
		this.worker_image = worker_image;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getWorker_name() {
		return worker_name;
	}

	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMessage_sendTime() {
		return message_sendTime;
	}

	public void setMessage_sendTime(String message_sendTime) {
		this.message_sendTime = message_sendTime;
	}

	public String getMessage_readTime() {
		return message_readTime;
	}

	public void setMessage_readTime(String message_readTime) {
		this.message_readTime = message_readTime;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getMessage_sender() {
		return message_sender;
	}

	public void setMessage_sender(String message_sender) {
		this.message_sender = message_sender;
	}

	public String getMessage_receiver() {
		return message_receiver;
	}

	public void setMessage_receiver(String message_receiver) {
		this.message_receiver = message_receiver;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public static MessageVO convertMessage(String source) {
		MessageVO message = new MessageVO();
		Gson gson = new Gson();
		message = gson.fromJson(source, MessageVO.class);
		return message;
	}

}