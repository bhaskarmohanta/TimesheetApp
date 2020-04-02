package com.simpsoft.TimesheetApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simpsoft.TimesheetApp.Models.Employee;
import com.simpsoft.TimesheetApp.Models.EmployeeLeave;
import com.simpsoft.TimesheetApp.Repositories.EmployeeLeaveRepo;
import com.simpsoft.TimesheetApp.Repositories.EmployeeRepo;

@RestController
public class EmployeeController {


	@Autowired
	EmployeeLeaveRepo empLeaveRepo;
	@Autowired
	EmployeeRepo empRepo;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ListEmployees")
	public List<Employee> fetchAll() {
		return empRepo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/EmployeeLeavesView")
	public List<EmployeeLeave> fetchAllLeaves() {
		return empLeaveRepo.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/EmployeeLeave")
	public EmployeeLeave save(@RequestBody EmployeeLeave empLeave) {
		empLeaveRepo.save(empLeave);
		return empLeave;
	}
}
