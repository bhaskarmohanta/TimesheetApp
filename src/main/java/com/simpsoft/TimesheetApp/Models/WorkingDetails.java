package com.simpsoft.TimesheetApp.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class WorkingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int project_id;
	private int working_hrs;
	private String cmnt;
	private boolean status;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "working_details_id")
	private TimesheetData workingDetails;
//
//	public WorkingDetails() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public WorkingDetails(int id, int project_id, int working_hrs, String cmnt, boolean status,
//			TimesheetData workingDetails) {
//		super();
//		this.id = id;
//		this.project_id = project_id;
//		this.working_hrs = working_hrs;
//		this.cmnt = cmnt;
//		this.status = status;
//		this.workingDetails = workingDetails;
//	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getWorking_hrs() {
		return working_hrs;
	}

	public void setWorking_hrs(int working_hrs) {
		this.working_hrs = working_hrs;
	}

	public String getCmnt() {
		return cmnt;
	}

	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@JsonProperty(access = Access.WRITE_ONLY)
	public TimesheetData getWorkingDetails() {
		return workingDetails;
	}

	public void setWorkingDetails(TimesheetData workingDetails) {
		this.workingDetails = workingDetails;
	}

	@Override
	public String toString() {
		return "WorkingDetails [id=" + id + ", project_id=" + project_id + ", working_hrs=" + working_hrs + ", cmnt="
				+ cmnt + ", status=" + status + ", workingDetails=" + workingDetails + "]";
	}

}
