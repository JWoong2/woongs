/*
 * package com.woongjin.woongs.controller;
 * 
 * import java.io.File; import java.io.IOException; import java.io.PrintWriter;
 * 
 * import java.util.List;
 * 
 * import javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * 
 * import com.google.gson.Gson; import com.woongjin.woongs.model.EstimateDto;
 * 
 * import com.woongjin.woongs.model.Sub_TagDto; import
 * com.woongjin.woongs.model.TagDto; import
 * com.woongjin.woongs.service.EstimateService; import
 * com.woongjin.woongs.service.TagService;
 * 
 * @Controller public class EstimateController {
 * 
 * @Autowired EstimateService es;
 * 
 * @Autowired TagService ts;
 * 
 * @RequestMapping("smartEditor") public String form() { return
 * "mypage/smartEditorForm"; }
 * 
 * @RequestMapping(value = "insert", method = RequestMethod.POST) public String
 * estimateAdd(EstimateDto edto, MultipartFile report) { String path =
 * "D:\\Spring_Woongs\\woongsEx\\src\\main\\webapp\\resources\\proposal"; String
 * alterpath = "resources\\proposal\\";
 * 
 * File file = new File(path);
 * 
 * if (!file.exists()) { file.mkdirs(); System.out.println("directory created");
 * System.out.println(file.toString()); } else {
 * System.out.println("already exist"); System.out.println(file.toString()); }
 * 
 * path += "\\" + report.getOriginalFilename(); alterpath +=
 * report.getOriginalFilename();
 * 
 * file = new File(path);
 * 
 * try { report.transferTo(file); } catch (IllegalStateException e) {
 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
 * edto.setProposal(alterpath);
 * 
 * es.estimateAdd(edto);
 * 
 * System.out.println(edto.getContent());
 * System.out.println(edto.getProposal());
 * 
 * return "redirect:/index.jsp"; }
 * 
 * @RequestMapping("selectSmartEditor") public String post(HttpSession hs)
 * throws Exception { List<EstimateDto> list = es.estimateAll();
 * 
 * for (int i = 0; i < list.size(); i++) {
 * list.get(i).setThumbnail(list.get(i).getThumbnail().replace("\\", "/")); }
 * 
 * hs.setAttribute("list", list); return "mypage/smartEditorSelect"; }
 * 
 * @RequestMapping(value = "smartEditorPost", method = RequestMethod.GET) public
 * String postList(HttpSession hs, int no) throws Exception { List<EstimateDto>
 * list = es.estimateSelect(no); hs.setAttribute("list", list); return
 * "mypage/smartEditorPost"; }
 * 
 * @SuppressWarnings("unused")
 * 
 * @RequestMapping("fileDown") public void downloadFile(HttpServletResponse
 * respones, int no) throws Exception { List<EstimateDto> list =
 * es.estimateSelect(no);
 * 
 * // �����ϼ��ؾ��� }
 * 
 * @RequestMapping(value = "update", method = RequestMethod.POST) public String
 * update(HttpSession hs, int no) throws Exception { List<EstimateDto> list =
 * es.estimateSelect(no); hs.setAttribute("list", list);
 * 
 * hs.setAttribute("tag", list.get(0).getTag());
 * hs.setAttribute("subTag",list.get(0).getSub_tag());
 * 
 * return "mypage/smartEditorUpdate"; }
 * 
 * @RequestMapping(value = "ajax_c", method = RequestMethod.POST) public void
 * tagList_c(HttpServletResponse resp) throws Exception { List<TagDto> list =
 * ts.selectTag();
 * 
 * Gson json = new Gson(); resp.setContentType("text/html;charset=UTF-8");
 * PrintWriter out = resp.getWriter(); out.print(json.toJson(list)); }
 * 
 * @RequestMapping(value = "subAjax_c", method = RequestMethod.POST) public void
 * subtagList_c(int tag, HttpServletResponse resp) throws Exception {
 * System.out.println("subTagsubTagsubTagsubTagsubTag"); List<Sub_TagDto> list =
 * ts.selectSubTag(tag);
 * 
 * Gson json = new Gson(); resp.setContentType("text/html;charset=UTF-8");
 * PrintWriter out = resp.getWriter(); out.print(json.toJson(list)); }
 * 
 * @RequestMapping(value = "update_end", method = RequestMethod.POST) public
 * String estimateUpdate(EstimateDto edto, MultipartFile report) {
 * 
 * String path =
 * "D:\\Spring_Woongs\\woongsEx\\src\\main\\webapp\\resources\\proposal"; String
 * alterpath = "resources\\proposal\\";
 * 
 * 
 * File file = new File(path);
 * 
 * if (!file.exists()) { file.mkdirs(); System.out.println("directory created");
 * System.out.println(file.toString()); } else {
 * System.out.println("already exist"); System.out.println(file.toString()); }
 * 
 * path += "\\" + report.getOriginalFilename(); alterpath +=
 * report.getOriginalFilename();
 * 
 * file = new File(path);
 * 
 * try { report.transferTo(file); } catch (IllegalStateException e) {
 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
 * 
 * edto.setProposal(alterpath);
 * 
 * es.estimateUpdate(edto);
 * 
 * return "redirect:/index.jsp"; }
 * 
 * @RequestMapping(value = "delete", method = RequestMethod.POST) public String
 * delete(int no) { es.estimateDelete(no);
 * 
 * return "redirect:/index.jsp"; }
 * 
 * }
 */