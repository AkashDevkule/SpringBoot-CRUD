package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.entities.Emp;

public interface EmpRepository extends CrudRepository<Emp, Integer> {

}
