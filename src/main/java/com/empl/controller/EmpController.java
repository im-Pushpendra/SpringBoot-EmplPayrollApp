package com.empl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empl.Response;
import com.empl.dto.EmpDto;
import com.empl.entities.EmpModel;
import com.empl.service.IEmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	IEmpService empService;
	@Autowired
	Response response;
	Logger log=LoggerFactory.getLogger(EmpController.class);
	
	@PostMapping("/addEmp")
	public ResponseEntity<Response> addUser(@RequestBody EmpDto dto) {
		EmpDto user = empService.addEmp(dto);
		response.setMsg("Employee Added Successfully");
		response.setObject(user);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/fetchEmpById/{id}")
	public ResponseEntity<Response> fetchById(@PathVariable int id) {
		EmpDto Emp = empService.fetchEmpById(id);
		response.setMsg("fetched Successfully");
		response.setObject(Emp);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/fetchEmp")
	public ResponseEntity<Response> fetch() {
		List<EmpDto> Emp = empService.fetchEmp();
		response.setMsg("fetched Successfully");
		response.setObject(Emp);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp")
	public ResponseEntity<Response> deleteUser(@RequestParam int id) {
		EmpModel Emp = empService.deleteEmp(id);
		response.setMsg("Deleted Successfully");
		response.setObject(Emp);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Response> updateEmp(@PathVariable int id, @RequestBody EmpDto dto) {
		EmpDto user = empService.updateEmp(id, dto);
			response.setMsg("Updated Successfully");
			response.setObject(user);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}

}

