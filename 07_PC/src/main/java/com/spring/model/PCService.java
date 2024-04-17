package com.spring.model;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class PCService {
	@Inject
	private PCDAO dao;
	
	public List<PC> getList() {
		return this.dao.getPCList();
	}
	
	public int insert(PC dto) {
		return this.dao.insertPC(dto);
	}
	
	public PC content(int pnum) {
		return this.dao.getPCCont(pnum);
	}
	
	public int update(PC dto) {
		return this.dao.updatePC(dto);
	}
	
	public int delete(int pnum) {
		return this.dao.deletePC(pnum);
	}
	
	public void sequence(int pnum) {
		this.dao.updateSequence(pnum);
	}
}
