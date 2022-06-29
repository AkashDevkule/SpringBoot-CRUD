package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.DTO.EmpDTO;
import com.employee.entities.Emp;
import com.employee.exception.EmpException;
import com.employee.repository.EmpRepository;

@Service(value = "empService")
@Transactional
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepository;

	@Override
	public void createEmp(EmpDTO emp)throws EmpException {

		boolean isEmailNotPresent = empRepository.findByEmail(emp.getEmp_email()).isEmpty();
		boolean isMobileNoNotPresent = empRepository.findByMobno(emp.getEmp_mobno()).isEmpty();

		if (!empRepository.existsById(emp.getEmp_id())) {
			if (!isMobileNoNotPresent) {
				if (!isEmailNotPresent) {
					Emp empEntity = new Emp();
					empEntity.setEmp_id(emp.getEmp_id());
					empEntity.setEmp_name(emp.getEmp_name());
					empEntity.setEmail(emp.getEmp_email());
					empEntity.setMobno(emp.getEmp_mobno());
					empEntity.setEmp_city(emp.getEmp_city());

					Emp empEntity2 = empRepository.save(empEntity);
					System.out.println("These are the details of emp: -");
					System.out.print(empEntity2);
					System.out.println("Successfuly added emp is EMP_DB!");
//					return empEntity2.getEmp_id();
				} else {
					
					throw new EmpException("EmpService.EMPLOYEE_EMAIL_ALREADY_PRESENT");
				}
			} else {
				
				throw new EmpException("EmpService.EMPLOYEE_MOBILE_NUMBER_ALREADY_PRESENT");
			}
		} else {
			
			throw new EmpException("EmpService.EMPLOYEE_ID_ALREADY_PRESENT");
		}
	}

//	@Override
//	public void createEmps(Iterable<EmpDTO> emps) {
//		Iterable<Emp> result = empRepository.saveAll(emps);
//		System.out.println("These r the details of users: -");
//		result.forEach(emp -> {
//			System.out.println(emp);
//		});
//		System.out.println("Successfuly added employees is EMP_DB!");
//	}

	@Override
	public EmpDTO findEmpById(Integer idToFind) throws EmpException {
		System.out.println("Find by Id is " + idToFind);
		if (idToFind == null)
			throw new EmpException(" User Id can't be null");

		Optional<Emp> optional = empRepository.findById(idToFind);
		Emp empEntity = optional
				.orElseThrow(() -> new EmpException(idToFind + " is Not Valid Id.....please enter the valid Id!!"));

		EmpDTO emp2 = new EmpDTO();

		emp2.setEmp_id(empEntity.getEmp_id());
		emp2.setEmp_name(empEntity.getEmp_name());
		emp2.setEmp_email(empEntity.getEmail());
		emp2.setEmp_mobno(empEntity.getEmp_mobno());
		emp2.setEmp_city(empEntity.getEmp_city());

//		if (optional.isPresent())
//			// System.out.println("This is the user of ID is 2: -");
//			return 
//		throw new EmpException(idToFind + " is Not Valid Id.....please enter the valid Id!!");

		return emp2;
	}

	@Override
	public List<EmpDTO> findAllEmps() throws EmpException {
		Iterable<Emp> emps = empRepository.findAll();
		List<EmpDTO> emp2 = new ArrayList<>();

		emps.forEach(emp -> {
			EmpDTO empDto = new EmpDTO();
			empDto.setEmp_id(emp.getEmp_id());
			empDto.setEmp_name(emp.getEmp_name());
			empDto.setEmp_email(emp.getEmail());
			empDto.setEmp_mobno(emp.getEmp_mobno());
			empDto.setEmp_city(emp.getEmp_city());
			emp2.add(empDto);
		});
		if (emp2.isEmpty())
			throw new EmpException("Service.CUSTOMERS_NOT_FOUND");
		return emp2;
	}

	@Override
	public void updateEmpDCById(Integer idToUpdate, String newCity) throws EmpException {

		System.out.println("Find the user by Id =" + idToUpdate);

		if (idToUpdate == null)
			throw new EmpException(idToUpdate + " is not valid Id.");

		Optional<Emp> empFindById = empRepository.findById(idToUpdate);

		if (!empFindById.isPresent())
			throw new EmpException(empFindById + " this Id is not present in DB");

		Emp updateCityName = empFindById.get();
		updateCityName.setEmp_city(newCity);

		Emp updatedCityName = empRepository.save(updateCityName);
		System.out.println("Successfuly Updated City!" + updatedCityName);

	}

	@Override
	public void deleteEmpById(Integer idToDelete) throws EmpException {
		System.out.println("Delete the user by Id = " + idToDelete);
		Optional<Emp> empFindById = empRepository.findById(idToDelete);
//		if (!empFindById.isPresent())
//			throw new EmpException(empFindById + " this Id is not present in DB");

		Emp emp = empFindById.orElseThrow(() -> new EmpException("Service.CUSTOMERS_NOT_FOUND"));
		empRepository.deleteById(emp.getEmp_id());
		System.out.println(empFindById + " is Successfuly deleted! ");

	}

}
