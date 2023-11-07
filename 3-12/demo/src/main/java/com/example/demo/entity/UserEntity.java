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
@Table(name ="middleSkill")
public class UserEntity implements Serializable {

	/**
	 * ID
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;

	/*
	 * name
	 */
	@Column(name = "name")
	private String name;

	/*
	 * furigana
	 */
	@Column(name = "furigana")
	private String furigana;

	/*
	 * mail
	 */
	@Column(name = "mail")
	private String mail;

	/*
	 * password
	 */
	@Column(name = "password")
	private String password;

	/*
	 * resiter_date
	 */
	@Column(name = "create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date create_date;
}