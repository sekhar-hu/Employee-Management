package com.employeedevelopment.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedevelopment.employee.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee>findByManagerEmpId(Long managerId);

}
