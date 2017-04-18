package com.xatu.service;

import java.util.ArrayList;
import java.util.List;

import com.xatu.bean.User;

/**
 * 处理管理员数据库操作中的对象映射转换等操作
 * 
 * @author zsl
 *
 */
public class ManagerService {

	/**
	 * 
	 * @param tempStrs
	 * @return
	 */
	public static List<User> StringToUser(List<String[]> tempStrs) {
		List<User> users = new ArrayList<User>();
		for (String[] strs : tempStrs) {
			User user = new User();
			users.add(user);
			if (strs[0] != null && !strs[0].equals("")) {
				user.setId(Integer.parseInt(strs[0]));
			}
			user.setUserName(strs[1]);
			user.setPassword(strs[2]);
			user.setPhone(strs[3]);
		}
		return users;
	}

}
