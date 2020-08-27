package spring.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.DeptDto;
import spring.model.EmpDto;

public class EmpDao extends SqlSessionDaoSupport {

	public List<DeptDto> selectDepts() {
		return getSqlSession().selectList("scott.depts");
	}

	public List<Map<String, Object>> selectEmps(int deptno) {
		return getSqlSession().selectList("scott.emps", deptno);
	}

	public EmpDto selectEmpOne(int empno) {
		return getSqlSession().selectOne("scott.empOne", empno);
	}
}