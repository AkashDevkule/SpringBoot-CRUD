package com.employee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer> {

	public Optional<Emp> findByEmail(String email);
	public Optional<Emp> findByMobno(Long mobno);
}
