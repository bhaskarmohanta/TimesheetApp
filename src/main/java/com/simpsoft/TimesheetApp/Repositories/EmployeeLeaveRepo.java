package com.simpsoft.TimesheetApp.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.simpsoft.TimesheetApp.Models.EmployeeLeave;

public interface EmployeeLeaveRepo extends JpaRepository<EmployeeLeave, Integer>{

	
}