package com.spring.model;

import java.util.List;

public interface PCDAO {
	List<PC> getPCList();
	
	int insertPC(PC dto);
	
	PC getPCCont(int pnum);
	
	int updatePC(PC dto);
	
	int deletePC(int pnum);
	
	void updateSequence(int pnum);
}
