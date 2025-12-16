package com.luminar.service;

import java.util.List;
import java.util.Optional;

import com.luminar.beans.TeacherBean;

public interface TeacherService {
	void saveTeacher(TeacherBean teacher);
	
	int updateTeacher(TeacherBean teacher);
	
	int deleteTeacher(int id);
	
	List<TeacherBean> getTeacherDetails();
	
	Optional<TeacherBean> getTeacherById(int id);
}
