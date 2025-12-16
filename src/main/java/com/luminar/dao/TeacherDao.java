package com.luminar.dao;

import java.util.List;
import java.util.Optional;

import com.luminar.beans.TeacherBean;

public interface TeacherDao {
	void insertTeacher(TeacherBean teacher);
	
	int updateTeacherRecord(TeacherBean teacher);
	
	int removeTeacherById(int id);
	
	List<TeacherBean> fetchAllTeachers();
	
	Optional<TeacherBean> fetchTeacherById(int id);
}
