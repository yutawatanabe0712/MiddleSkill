package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ExpenceRequest;
import com.example.demo.entity.ExpenceEntity;
import com.example.demo.repository.ExpenceRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenceService {

	/*
	 * Repository
	 */
	@Autowired
	private ExpenceRepository expenceRepository;
	
	/*
	 * 経費登録
	 */
	public void create(ExpenceRequest expenceRequest) {
		ExpenceEntity expence = new ExpenceEntity();
		expence.setUser_id(expenceRequest.getUser_id());
		expence.setExpense(expenceRequest.getExpence());
		expenceRepository.save(expence);
	}
}
