package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;

//	/*
//	 *マイページの表示
//	 */
	@GetMapping("/mypage")
	public String displayMypage(Model model) {
		return "mypage";
	}

	/*
	 * ユーザー登録画面の
	 * @param model Model
	 * @return ユーザー新規登録画面
	 */
	@GetMapping("/registration")
	public String displayRegistration(Model model) {
		model.addAttribute("UserRequest", new UserRequest());
		return "UserRegistration";
	}

	/**
	   * ユーザー新規登録
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return マイページ
	   */
	@PostMapping("/create")
	public String create(@ModelAttribute @Validated UserRequest userRequest, BindingResult result, Model model) {
		//6.if文をどこかで利用すること（１箇所で可）
		if (result.hasErrors()) {
			//入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			//7.for文をどこかで利用すること（１箇所で可）
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/UserRegistration";
		}
		//ユーザー情報の登録
		userService.create(userRequest);
		return "UserRegistration";
	}

	/**
	   * ユーザー編集画面を表示
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー編集画面
	   */
	@GetMapping("/{user_id}/edit")
	public String displayEdit(@PathVariable Integer user_id, Model model) {
		UserEntity user = userService.findById(user_id);
		UserRequest userRequest = new UserRequest();
		userRequest.setUser_id(user.getUser_id());
		userRequest.setName(user.getName());
		userRequest.setFurigana(user.getFurigana());
		userRequest.setMail(user.getMail());
		userRequest.setPassword(user.getPassword());
		model.addAttribute("userRequest", userRequest);
		return "UserEdit";
	}

	/**
	   * ユーザー情報を更新
	   * @param id 表示するユーザーID
	   * @param model Model
	   */

	@PostMapping("/update")
	public String update(@Validated @ModelAttribute UserRequest userRequest, BindingResult result,Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();

			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "UserEdit";
		}
			//ユーザー情報の更新
		userService.update(userRequest);
			return "mypage";
		}

	  /**
	   * ユーザー情報削除
	   * @param id 表示するユーザーID
	   * @param model Model
	   * @return ユーザー情報詳細画面
	   */
	  @GetMapping("/{user_id}/delete")
	  public String delete(@PathVariable Integer user_id, Model model) {
	    // ユーザー情報の削除
	    userService.delete(user_id);
	    return "redirect:/userList";
	  }
}