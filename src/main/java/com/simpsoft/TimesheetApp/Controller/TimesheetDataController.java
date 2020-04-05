package com.simpsoft.TimesheetApp.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.simpsoft.TimesheetApp.Models.TimesheetData;
import com.simpsoft.TimesheetApp.Models.WorkingDetails;
import com.simpsoft.TimesheetApp.Repositories.TimesheetDataRepo;

@RestController
public class TimesheetDataController {

	@Autowired
	private TimesheetDataRepo tDataRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ListTimesheets")
	public List<TimesheetData> findData() {

		return tDataRepo.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ListTimesheets/{year}/{month}/{emp_id}/{status}")
	public List<TimesheetData> findData(@PathVariable int year, @PathVariable int month, @PathVariable int emp_id,
			@PathVariable int status) {

		List<TimesheetData> filteredData = null;
		if (emp_id != 0) {
			filteredData = tDataRepo.findAll().stream()
					.filter(x -> x.getYear() == year && x.getMonth() == month && x.getEmp_ref_id() == emp_id)
					.collect(Collectors.toList());
		} else {
			filteredData = tDataRepo.findAll().stream().filter(x -> x.getYear() == year && x.getMonth() == month)
					.collect(Collectors.toList());
		}

		if (status != 0) {
			filteredData = filteredData.stream().filter(x -> x.getStatus() == status).collect(Collectors.toList());
		}

		return filteredData;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/CheckDataTimesheet/{emp_id}/{from_date}/{to_date}")
	public List<String> findData(@PathVariable int emp_id, @PathVariable String from_date,
			@PathVariable String to_date) throws ParseException {

		List<TimesheetData> filteredData = tDataRepo.findAll();
		List<String> stringData = new ArrayList<String>();

		if (emp_id != 0 && from_date != null && to_date != null) {
			filteredData = tDataRepo.findAll().stream()
					.filter(x -> x.getEmp_ref_id() == emp_id
							&& x.getFrom_date().toString().substring(0, 10).replace("-", "").equals(from_date)
							&& x.getTo_date().toString().substring(0, 10).replace("-", "").equals(to_date))
					.collect(Collectors.toList());
			
			filteredData.stream().forEach(item -> {
				stringData.add(item.getDay());
			});
		}

		return stringData;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/timesheet")
	public TimesheetData save(@RequestBody TimesheetData tData) {

		List<WorkingDetails> wDataChild = new ArrayList<WorkingDetails>();

		tData.getWorkingDetails().stream().forEach(item -> {

			item.setWorkingDetails(tData);
			wDataChild.add(item);
		});

		tDataRepo.save(tData);
		return tData;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/UpdateTimesheetNote/{id}")
	public TimesheetData updateTimesheetNote(@PathVariable int id, @RequestBody TimesheetData tData) {

		return tDataRepo.findById(id).map(item -> {
			item.setStatus(tData.getStatus());
			item.setAdmin_note(tData.getAdmin_note());
			tDataRepo.save(item);
			tData.setId(id);
			return tData;
		}).orElse(null);
	}
}
