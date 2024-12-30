package hft.matthew.SpringBootJDBC.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import hft.matthew.SpringBootJDBC.model.Programmer;

@Repository
public class ProgrammerRepo {
	
	//need to add schema & data value sql statements within the resources folder 
	
	
	private JdbcTemplate template;
	
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Programmer programmer) {
		String sql = "insert into programmer (id, name, tech) values(?,?,?);";
		
		int rows = template.update(sql,programmer.getId(),programmer.getName(),programmer.getTech());
		System.out.println(rows+" row/s affected");
	}
	
	public List<Programmer> findAll() {
		
		String sql = "select * from programmer;";
		
		RowMapper<Programmer> mapper = new RowMapper<Programmer>() {
			@Override
			public Programmer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Programmer a = new Programmer();
				
				//can use column number or name for the rs.get() methods
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setTech(rs.getString("tech"));
				
				return a;
			}
		};
		
		List<Programmer> programmers = template.query(sql,mapper);
		
		return programmers;
	}

}
