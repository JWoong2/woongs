package com.woongjin.woongs.model;

public class ProfileMainDto {
   String nick_name;
   String user_id;
   String introduce;
   int tag;
   int sub_tag;
   private String tagname;
   private String sub_tagname;
   String skill;
   String univ_name;
   String univ_major;
   int univ_status;
   int no;
   int year;
   int month;
   String company_name;
   String dept_name;
   String position;
   String issu_date;
   String issu_agency;
   String certification_name;

   public String getNick_name() {
      return nick_name;
   }

   public void setNick_name(String nick_name) {
      this.nick_name = nick_name;
   }

   public String getTagname() {
      return tagname;
   }

   public void setTagname(String tagname) {
      this.tagname = tagname;
   }

   public String getSub_tagname() {
      return sub_tagname;
   }

   public void setSub_tagname(String sub_tagname) {
      this.sub_tagname = sub_tagname;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
   }

   public int getMonth() {
      return month;
   }

   public void setMonth(int month) {
      this.month = month;
   }

   public String getCompany_name() {
      return company_name;
   }

   public void setCompany_name(String company_name) {
      this.company_name = company_name;
   }

   public String getDept_name() {
      return dept_name;
   }

   public void setDept_name(String dept_name) {
      this.dept_name = dept_name;
   }

   public String getPosition() {
      return position;
   }

   public void setPosition(String position) {
      this.position = position;
   }

   public String getIssu_date() {
      return issu_date;
   }

   public void setIssu_date(String issu_date) {
      this.issu_date = issu_date;
   }

   public String getIssu_agency() {
      return issu_agency;
   }

   public void setIssu_agency(String issu_agency) {
      this.issu_agency = issu_agency;
   }

   public String getCertification_name() {
      return certification_name;
   }

   public void setCertification_name(String certification_name) {
      this.certification_name = certification_name;
   }

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