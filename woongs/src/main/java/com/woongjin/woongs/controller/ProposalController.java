package com.woongjin.woongs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.woongjin.woongs.model.PostDto;
import com.woongjin.woongs.model.ProposalDao;
import com.woongjin.woongs.model.ProposalDto;
import com.woongjin.woongs.service.PostService;


@Controller
public class ProposalController {
	@Autowired
	ProposalDao proposalDao;

	@Autowired
	PostService postDao;
	
	@RequestMapping("/estimate")
	public ModelAndView viewEstimate(HttpSession session, int post_no) {
		List<ProposalDto> dto = proposalDao.getProposalsByNo(post_no);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("estimate");
		mav.addObject("proposalDto", dto);
		
		return mav;
	}
	
	// 2. 이미지 표시 매핑
	@ResponseBody // view가 아닌 data리턴
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(int idx) throws Exception {
		// 서버의 파일을 다운로드하기 위한 스트림
		InputStream in = null; // java.io
		ResponseEntity<byte[]> entity = null;
		String uploadPath = "C:\\Users\\asd35\\Documents\\project-spring-workspace\\woongs\\src\\main\\webapp\\resources\\Images\\";
		String[] arr = proposalDao.getAlterpath(idx).split("\\\\");
		
		for(String s : arr ) {
			System.out.println(s);
		}
		
		String fileName = arr[arr.length-1];
		String originalName = proposalDao.getOriginalName(idx);
		
		System.out.println("fileName : " + fileName);
		
		try {
			// 확장자를 추출하여 formatName에 저장
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			System.out.println(" formatName : " + formatName);
			// 추출한 확장자를 MediaUtils클래스에서 이미지파일여부를 검사하고 리턴받아 mType에 저장
			MediaType mType = MediaUtils.getMediaType(formatName);
			// 헤더 구성 객체(외부에서 데이터를 주고받을 때에는 header와 body를 구성해야하기 때문에)
			HttpHeaders headers = new HttpHeaders();
			// InputStream 생성
			in = new FileInputStream(uploadPath + fileName);
			// 이미지 파일이면
			if (mType != null) {
				headers.setContentType(mType);
				// 이미지가 아니면
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);
				// 다운로드용 컨텐트 타입
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				//
				// 바이트배열을 스트링으로 : new String(fileName.getBytes("utf-8"),"iso-8859-1") *
				// iso-8859-1 서유럽언어, 큰 따옴표 내부에 " \" 내용 \" "
				// 파일의 한글 깨짐 방지
				/*
				 * headers.add("Content-Disposition", "attachment; filename=\"" + new
				 * String(fileName.getBytes("utf-8"), "iso-8859-1") + "\"");
				 */
				headers.add("Content-Disposition",
						"attachment; filename=\"" + new String(originalName.getBytes("utf-8"), "iso-8859-1") + "\"");
				// headers.add("Content-Disposition", "attachment; filename='"+fileName+"'");
			}
			// 바이트배열, 헤더, HTTP상태코드
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// HTTP상태 코드()
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close(); // 스트림 닫기
		}
		return entity;
	}
	
	@RequestMapping("/proposal")
	public ModelAndView proposal(int post_no, HttpSession session) {
		PostDto dto = postDao.getPosts(post_no);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("proposal");
		mav.addObject("post", dto);
		
		return mav;
	}
	
	@RequestMapping(value="/proposal", method = RequestMethod.POST)
	public String postProposal(int post_no, MultipartFile[] file, HttpSession session) {
		Date now;
		Map<String, Object> map;
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		
		String email = (String) session.getAttribute("user_id");
		email = email.split("@")[0];
		
		for (int i = 0; i < file.length; i++) {
			map = new HashMap<String, Object>();
			now = new Date();
			
			String date = format.format(now);
			String path = "C:\\Users\\asd35\\Documents\\project-spring-workspace\\woongs\\src\\main\\webapp\\resources\\Images";
			String alterpath = "\\resources\\Images\\"+date+email+file[i].getOriginalFilename();
			File f = new File(path);

			if (!f.exists()) {
				f.mkdirs();
			}
			path += "\\" + date+email+file[i].getOriginalFilename();

			f = new File(path);
			
			try {
				file[i].transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			map.put("stored_file_name", path);
			map.put("alterpath_file_name", alterpath);
			map.put("original_file_name", file[i].getOriginalFilename());
			map.put("file_size", (int) file[i].getSize());
			map.put("post_no", post_no);
			map.put("user_id", (String) session.getAttribute("user_id"));
			
			proposalDao.insertFiles(map);
//			proposalDao.insertFiles(path, alterpath,file[i], session.getAttribute("user_id"));
		}
		
		return "main";
	}
	
	
}
