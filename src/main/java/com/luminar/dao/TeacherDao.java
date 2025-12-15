package com.luminar.dao;

import java.util.List;

import com.luminar.beans.TeacherBean;

public interface TeacherDao {
	void insertTeacher(TeacherBean teacher);
	
	int updateTeacherRecord(TeacherBean teacher);
	
	int removeTeacherById(int id);
	
	List<TeacherBean> fetchAllTeachers();
}
