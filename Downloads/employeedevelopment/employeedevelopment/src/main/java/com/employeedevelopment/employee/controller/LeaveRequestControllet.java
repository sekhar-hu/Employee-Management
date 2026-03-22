package com.employeedevelopment.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeedevelopment.employee.entity.LeaveRequest;
import com.employeedevelopment.employee.service.LeaveRequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/leave")
@RequiredArgsConstructor
public class LeaveRequestControllet {
	private LeaveRequestService leaveRequestService;
	@PostMapping("/apply")
	public LeaveRequest applyLeave(@RequestBody LeaveRequest leave) {
		return leaveRequestService.applyLeave(leave);
	}
	@PutMapping("/approve/{id}")
	public LeaveRequest approveLeave(@PathVariable Long id) {
		return leaveRequestService.approveLeave(id);
	}
	@PutMapping("/employee/{id}")
	public LeaveRequest rejectLeave(@PathVariable Long id) {
		return leaveRequestService.rejectLeave(id);
	}
	@GetMapping("/employee/{empid}")
	public List<LeaveRequest> getLeaveByEmployee(@PathVariable Long empid){
		return leaveRequestService.getLeaveByEmployee(empid);
	}
	@GetMapping
	public List<LeaveRequest> getAllEmployee(){
		return leaveRequestService.getAllLeave();
	}

}
