package com.spring.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PCDAOImpl implements PCDAO {
	
	@Inject
	private JdbcTemplate template;
	
	String sql=null;

	@Override
	public List<PC> getPCList() {
		List<PC> list = null;
		
		sql="select * from pc order by pnum desc";
		
		return list = this.template.query(sql, new RowMapper<PC>() {

			@Override
			public PC mapRow(ResultSet rs, int rowNum) throws SQLException {
				PC dto = new PC();
				
				dto.setPnum(rs.getInt("pnum"));
				dto.setCpu(rs.getString("cpu"));
				dto.setMainboard(rs.getString("mainboard"));
				dto.setVga(rs.getString("vga"));
				dto.setRam(rs.getString("ram"));
				dto.setSsd(rs.getString("ssd"));
				dto.setHdd(rs.getString("hdd"));
				dto.setPsu(rs.getString("psu"));
				dto.setOs(rs.getString("os"));
				dto.setCpu_cooler(rs.getString("cpu_cooler"));
				
				return dto;
			}
			
		});
	}

	@Override
	public int insertPC(PC dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PC getPCCont(int pnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePC(PC dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePC(int pnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSequence(int pnum) {
		// TODO Auto-generated method stub

	}

}