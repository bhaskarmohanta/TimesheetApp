package com.simpsoft.TimesheetApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeeLeave {

	@Id
	@GeneratedValue
	private int id;
	private int emp_id;
	private String to_date;
	private String from_date;
	private String leave_cmnt;
	private int leave_type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getLeave_cmnt() {
		return leave_cmnt;
	}
	public void setLeave_cmnt(String leave_cmnt) {
		this.leave_cmnt = leave_cmnt;
	}
	public int getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(int leave_type) {
		this.leave_type = leave_type;
	}
	@Override
	public String toString() {
		return "EmployeeLeave [id=" + id + ", emp_id=" + emp_id + ", to_date=" + to_date + ", from_date=" + from_date
				+ ", leave_cmnt=" + leave_cmnt + ", leave_type=" + leave_type + "]";
	}
	
	
}