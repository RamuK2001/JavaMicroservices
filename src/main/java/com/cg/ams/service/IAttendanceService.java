package com.cg.ams.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.ams.entity.Attendance;
import com.cg.ams.entity.StudentEntity;
@Service
public interface IAttendanceService {
	
	public Attendance add(Attendance entity);
	public void update(Attendance entity);
	public void delete(Attendance entity);
	public Attendance findByName(String student_name);
	public Attendance findByPk(long id);
	//public List<StudentEntity> search(String name, int pageNo, int pageSize);
	
	public long count();
	List<Attendance> getAttBySid(long sid);

}
