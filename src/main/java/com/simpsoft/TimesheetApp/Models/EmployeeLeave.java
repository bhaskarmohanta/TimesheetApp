package com.simpsoft.TimesheetApp.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class EmployeeLeave {

	@Id
	@GeneratedValue
	private int id;
	private int emp_id;
	private Date to_date;
	private Date from_date;
	private String leave_cmnt;
	private int leave_type;
	@Size(max = 1000)
	private String admin_note;
	private int status;

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

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
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

	public String getAdmin_note() {
		return admin_note;
	}

	public void setAdmin_note(String admin_note) {
		this.admin_note = admin_note;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeLeave [id=" + id + ", emp_id=" + emp_id + ", to_date=" + to_date + ", from_date=" + from_date
				+ ", leave_cmnt=" + leave_cmnt + ", leave_type=" + leave_type + ", admin_note=" + admin_note
				+ ", status=" + status + "]";
	}

}