package com.empl.service;

import java.util.List;

import com.empl.dto.EmpDto;
import com.empl.entities.EmpModel;

public interface IEmpService {

	EmpDto addEmp(EmpDto dto);
	
	EmpDto fetchEmpById(int id);

	List<EmpDto> fetchEmp();

	EmpModel deleteEmp(int id);

	EmpDto updateEmp(int id, EmpDto dto);

}

