package com.simpsoft.TimesheetApp.Controller;

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
	@GetMapping("/ListTimesheets/{year}/{month}")
	public List<TimesheetData> findData(@PathVariable int year, @PathVariable int month) {

		List<TimesheetData> allData = tDataRepo.findAll();
		List<TimesheetData> filteredData = allData.stream()
				.filter(x -> x.getSession() == year && x.getMonth() == month).collect(Collectors.toList());
		return filteredData;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/timesheet")
	public TimesheetData save(@RequestBody TimesheetData tData) {

		List<WorkingDetails> wDataChild = new ArrayList<WorkingDetails>();

		tData.getWorkingDetails().stream().forEach(item -> {

			item.setWorkingDetails(tData);
			wDataChild.add(item);
		});

		tData.setWorkingDetails(wDataChild);

		tDataRepo.save(tData);
		return tData;
	}
}
