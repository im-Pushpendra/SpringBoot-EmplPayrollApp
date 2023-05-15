package com.empl.service;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empl.dto.EmpDto;
import com.empl.entities.EmpModel;
import com.empl.exceptions.EmpException;
import com.empl.repository.EmpRepo;

@Service
public class EmpServiceImpl implements IEmpService {
	@Autowired
	EmpRepo empRepo;
	@Autowired
	ModelMapper modelmapper;
	Logger log=LoggerFactory.getLogger(EmpServiceImpl.class);
	
	@Override
	public EmpDto addEmp(EmpDto dto) {
		if (dto.name.equals(null)) {
			throw new EmpException("Required Fields are Mandatory.");
		}
		EmpModel emp = modelmapper.map(dto, EmpModel.class);
		empRepo.save(emp);
		return dto;
	}
	
	@Override
	public EmpDto fetchEmpById(int id) {
		EmpModel emp =empRepo.findById(id).get();
		EmpDto dto= modelmapper.map(emp, EmpDto.class);
		return dto;
	}
	
	@Override
	public List<EmpDto> fetchEmp() {
		List<EmpModel> employees = empRepo.findAll();
		List<EmpDto> emp=new ArrayList<>();
		for(EmpModel empModel:employees) {
			EmpDto empl = modelmapper.map(empModel, EmpDto.class);
			emp.add(empl);
		}
		return emp;
	}
	
	@Override
	public EmpModel deleteEmp(int id) {
		Optional<EmpModel> R = empRepo.findById(id);
		if (!R.isPresent()) {
			throw new EmpException("Id not Present");
		} else {
			empRepo.deleteById(id);
			log.info("Succesfully Deleted");
			log.warn("warned");
			log.error("error");
			log.debug("Debugged");
			log.trace("Traced");
			return null;
		}
	}

	@Override
	public EmpDto updateEmp(int id, EmpDto dto) {
		Optional<EmpModel> R = empRepo.findById(id);
		if (!R.isPresent()) {
			throw new EmpException("Id not Present");
		}
			EmpModel R1 = modelmapper.map(dto, EmpModel.class);
			R1.setId(R.get().getId());
			empRepo.save(R1);
			return dto;
	}

}

