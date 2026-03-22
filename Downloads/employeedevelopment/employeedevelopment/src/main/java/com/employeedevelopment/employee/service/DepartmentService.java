package com.employeedevelopment.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedevelopment.employee.entity.Department;
import com.employeedevelopment.employee.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Department updateDepartment(Long id, Department department) {
	    Department dept = departmentRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Department not found"));

	    dept.setDeptid(department.getDeptid());
	    dept.setName(department.getName());
	    dept.setLocation(department.getLocation());

	    return departmentRepository.save(dept);
	}

	
	public void deleteDepartment(Long id) {
		 departmentRepository.deleteById(id);
	}
	
	public List<Department> getAllDepartment(){
		return departmentRepository.findAll();
	}
	

}
