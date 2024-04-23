package com.spring.model;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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
		
		return list = this.template.query(sql, new BeanPropertyRowMapper<>(PC.class));
	}

	@Override
	public int insertPC(final PC dto) {
		sql="select max(pnum) from pc";
		final int result=this.template.queryForInt(sql);
		sql="insert into pc values(?, ?, ?, ?, ?, ?)";
		
		return this.template.
				update(sql,
						result+1, 
						dto.getCpu(), 
						dto.getMainboard(), 
						dto.getVga(), 
						dto.getRam(), 
						dto.getOs()
					);
	}

	@Override
	public PC getPCCont(int pnum) {
		
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
