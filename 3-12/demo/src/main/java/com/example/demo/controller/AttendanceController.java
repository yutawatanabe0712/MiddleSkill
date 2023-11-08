package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.service.AttendanceService;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;
	
	/*
	 * 出勤画面の表示
	 * @return 出勤画面
	 */
	@GetMapping("/attendance")
	public String displayExpence(Model model) {
		model.addAttribute("AttendanceRequest", new AttendanceRequest());
		return "Attendance";
	}
	
	/**
	   * 出勤登録
	   * @param userRequest リクエストデータ
	   * @return マイページ
	   */
	@PostMapping("/attendance/create")
	public String create(@ModelAttribute @Validated AttendanceRequest attendanceRequest, BindingResult result, Model model) {
		attendanceService.create(attendanceRequest);
		return "mypage";
	}
}
