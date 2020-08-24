package com.woongjin.woongs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.woongjin.woongs.model.ChatDao;
import com.woongjin.woongs.model.ChatRoomVO;
import com.woongjin.woongs.model.MessageVO;
import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.UserDao;
import com.woongjin.woongs.model.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatController {

	@Autowired
	ChatDao chatDao;

	@Autowired
	UserDao userDao;

	// 채팅방 대화내용 불러오는 메소드
	@RequestMapping("/chatPreviousContent")
	@ResponseBody
	public void chatPreviousContent(int chatroom_id, String user_id, HttpServletResponse resp, HttpSession session)
			throws Exception {
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<MessageVO> list = chatDao.getPreviousChat(chatroom_id);
		Map<String, String> updateReadTimeInfo = new HashMap<String, String>();
		updateReadTimeInfo.put("chatroom_id", Integer.toString(chatroom_id));
		updateReadTimeInfo.put("user_id", user_id);

		chatDao.updateReadTime(updateReadTimeInfo);
		
		out.print(json.toJson(list));
	}

	// 상대방과의 채팅방 만들기 (문의하기)
	@RequestMapping(value = "/chatAsk", method = RequestMethod.GET)
	public String chatAsk(PostDto dto, HttpSession session) throws Exception {
		// 처음은 의뢰인으로
		// postDto로 post_no , 상대방의 user_id
		// session 값으로 현재 로그인한 정보 가져올수 있음
		String client_id = (String) session.getAttribute("user_id");
		System.out.println("user_id ask쪽:  " + client_id);

		Map<String, String> login = new HashMap<String, String>();

		login.put("client_id", client_id); // glames2
		System.out.println("aks client_id : " + client_id);
		login.put("worker_id", dto.getUser_id()); // asd3582
		login.put("user_id", client_id); // glames2
		login.put("post_no", Integer.toString(dto.getNo())); // 29
		UserDto userInfo = userDao.getUserInfo((String) session.getAttribute("user_id"));
		UserDto partnerInfo = userDao.getUserInfo(dto.getUser_id()); // 상대방 뽀얀불이 맞고

		ChatRoomVO room = new ChatRoomVO();
		room.setClient_id(client_id);
		room.setPost_no(dto.getNo());
		room.setWorker_id(dto.getUser_id());

		ChatRoomVO roomInfo = chatDao.isRoom(room);
		System.out.println(roomInfo.getChatroom_id());
		session.setAttribute("roomInfo", roomInfo);
		session.setAttribute("userInfo", userInfo);
		session.setAttribute("partnerInfo", partnerInfo);
		session.setAttribute("login", login);

		return "chat/chat";
	}

	// 상대방과의 채팅방 만들기 (문의하기)
	@RequestMapping(value = "/chatAnswer", method = RequestMethod.GET)
	public String chatAnswer(PostDto dto, HttpSession session) throws Exception {
		String worker_id = (String) session.getAttribute("user_id"); // asd3582
		Map<String, String> login = new HashMap<String, String>();

		login.put("client_id", dto.getUser_id()); // glaems2
		System.out.println("answer client_id : " + dto.getUser_id());
		login.put("worker_id", worker_id); // asd3582
		login.put("user_id", worker_id); // asd3582
		login.put("post_no", Integer.toString(dto.getNo())); // 29
		UserDto userInfo = userDao.getUserInfo((String) session.getAttribute("user_id")); // 얘는 뽀얀불이면 안되는거지
		UserDto partnerInfo = userDao.getUserInfo(dto.getUser_id()); // 얘는 뽀얀불이면 안되는거지
		System.out.println("answer glaems2 : " + dto.getUser_id());
		ChatRoomVO room = new ChatRoomVO();
		room.setClient_id(dto.getUser_id());
		room.setPost_no(dto.getNo());
		room.setWorker_id(worker_id);

		ChatRoomVO roomInfo = chatDao.isRoom(room);
		System.out.println(roomInfo.getChatroom_id());
		session.setAttribute("roomInfo", roomInfo);
		session.setAttribute("partnerInfo", partnerInfo);
		session.setAttribute("userInfo", userInfo);
		session.setAttribute("login", login);

		return "chat/chat";
	}

	// 접속한 로그인의 아이디로 채팅룸의 목록을 불러온다.
	@RequestMapping("/chatRoom")
	public String chatRoom() {
		return "chat/chatRoom";
	}

	// 아래 두개는 ajax로 구성
	// 클라이언트일때의 채팅 목록 보여주기
	@RequestMapping("/chatClientRoom")
	@ResponseBody
	public void clientRoom(HttpServletResponse resp, HttpSession session) throws Exception {
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<ChatRoomVO> chatRoomlist = chatDao.getRoomList((String) session.getAttribute("user_id"));
		List<MessageVO> list = new ArrayList<MessageVO>();

		for (int i = 0; i < chatRoomlist.size(); i++) {
			System.out.println(chatRoomlist.get(i));
			MessageVO vo = chatDao.getRecentMessage(chatRoomlist.get(i).getChatroom_id());
			System.out.println("count :  " + chatDao.getUnReadCount(chatRoomlist.get(i)));
			vo.setUnReadCount(chatDao.getUnReadCount(chatRoomlist.get(i)));

			System.out.println(vo);

			list.add(vo);
		}
		// 대화할 상대의 이미지랑 최근 메세지, 시간과 안읽은 메세지 갯수 리턴

		out.print(json.toJson(list));
	}

	// 작업자일때의 채팅 목록 보여주기
	@RequestMapping("/chatWorkerRoom")
	@ResponseBody
	public void workerRoom(HttpServletResponse resp, HttpSession session) throws Exception {
		Gson json = new Gson();
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		List<ChatRoomVO> chatRoomlist = chatDao.getRoomList2((String) session.getAttribute("user_id"));

		List<MessageVO> list = new ArrayList<MessageVO>();

		System.out.println("채팅방 개수 : " + chatRoomlist);
		System.out.println("채팅방 개수 : " + chatRoomlist.size());
		for (int i = 0; i < chatRoomlist.size(); i++) {
			System.out.println(chatRoomlist.get(i));
			MessageVO vo = chatDao.getRecentMessageWorker(chatRoomlist.get(i).getChatroom_id());
			System.out.println("count :  " + chatDao.getUnReadCountWorker(chatRoomlist.get(i)));
			vo.setUnReadCount(chatDao.getUnReadCountWorker(chatRoomlist.get(i)));

			System.out.println(vo);

			list.add(vo);
		}

		out.print(json.toJson(list));
	}

}
