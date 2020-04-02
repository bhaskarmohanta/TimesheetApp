package com.simpsoft.TimesheetApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simpsoft.TimesheetApp.Models.ProjectList;

public interface ProjectRepo extends JpaRepository<ProjectList, Integer>{

}
