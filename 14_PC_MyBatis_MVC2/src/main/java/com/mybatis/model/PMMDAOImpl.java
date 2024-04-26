package com.mybatis.model;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class PMMDAOImpl implements PMMDAO {

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PMM> getPCList(Page pdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertPC(PMM dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PMM PCContent(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int PCUpdate(PMM dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePC(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSeq(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int searchPCCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PMM> searchPCList(Page pdto) {
		// TODO Auto-generated method stub
		return null;
	}

}
