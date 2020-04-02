package com.simpsoft.TimesheetApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpsoft.TimesheetApp.Models.ProjectList;
import com.simpsoft.TimesheetApp.Repositories.ProjectRepo;

@RestController
public class ProjectController {

	@Autowired
	private ProjectRepo pDataRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ListProjects")
	public List<ProjectList> findData() {
		return pDataRepo.findAll();
	}
}
