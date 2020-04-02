package com.simpsoft.TimesheetApp.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "non_working_master")
public class NonWorkingMaster {

	@Id
	private int id;
	private String type;
	private boolean status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "NonWorkingMasterEntity [id=" + id + ", type=" + type + ", status=" + status + "]";
	}
	
	
}
