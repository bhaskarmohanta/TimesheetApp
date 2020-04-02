package com.simpsoft.TimesheetApp.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "timesheet_data")
public class TimesheetData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int emp_ref_id;
	private Date from_date;
	private Date to_date;
	private String display_date;
	private String day;
	private int month;
	private int session;
	private int non_working_id;
	private int non_working_hrs;
	private String non_working_cmnt;
	private int total_hrs;
	private boolean status = true;

	@OneToMany(mappedBy = "workingDetails", cascade = { CascadeType.ALL })
//	@ElementCollection(targetClass = WorkingDetails.class)
	private List<WorkingDetails> workingDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmp_ref_id() {
		return emp_ref_id;
	}

	public void setEmp_ref_id(int emp_ref_id) {
		this.emp_ref_id = emp_ref_id;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public String getDisplay_date() {
		return display_date;
	}

	public void setDisplay_date(String display_date) {
		this.display_date = display_date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getSession() {
		return session;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public int getNon_working_id() {
		return non_working_id;
	}

	public void setNon_working_id(int non_working_id) {
		this.non_working_id = non_working_id;
	}

	public int getNon_working_hrs() {
		return non_working_hrs;
	}

	public void setNon_working_hrs(int non_working_hrs) {
		this.non_working_hrs = non_working_hrs;
	}

	public String getNon_working_cmnt() {
		return non_working_cmnt;
	}

	public void setNon_working_cmnt(String non_working_cmnt) {
		this.non_working_cmnt = non_working_cmnt;
	}

	public int getTotal_hrs() {
		return total_hrs;
	}

	public void setTotal_hrs(int total_hrs) {
		this.total_hrs = total_hrs;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<WorkingDetails> getWorkingDetails() {
		return workingDetails;
	}

	public void setWorkingDetails(List<WorkingDetails> workingDetails) {
		this.workingDetails = workingDetails;
	}

	@Override
	public String toString() {
		return "TimesheetData [id=" + id + ", emp_ref_id=" + emp_ref_id + ", from_date=" + from_date + ", to_date="
				+ to_date + ", display_date=" + display_date + ", day=" + day + ", month=" + month + ", session="
				+ session + ", non_working_id=" + non_working_id + ", non_working_hrs=" + non_working_hrs
				+ ", non_working_cmnt=" + non_working_cmnt + ", total_hrs=" + total_hrs + ", status=" + status
				+ ", workingDetails=" + workingDetails + "]";
	}

}
