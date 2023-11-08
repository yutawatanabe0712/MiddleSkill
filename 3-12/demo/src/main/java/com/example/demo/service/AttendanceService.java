package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.AttendanceRequest;
import com.example.demo.entity.AttendanceEntity;
import com.example.demo.repository.AttendanceRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class AttendanceService {

	/*
	 * Repository
	 */
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	/*
	 * 出勤登録
	 */
	public void create(AttendanceRequest attendanceRequest) {
		AttendanceEntity attendance = new AttendanceEntity();
		try {
			String stDateString = attendanceRequest.getAttendance_date();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stDateString);
			attendance.setAttendance_date(date);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			Logger logger = Logger.getLogger("errorLog");
			ConsoleHandler cHandler = new ConsoleHandler();
			logger.addHandler(cHandler);
			//9.画面から操作しエラーが発生した場合に例外処理でログが吐き出される仕様にすること（１箇所で可）
			logger.log(Level.INFO, "例外のスローを捕捉", e);
		}
		attendance.setUser_id(attendanceRequest.getUser_id());
		attendanceRepository.save(attendance);
	}
}
