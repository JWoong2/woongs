package spring.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.FileInfoDto;

public class FileInfoDao extends SqlSessionDaoSupport {

	public int addFile(FileInfoDto dto) {
		return getSqlSession().insert("file.addfile", dto);
	}

}
