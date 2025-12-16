package com.luminar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.luminar.beans.TeacherBean;

@Repository
public class TeacherDaoImpl implements TeacherDao {
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/*since jdbc template bean is defined in spring-servlet.xml
	 * we cant use autowired and we define a reference and its setter for it 
	 * to inject bean here
	 */
	
	@Override
	public void insertTeacher(TeacherBean teacher) {
		String sql = "INSERT INTO teachers (name,subject) values (?, ?)";
		
		template.update(sql,teacher.getName(),teacher.getSubject());
	}

	@Override
	public int updateTeacherRecord(TeacherBean teacher) {
		String sql = "UPDATE teachers SET name = ?, subject = ? WHERE id = ?";
		
		return template.update(sql,teacher.getName(),teacher.getSubject(),teacher.getId());
	}

	@Override
	public int removeTeacherById(int id) {
		String sql = "DELETE from teachers where id = ?";
		
		return template.update(sql,id);
	}

	@Override
	public List<TeacherBean> fetchAllTeachers() {

	    String sql = "SELECT id, name, subject FROM teachers";

	    List<TeacherBean> list = template.query(sql, new RowMapper<TeacherBean>() {

	        @Override
	        public TeacherBean mapRow(ResultSet rs, int rowNum) throws SQLException {

	            TeacherBean teacher = new TeacherBean();
	            teacher.setId(rs.getInt("id"));
	            teacher.setName(rs.getString("name"));
	            teacher.setSubject(rs.getString("subject"));

	            return teacher;
	        }
	    });

	    return list;
	}
	
	/*
	 * Here we use mapRow to match each row to a java object but we dont add it to the list.
	 * jdbcTemplate does it internally
	 */

	@Override
	public Optional<TeacherBean> fetchTeacherById(int id) {
		String sql = "select * from teachers where id = ?";
		
		List<TeacherBean> list = template.query(sql, (rs,rowNum) -> {
			TeacherBean t = new TeacherBean();
			t.setId(rs.getInt("id"));
			t.setName(rs.getString("name"));
			t.setSubject(rs.getString("subject"));
			return t;
		},id);
		
		return list.stream().findFirst();
		//findFirst returns an object of Type Optional<T>
	}
	
	/*Here template.query is passed with the sql,rowmapper object and id.
	 * The list is converted to a stream and the first value is taken.
	 * It is of optional type so it can avoid nullpointer exception
	 */
	

}
