package com.simpsoft.TimesheetApp.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simpsoft.TimesheetApp.Models.Employee;
import com.simpsoft.TimesheetApp.Models.EmployeeLeave;
import com.simpsoft.TimesheetApp.Repositories.EmployeeLeaveRepo;
import com.simpsoft.TimesheetApp.Repositories.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo empRepo;

	@Autowired
	EmployeeLeaveRepo empLeaveRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ListEmployees")
	public List<Employee> fetchAll() {
		return empRepo.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/EmployeeLeavesView/{emp_id}/{status}/{from_date}/{to_date}")
	public List<EmployeeLeave> fetchAllLeaves(@PathVariable int emp_id, @PathVariable int status,
			@PathVariable String from_date, @PathVariable String to_date) throws ParseException {

		List<EmployeeLeave> empLeaveData = null;

		Date f_date = new SimpleDateFormat("yyyyMMdd").parse(from_date);
		Date t_date = new SimpleDateFormat("yyyyMMdd").parse(to_date);

		if (emp_id != 0) {
			empLeaveData = empLeaveRepo.findAll().stream().filter(item -> item.getEmp_id() == emp_id
					&& item.getFrom_date().before(t_date) && item.getTo_date().after(f_date))
					.collect(Collectors.toList());
		} else {
			empLeaveData = empLeaveRepo.findAll().stream()
					.filter(item -> item.getFrom_date().before(t_date) && item.getTo_date().after(f_date))
					.collect(Collectors.toList());
		}

		if (status != 0) {
			empLeaveData = empLeaveData.stream().filter(x -> x.getStatus() == status).collect(Collectors.toList());
		}
		return empLeaveData;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/EmployeeLeavesUpdate/{id}/{status}/{adminNote}")
	public boolean updateLeave(@PathVariable int id, @PathVariable int status, @PathVariable String adminNote) {

		empLeaveRepo.findById(id).map(item -> {
			item.setStatus(status);
			item.setAdmin_note(adminNote);
			empLeaveRepo.save(item);
			return true;
		});

		return false;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/EmployeeLeave")
	public EmployeeLeave save(@RequestBody EmployeeLeave empLeave) {
		empLeaveRepo.save(empLeave);
		return empLeave;
	}
}
