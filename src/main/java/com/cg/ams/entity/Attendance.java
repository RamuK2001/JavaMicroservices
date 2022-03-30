package com.cg.ams.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate



@Table(name = "attendance")
public class Attendance {
	
	


	@Id
	private long id;
	
	
	
	//private long studentId;
	//private String studentName;
	
	private Date date;
	private String totalClass;
	private long status;
	private long total;
	private String percentage;
	
	public Attendance(long id, Date date, String totalClass, long status,
			long total, String percentage) {
		super();
		this.id = id;
		//this.studentId = studentId;
		//this.studentName = studentName;
		this.date = date;
		this.totalClass = totalClass;
		this.status = status;
		this.total = total;
		this.percentage = percentage;
	}
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	private StudentEntity student;
	
	
	
	
	
	

}
