package com.mybatis.model;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Emp> getEmpList() {
		return this.sqlSession.selectList("all");
	}

	@Override
	public int insertEmp(Emp dto) {
		return this.sqlSession.insert("insert", dto);
	}

	@Override
	public Emp getEmp(int no) {
		return this.sqlSession.selectOne("getone" ,no);
	}

	@Override
	public int updateEmp(Emp dto) {
		return this.sqlSession.update("modify", dto);
	}

	@Override
	public int deleteEmp(int no) {
		return this.sqlSession.delete("del", no);
	}

	@Override
	public List<String> getJobList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getMgrList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> getDeptList() {
		return this.sqlSession.selectList("dept");
	}
	
	
	
	

}
