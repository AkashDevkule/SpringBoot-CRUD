package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.DTO.EmpDTO;
import com.employee.exception.EmpException;
import com.employee.service.EmpServiceImpl;

@RestController
@RequestMapping(path = "/")
public class EmpRESTController {

	@Autowired
	private EmpServiceImpl empService;

	@Autowired
	private Environment environment;

	
	@GetMapping(path = "/")
	public String homePage() {
		return "<h1>Home Page</h1>";
	}
	
	@PostMapping(path = "emp/create")
	public ResponseEntity<String> createEmp(@RequestBody EmpDTO emp) {

		Integer empId = empService.createEmp(emp);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + empId;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

//	@PostMapping(path = "multiemp/create")
//	public void createEmps(@RequestBody Iterable<Emp> emps) {
//		empService.createEmps(emps);
//	}

	@GetMapping(path = "id/{id}")
	public ResponseEntity<EmpDTO> getEmpById(@PathVariable("id") Integer id) throws EmpException {
		EmpDTO emp = empService.findEmpById(id);
		return new ResponseEntity<>(emp, HttpStatus.OK);
//		return empService.findEmpById(id);
	}

	@GetMapping(path = "/allemps")
	public ResponseEntity<List<EmpDTO>> getAllEmp() throws EmpException {
		List<EmpDTO> empList = empService.findAllEmps();
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@PutMapping(path = "update/id/{id}/newDc/{newDc}")
	public ResponseEntity<String> updateEmpDCById(@PathVariable("id") Integer id, @PathVariable("newDc") String newDc)
			throws EmpException {
		try {
			empService.updateEmpDCById(id, newDc);
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		

	}

	@DeleteMapping(path = "delete/id/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable("id") Integer id) throws EmpException {	
		try {
			empService.deleteEmpById(id);
			String successMessage = environment.getProperty("API.DELETE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		

	}
}
