package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.ExpenceRequest;
import com.example.demo.service.ExpenceService;

@Controller
public class ExpenceController {

	@Autowired
	private ExpenceService expenceService;
	
	/*
	 * 経費登録画面の
	 * @return 経費登録画面
	 */
	@GetMapping("/expence")
	public String displayExpence(Model model) {
		model.addAttribute("ExpenceRequest", new ExpenceRequest());
		return "Expence";
	}
	
	/**
	   * 出勤登録
	   * @param userRequest リクエストデータ
	   * @return マイページ
	   */
	@PostMapping("/expence/create")
	public String create(@ModelAttribute ExpenceRequest expenceRequest, Model model) {
		expenceService.create(expenceRequest);
		return "mypage";
	}

}
