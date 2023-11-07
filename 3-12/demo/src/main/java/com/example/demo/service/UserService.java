package com.example.demo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	/*
	 * Repository
	 */
	@Autowired
	private UserRepository userRepository;

	/*
	 * ユーザーを新規登録
	 */
	public void create(UserRequest userRequest) {

		/*
		 * ユーザー新規登録
		 */
		UserEntity user = new UserEntity();
		Date now = new Date();
		user.setName(userRequest.getName());
		user.setFurigana(userRequest.getFurigana());
		user.setMail(userRequest.getMail());
		user.setPassword(userRequest.getPassword());
		user.setCreate_date(now);
		userRepository.save(user);
	}

		/*
		 * ユーザー情報　主キー検索
		 * @return 検索結果
		 */
		public UserEntity findById(Integer user_id) {
			return userRepository.findById(user_id).get();
		}

		/*
		 *ユーザー情報更新
		 */
		public void update(UserRequest userRequest) {
			UserEntity user = findById(userRequest.getUser_id());
			//4.Mapをどこかで利用すること（１箇所で可）
			Map<String, String> map = new HashMap<>();
			map.put("key1","yyyy-MM-dd");
			try {
				String stDateString = userRequest.getCreate_date();
				//8.SimpleDateFormatをどこかで利用すること（１箇所で可）
				Date date = new SimpleDateFormat(map.get("key1")).parse(stDateString);
				user.setCreate_date(date);
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				Logger logger = Logger.getLogger("errorLog");
				ConsoleHandler cHandler = new ConsoleHandler();
				logger.addHandler(cHandler);
				//9.画面から操作しエラーが発生した場合に例外処理でログが吐き出される仕様にすること（１箇所で可）
				logger.log(Level.INFO, "例外のスローを捕捉", e);
			}
			user.setName(userRequest.getName());
			user.setFurigana(userRequest.getFurigana());
			user.setMail(userRequest.getMail());
			user.setPassword(userRequest.getPassword());
//			user.setCreate_date(userRequest.getCreate_date());

			userRepository.save(user);
		}

		/*
		 *全件情報検索
		 */
		public List<UserEntity> serchAll(){
			return userRepository.findAll();
		}

		  /**
		   * ユーザー情報 物理削除
		   * @param id ユーザーID
		   */
		  public void delete(Integer id) {
		    UserEntity user = findById(id);
		    userRepository.delete(user);
		  }
}