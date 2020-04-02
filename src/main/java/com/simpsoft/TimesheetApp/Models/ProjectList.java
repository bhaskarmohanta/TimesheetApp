package com.simpsoft.TimesheetApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class ProjectList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String project_name;
	
	@ColumnDefault(value = "1")
	boolean status = true;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ProjectEntity [id=" + id + ", project_name=" + project_name + ", status=" + status + "]";
	}
	
	

}
