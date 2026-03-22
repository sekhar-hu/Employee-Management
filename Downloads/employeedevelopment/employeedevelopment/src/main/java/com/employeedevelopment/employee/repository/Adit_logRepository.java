package com.employeedevelopment.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeedevelopment.employee.entity.Adit_Log;
@Repository
public interface Adit_logRepository extends JpaRepository<Adit_Log, Long> {
	

}
