package com.simpsoft.TimesheetApp.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "timesheet_data")
public class TimesheetData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int emp_ref_id;
//	@JsonFormat(pattern = "YYYY-MM-DD")
	private Date from_date;
//	@JsonFormat(pattern = "YYYY-MM-DD")
	private Date to_date;
	@JsonFormat(pattern = "DD-MMM-YYYY")
	private String display_date;
	private String day;
	private int month;
	private int year;
	private int non_working_id;
	private int non_working_hrs;
	private String non_working_cmnt;
	private int total_hrs;
	@Size(max = 1000)
	private String admin_note;
	private int status;

	@OneToMany(mappedBy = "workingDetails", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public List<WorkingDetails> getWorkingDetails() {
		return workingDetails;
	}

	public void setWorkingDetails(List<WorkingDetails> workingDetails) {
		this.workingDetails = workingDetails;
	}

	@Override
	public String toString() {
		return "TimesheetData [id=" + id + ", emp_ref_id=" + emp_ref_id + ", from_date=" + from_date + ", to_date="
				+ to_date + ", display_date=" + display_date + ", day=" + day + ", month=" + month + ", year=" + year
				+ ", non_working_id=" + non_working_id + ", non_working_hrs=" + non_working_hrs + ", non_working_cmnt="
				+ non_working_cmnt + ", total_hrs=" + total_hrs + ", admin_note=" + admin_note + ", status=" + status
				+ ", workingDetails=" + workingDetails + "]";
	}

}
