package com.woongjin.woongs.service;

import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.woongjin.woongs.model.EmailDto;

@Service("emailService")
public class UserEmailService {

   @Autowired
    protected JavaMailSender mailSender;

    public boolean sendMail(EmailDto email) throws Exception {

        try{

           MimeMessage msg = mailSender.createMimeMessage();

           msg.setSubject(email.getSubject());//제목 설정
             // 내용 설정 
           // 일반 텍스트만 전송하려는 경우
           // HTML 컨텐츠를 전송시 사용
         /*
          * msg.setContent("<a href='https://www.naver.com'>클릭</a>",
          * "text/html;charset=utf-8");
          */
           msg.setContent(email.getContent(), "text/html;charset=utf-8");
           msg.setRecipient(RecipientType.TO , new InternetAddress(email.getReceiver()));//수신자 설정(여러명이면 InternetAddress[]로)
          
//     	  email.setReceiver(receiver);
//		  email.setSubject("비밀번호도 까먹냐 ㅋㅋ");
//		  email.setContent("사랑합니다. 저거 인증번호는 이겁니다 : " +temp.toString());
           
          //메일 전송  
          mailSender.send(msg);

           return true;

        }catch(Exception ex) {
           ex.printStackTrace();
        }

        return false;
    }

}