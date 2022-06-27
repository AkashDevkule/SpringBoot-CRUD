package com.employee.service;

import java.util.List;

import com.employee.DTO.*;
import com.employee.exception.EmpException;

public interface EmpService {

	public Integer createEmp(EmpDTO emp);
//	public void createEmps(Iterable<EmpDTO> emps);
	public EmpDTO findEmpById(Integer idToFind) throws EmpException;
	public List<EmpDTO> findAllEmps() throws EmpException;
	public void updateEmpDCById(Integer idToUpdate, String newCity) throws EmpException;
	public void deleteEmpById(Integer idToDelete) throws EmpException;
}
