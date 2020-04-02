package com.simpsoft.TimesheetApp.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simpsoft.TimesheetApp.Models.WorkingDetails;
import com.simpsoft.TimesheetApp.Repositories.TimesheetDataRepo;
import com.simpsoft.TimesheetApp.Repositories.WorkingDetailsRepo;

@RestController
public class WorkingDetailsController {

	@Autowired
	private TimesheetDataRepo tDataRepo;

	@Autowired
	WorkingDetailsRepo wDataRepo;

	@PostMapping("/timesheet/{timesheetId}/projectDetails")
	public WorkingDetails createCourse(@PathVariable(value = "timesheetId") int timesheetId, @Valid @RequestBody WorkingDetails wData) throws ResourceNotFoundException {
		
		return tDataRepo.findById(timesheetId).map(item -> {
			wData.setWorkingDetails(item);
			return wDataRepo.save(wData);
		}).orElseThrow(() -> new ResourceNotFoundException("Item not found"));
	}
}