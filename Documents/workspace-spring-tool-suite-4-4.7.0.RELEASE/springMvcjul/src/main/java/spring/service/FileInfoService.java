package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.model.FileInfoDto;

@Service
public class FileInfoService {
	@Autowired
	FileInfoDao dao;

	public int addFile(String path, MultipartFile report) {

		FileInfoDto dto = new FileInfoDto();
		dto.setRealPath(path);
		dto.setContentType(report.getContentType());
		dto.setOriginalName(report.getOriginalFilename());
		dto.setFileSize(report.getSize());

		return dao.addFile(dto);

	}

	public void setDao(FileInfoDao dao) {
		this.dao = dao;
	}

}
