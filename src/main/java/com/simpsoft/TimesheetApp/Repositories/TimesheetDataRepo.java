package com.simpsoft.TimesheetApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.simpsoft.TimesheetApp.Models.TimesheetData;

@Component
public interface TimesheetDataRepo extends JpaRepository<TimesheetData, Integer>{

}
