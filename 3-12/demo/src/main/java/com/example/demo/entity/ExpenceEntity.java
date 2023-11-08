package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "expense_tb")
public class ExpenceEntity implements Serializable {

	/**
	 * expence_id
	 */
	@Id
	@Column(name = "expence_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer expence_id;

	/*
	 * user_id
	 */
	@Column(name = "user_id")
	private Integer user_id;
	
	/*
	 * expense
	 */
	@Column(name = "expense")
	private Integer expense;
}