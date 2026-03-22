package com.employeedevelopment.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedevelopment.employee.entity.Employee;
import com.employeedevelopment.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
		@Autowired
		private  EmployeeRepository employeeRepository ;
		
		public Employee createEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}
		public Employee updateEmployee(Long id, Employee employee) {
		    Employee emp = employeeRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("Employee not found"));

		    emp.setName(employee.getName());
		    emp.setEmail(employee.getEmail());
		    emp.setDept(employee.getDept());
		    emp.setPhone(employee.getPhone());
		    emp.setSalaary(employee.getSalaary());
		    emp.setStatus(employee.getStatus());
		    emp.setEmpid(employee.getEmpid());

		    return employeeRepository.save(emp);
		}

			
			
			
		
		
		public void deleteEmployee(Long id) {
			employeeRepository.deleteById(id);
			
		}
		
		public List<Employee> getAllEmployee() {
			return employeeRepository.findAll();
		}
		
		public List<Employee> getEmployeeByManager(Long mangerId){
			return employeeRepository.findByManagerEmpId(mangerId);
		}
		
		
}
