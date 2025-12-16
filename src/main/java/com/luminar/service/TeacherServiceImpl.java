package com.luminar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luminar.beans.TeacherBean;
import com.luminar.dao.TeacherDao;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;

	@Override
	public void saveTeacher(TeacherBean teacher) {
		teacherDao.insertTeacher(teacher);
		
	}

	@Override
	public int updateTeacher(TeacherBean teacher) {
		return teacherDao.updateTeacherRecord(teacher);
	}

	@Override
	public int deleteTeacher(int id) {
		return teacherDao.removeTeacherById(id);
	}

	@Override
	public List<TeacherBean> getTeacherDetails() {
		return teacherDao.fetchAllTeachers();
	}

	@Override
	public Optional<TeacherBean> getTeacherById(int id) {
		return teacherDao.fetchTeacherById(id);
	}

}

/*
 * Service is just a layer between Controller and Dao to hide the Dao methods.
 */
