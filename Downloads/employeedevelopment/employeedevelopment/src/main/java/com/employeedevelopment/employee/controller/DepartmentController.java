package com.employeedevelopment.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeedevelopment.employee.entity.Department;
import com.employeedevelopment.employee.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	@Autowired
	public DepartmentService departmentService;
	@PostMapping("/save")
	public Department createDepartment(@RequestBody Department dept) {
		return departmentService.createDepartment(dept);
	}
	@PutMapping("/update")
	public Department updateDepartment(@PathVariable Long id,Department dept) {
		return departmentService.updateDepartment(id, dept);
	}
	@DeleteMapping("/delete")
	public void  deleteDepartment(Long id) {
		departmentService.deleteDepartment(id);
	}
	@GetMapping("/find")
	public List<Department> findAllDepartment() {
		return departmentService.getAllDepartment();
	}
	
	

}
