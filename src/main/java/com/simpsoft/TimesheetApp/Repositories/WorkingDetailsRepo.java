package com.simpsoft.TimesheetApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simpsoft.TimesheetApp.Models.WorkingDetails;

public interface WorkingDetailsRepo extends JpaRepository<WorkingDetails, Integer> {

}
