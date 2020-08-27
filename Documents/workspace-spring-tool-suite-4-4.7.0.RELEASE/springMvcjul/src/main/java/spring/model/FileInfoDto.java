package spring.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FileInfoDto {

	String originalName;
	String realPath;
	long fileSize;
	String contentType;
}
