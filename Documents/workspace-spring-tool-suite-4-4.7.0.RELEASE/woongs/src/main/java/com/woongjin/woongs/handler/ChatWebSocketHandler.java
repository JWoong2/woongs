package com.woongjin.woongs.handler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.woongjin.woongs.model.ChatRoomVO;
import com.woongjin.woongs.model.MessageVO;
import com.woongjin.woongs.model.UserDto;
import com.woongjin.woongs.model.ChatDao;
import com.google.gson.Gson;

// binary 를 넣으면 이미지, 동영상 넣기 가능 
// 지금 우리는 txt만이니까 
public class ChatWebSocketHandler extends TextWebSocketHandler {
	@Autowired
	private ChatDao dao;
	private List<WebSocketSession> connectedUsers;
	private Date now;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public ChatWebSocketHandler() {
		connectedUsers = new ArrayList<WebSocketSession>();
	}

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log(session.getId() + " 연결 됨!!");
		users.put(session.getId(), session);
		connectedUsers.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayload());

		Map<String, Object> map = null;

		MessageVO messageVO = MessageVO.convertMessage(message.getPayload());

		ChatRoomVO roomVO = new ChatRoomVO();
		roomVO.setPost_no(messageVO.getPost_no()); // 게시물 번호
		roomVO.setWorker_id(messageVO.getWorker_id()); // 작업자 아이디
		roomVO.setClient_id(messageVO.getClient_id()); // 의뢰인 아이디

		ChatRoomVO croom = null;

		if (!messageVO.getClient_id().equals(messageVO.getWorker_id())) {
			System.out.println("a");
			if (dao.isRoom(roomVO) == null) {
				dao.createRoom(roomVO);
				croom = dao.isRoom(roomVO);

			} else {
				croom = dao.isRoom(roomVO);
			}
		} else {
			croom = dao.isRoom(roomVO);
		}

		messageVO.setChatroom_id(croom.getChatroom_id());

		// sender 랑 login 아이디가 같으면 상대방이 worker가 되고
		// sender 랑 login 아이디랑 다르면 상대방이 client가 되는거지
		if (croom.getClient_id().equals(messageVO.getMessage_sender())) {
			messageVO.setMessage_receiver(roomVO.getWorker_id());
		} else {
			messageVO.setMessage_receiver(roomVO.getClient_id());
		}

		now = new Date();
		messageVO.setMessage_sendTime(formatter.format(now).toString());
		System.out.println("현재시간 : " + now);
		dao.insertMessage(messageVO);

		// 온라인 상태에서만 소켓 소통 가능
		for (WebSocketSession websocketSession : connectedUsers) {
			map = websocketSession.getAttributes();
			UserDto login = (UserDto) map.get("userInfo");

			// 받는사람 로그인한 info 와 receiver가 같으면 보내지는데
			// 상대방이 대화하고 있는 상대가 다를 수 있다 이말이지 자기가 이야기하는 상대가 아니면 못오게 막아야함
			if (login.getEmail().equals(messageVO.getMessage_receiver())) {
				Gson gson = new Gson();
				String msgJson = gson.toJson(messageVO);
				websocketSession.sendMessage(new TextMessage(msgJson));
			}

			// 자기 자신이 보낸 텍스트 보여주는 용도
			if (login.getEmail().equals(messageVO.getMessage_sender())) {
				Gson gson = new Gson();
				String msgJson = gson.toJson(messageVO);
				websocketSession.sendMessage(new TextMessage(msgJson));
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log(session.getId() + " 연결 종료됨");
		connectedUsers.remove(session);
		users.remove(session.getId());
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log(session.getId() + " 익셉션 발생: " + exception.getMessage());
	}

	private void log(String logmsg) {
		System.out.println(new Date() + " : " + logmsg);
	}

}