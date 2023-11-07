package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;


@Controller
public class UserListController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userList")
	public String displayList(Model model) {
		List<UserEntity> userLists = userService.serchAll();
		model.addAttribute("userLists", userLists);
		return "UserList";
	}
}