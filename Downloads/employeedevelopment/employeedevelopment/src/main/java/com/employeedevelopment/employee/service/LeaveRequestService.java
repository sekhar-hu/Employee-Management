package com.employeedevelopment.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeedevelopment.employee.entity.LeaveRequest;
import com.employeedevelopment.employee.repository.LeaveRequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveRequestService {
	private LeaveRequestRepository leaveRequestRepository;
	
	public LeaveRequest applyLeave(LeaveRequest leave) {
		leave.setStatus("PENDING");
		return leaveRequestRepository.save(leave);
	}
	
	public LeaveRequest approveLeave(Long leaveId) {

	    LeaveRequest leave = leaveRequestRepository.findById(leaveId)
	            .orElseThrow(() -> new RuntimeException("Leave not found"));

	    leave.setStatus("APPROVED");

	    return leaveRequestRepository.save(leave);
	}
	
	public LeaveRequest rejectLeave(Long leaveId) {

	    LeaveRequest leave = leaveRequestRepository.findById(leaveId)
	            .orElseThrow(() -> new RuntimeException("Leave not found"));

	    leave.setStatus("REJECTED");

	    return leaveRequestRepository.save(leave);
	}

	
	public List<LeaveRequest> getLeaveByEmployee(Long empid){
		return leaveRequestRepository.findByEmployeeEmpId(empid);
	}
	
	public List<LeaveRequest> getAllLeave(){
		return leaveRequestRepository.findAll();
	}
	

}
