package com.luminar.service;

import java.util.List;

import com.luminar.beans.TeacherBean;

public interface TeacherService {
	void saveTeacher(TeacherBean teacher);
	
	int updateTeacher(TeacherBean teacher);
	
	int deleteTeacher(int id);
	
	List<TeacherBean> getTeacherDetails();
}
