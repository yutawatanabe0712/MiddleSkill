package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "attendance_tb")
public class AttendanceEntity implements Serializable {

	/**
	 * attendance_id
	 */
	@Id
	@Column(name = "attendance_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expence_id;

	/*
	 * user_id
	 */
	@Column(name = "user_id")
	private Integer user_id;
	
	/*
	 * attendance_date
	 */
	@Column(name = "attendance_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date attendance_date;
}