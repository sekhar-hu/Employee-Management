package com.employeedevelopment.employee.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="adit_log")
public class Adit_Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long logId;
	
	private String entityName;
	private long entityid;
	private String action;
	
	@Column(length = 2000)
	private String newvalue;
	
	@Column(length = 2000)
	private String oldvalue;
	
	private String changedBy;
	private LocalDateTime chengAt;
	public long getLogId() {
		return logId;
	}
	public void setLogId(long logId) {
		this.logId = logId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public long getEntityid() {
		return entityid;
	}
	public void setEntityid(long entityid) {
		this.entityid = entityid;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getNewvalue() {
		return newvalue;
	}
	public void setNewvalue(String newvalue) {
		this.newvalue = newvalue;
	}
	public String getOldvalue() {
		return oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		this.oldvalue = oldvalue;
	}
	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	public LocalDateTime getChengAt() {
		return chengAt;
	}
	public void setChengAt(LocalDateTime localDateTime) {
		this.chengAt = localDateTime;
	}
	
	
	
	
	

}
