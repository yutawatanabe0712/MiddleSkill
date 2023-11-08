package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExpenceRequest implements Serializable{

	/**
	 * user_id
	 */
	private Integer user_id;

	/*
	 * attendance_date
	 */
	private Integer expence;
}