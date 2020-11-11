package com.woongjin.woongs.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

public class ChatDao extends SqlSessionDaoSupport {

	private static String namespace = "Chat";

	public void createRoom(ChatRoomVO vo) throws Exception {
		// TODO Auto-generated method stub
		getSqlSession().insert(namespace + ".createRoom", vo);
	}

	public ChatRoomVO isRoom(ChatRoomVO vo) throws Exception {
		// TODO Auto-generated method stub
		ChatRoomVO roomvo = null;
		roomvo = getSqlSession().selectOne(namespace + ".isRoom", vo);
		System.out.println("Info : roomvo = " + roomvo);

		return roomvo;
	}

	public void insertMessage(MessageVO vo) throws Exception {
		// TODO Auto-generated method stub
		getSqlSession().insert(namespace + ".insertMessage", vo);
	}

	public String getPartner(ChatRoomVO vo) throws Exception {
		// TODO Auto-generated method stub
		List<MessageVO> mvo = getSqlSession().selectList(namespace + ".getPartner", vo);
		return mvo.get(0).getClient_id();
	}

	public String getProfile(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(namespace + ".getProfile", str);
	}

	public String getName(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(namespace + ".getName", str);
	}

	public List<MessageVO> getMessageList(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace + ".getMessageList", str);
	}

	public List<ChatRoomVO> getRoomList(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace + ".getRoomList", str);
	}

	public List<ChatRoomVO> getRoomList2(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace + ".getRoomList2", str);
	}
	

	public MessageVO getRecentMessageWorker(String chatroom_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(namespace + ".getRecentMessageWorker", chatroom_id);
	}

	public MessageVO getRecentMessage(String chatroom_id) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(namespace + ".getRecentMessage", chatroom_id);
	}

	public String getWorkerId(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(namespace + ".getTutorId", str);
	}

	public List<ChatRoomVO> getRoomListWorker(String str) throws Exception {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace + ".getRoomListTutor", str);
	}

	public void updateReadTime(int post_no, String client_id, String worker_id) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("post_no", post_no);
		map.put("client_id", client_id);
		map.put("worker_id", worker_id);
		getSqlSession().update(namespace + ".updateReadTime", map);
	}

	public int getUnReadCount(ChatRoomVO chat) throws Exception {
		// TODO Auto-generated method stub

		return getSqlSession().selectOne(namespace + ".getUnReadCount", chat);
	}

	public int getAllCount(String str) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("client_id", str);
		map.put("worker_id", str);

		if (getSqlSession().selectOne(namespace + ".getAllCount", map) == null) {
			return 0;
		} else {
			return getSqlSession().selectOne(namespace + ".getAllCount", map);
		}

	}

	public void updateReadTimeWorker(int post_no, String client_id, String worker_id) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("worker_id", worker_id);
		map.put("client_id", client_id);
		map.put("post_no", post_no);
		getSqlSession().update(namespace + ".updateReadTimeWorker", map);
	}

	public int getUnReadCountWorker(ChatRoomVO chat) throws Exception {
		// TODO Auto-generated method stub

		return getSqlSession().selectOne(namespace + ".getUnReadCountWorker", chat);
	}

	public List<MessageVO> getPreviousChat(int chatroom_id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(namespace +".getPreviousChat", chatroom_id);
	}

	public void updateReadTime(Map<String, String> updateReadTimeInfo) {
		// TODO Auto-generated method stub
		getSqlSession().update(namespace +".updateReadTime", updateReadTimeInfo);
	}


}