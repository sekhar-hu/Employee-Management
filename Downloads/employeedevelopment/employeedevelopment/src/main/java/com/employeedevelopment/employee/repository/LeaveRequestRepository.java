package com.employeedevelopment.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedevelopment.employee.entity.LeaveRequest;
@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
	List<LeaveRequest>findByEmployeeEmpId(Long empid);


}
