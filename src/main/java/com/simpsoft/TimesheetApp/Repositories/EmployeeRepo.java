package com.simpsoft.TimesheetApp.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import com.simpsoft.TimesheetApp.Models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
}