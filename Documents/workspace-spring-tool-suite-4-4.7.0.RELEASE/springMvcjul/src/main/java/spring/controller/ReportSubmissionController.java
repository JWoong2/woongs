package spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.service.FileInfoService;

@Controller
public class ReportSubmissionController {

	@Autowired
	FileInfoService service;

	public void setService(FileInfoService service) {
		this.service = service;
	}

	@RequestMapping(value = "/report/submission.do", method = RequestMethod.GET)

	public String form() {
		return "report/submissionForm";
	}

	private void upload(MultipartFile report) throws IllegalStateException, IOException {
		String path = "d:/item/";
		String name = report.getOriginalFilename();
		File f = new File(path + name);
		report.transferTo(f);
		
		service.addFile(f.getPath(), report);
	}

	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber,
			@RequestParam("report") MultipartFile report) throws IllegalStateException, IOException {

		printInfo(studentNumber, report);

		String path = "d:/item/";
		String name = report.getOriginalFilename();
		File f = new File(path + name);
		report.transferTo(f);

		return "report/submissionComplete";
	}

	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}

	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		upload(report);
		printInfo(studentNumber, report);
		return "report/submissionComplete";
	}

	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "report/submissionComplete";
	}

}