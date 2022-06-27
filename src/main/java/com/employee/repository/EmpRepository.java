package com.employee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer> {

	public Optional<Emp> findByEmpEmail(String email);
	public Optional<Emp> findByEmpMobNo(Long mobno);
}
