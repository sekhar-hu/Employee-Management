package com.employeedevelopment.employee.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.employeedevelopment.employee.entity.Adit_Log;
import com.employeedevelopment.employee.repository.Adit_logRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditLogService {
	private Adit_logRepository adit_logRepository;
	
	public void logChange(String entityName,long entityId,String action,String oldValue,String newValue,String changedBy) {
		Adit_Log log=new Adit_Log();
		log.setEntityName(entityName);
		log.setEntityid(entityId);
		log.setAction(action);
		log.setOldvalue(oldValue);
		log.setNewvalue(newValue);
		log.setChangedBy(changedBy);
		log.setChengAt(LocalDateTime.now());
		adit_logRepository.save(log);
	}

}
