package com.webapp.taskcreation;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue
	private int taskid;
	private String task_name;
	private long task_duration;
	private Date task_start_date;
	private Date task_end_date;
	private long total_number_of_days;
	private String status;

	public Task() {
	}

	public Task(int taskid, String task_name, long task_duration, Date task_start_date, Date task_end_date,
			int total_number_of_days, String status) {
		super();
		this.taskid = taskid;
		this.task_name = task_name;
		this.task_duration = task_duration;
		this.task_start_date = task_start_date;
		this.task_end_date = task_end_date;
		this.total_number_of_days = total_number_of_days;
		this.status = status;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public long getTask_duration() {
		return task_duration;
	}

	public void setTask_duration(long task_duration) {
		this.task_duration = task_duration;
	}

	public Date getTask_start_date() {
		return task_start_date;
	}

	public void setTask_start_date(Date task_start_date) {
		this.task_start_date = task_start_date;
	}

	public Date getTask_end_date() {
		return task_end_date;
	}

	public void setTask_end_date(Date task_end_date) {
		this.task_end_date = task_end_date;
	}

	public long getTotal_number_of_days() {
		return total_number_of_days;
	}

	public void setTotal_number_of_days(int total_number_of_days) {
		this.total_number_of_days = total_number_of_days;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
