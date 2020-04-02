package com.simpsoft.TimesheetApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.simpsoft.TimesheetApp.Models.NonWorkingMaster;

public interface NonWorkingMasterRepo extends JpaRepository<NonWorkingMaster, Integer>{

}
