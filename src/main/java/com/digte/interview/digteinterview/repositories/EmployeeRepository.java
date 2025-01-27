package com.digte.interview.digteinterview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digte.interview.digteinterview.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
