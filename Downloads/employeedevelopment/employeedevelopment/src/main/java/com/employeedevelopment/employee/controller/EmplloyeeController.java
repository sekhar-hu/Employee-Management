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

import com.employeedevelopment.employee.entity.Employee;
import com.employeedevelopment.employee.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmplloyeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/save")
	public Employee CreateEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	@PutMapping("/update")
	public Employee updateEmployee(@PathVariable Long id,Employee employee) {
		return employeeService.updateEmployee(id, employee);
		
	}
	@DeleteMapping("/delete")
	public void  deleteEmployee(Long id) {
		employeeService.deleteEmployee(id);
	}
	@GetMapping("/find")
	public List<Employee> findAllEmployee(){
		return employeeService.getAllEmployee();
	}
	@GetMapping("/manager/{managerid}")
	public List<Employee> getByManager(@PathVariable Long managerId){
		return employeeService.getEmployeeByManager(managerId);
	}

}
