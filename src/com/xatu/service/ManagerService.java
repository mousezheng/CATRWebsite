package com.xatu.service;

import java.util.ArrayList;
import java.util.List;

import com.xatu.bean.Activity;
import com.xatu.bean.Announce;
import com.xatu.bean.Attraction;
import com.xatu.bean.Car;
import com.xatu.bean.Manage;
import com.xatu.bean.Message;
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

	public static List<Manage> StringToManage(List<String[]> tempStrs) {
		List<Manage> manages = new ArrayList<Manage>();
		for (String[] strs : tempStrs) {
			Manage manage = new Manage();
			manages.add(manage);
			if (strs[0] != null && !strs[0].equals("")) {
				manage.setId(Integer.parseInt(strs[0]));
			}
			manage.setName(strs[1]);
			manage.setPassword(strs[2]);
		}
		return manages;
	}

	public static List<Announce> StringToAnnounce(List<String[]> tempStrs) {
		List<Announce> announces = new ArrayList<>();
		for (String[] strs : tempStrs) {
			Announce announce = new Announce();
			announces.add(announce);
			announce.setId(1); // 公告只有一个，所以直接给1
			announce.setTitle(strs[1]);
			announce.setTime(strs[3]);
			announce.setContent(strs[2]);
		}
		return announces;
	}

	public static List<Car> StringToCar(List<String[]> tempStrs) {
		List<Car> cars = new ArrayList<>();
		for (String[] str : tempStrs) {
			Car car = new Car();
			cars.add(car);
			car.setId(Integer.parseInt(str[0]));
			car.setTime(str[1]);
			car.setContactPhone(str[2]);
			car.setName(str[3]);
			car.setContactName(str[4]);
			car.setPrices(Integer.parseInt(str[5]));
			car.setAddress(str[6]);
		}
		return cars;
	}

	public static List<Message> StringToMessage(List<String[]> tempStrs) {
		List<Message> messages = new ArrayList<>();
		for (String[] strings : tempStrs) {
			Message message = new Message();
			messages.add(message);
			message.setId(Integer.parseInt(strings[0]));
			message.setUserId(strings[1]);
			message.setContent(strings[2]);
			message.setAgreeNum(Integer.parseInt(strings[3]));
			message.setDisagreeNum(Integer.parseInt(strings[4]));
			message.setTime(strings[5]);
			message.setAddress(strings[6]);
			// message.setNum(num);//不要这个了，，没卵用
		}
		return messages;
	}

	public static List<Activity> StringToActivity(List<String[]> tempStrs) {
		List<Activity> activitys = new ArrayList<>();
		for (String[] strings : tempStrs) {
			Activity activity = new Activity();
			activity.setId(Integer.parseInt(strings[0]));
			activity.setName(strings[1]);
			int num = Integer.parseInt(strings[2]);
			activity.setNumber(num);
			String[] tempStr = new String[7];
			for (int j = 0; j < 7; j++) {
				if (j < num) {
					tempStr[j] = strings[5 + j];
				} else {
					tempStr[j] = "";
				}

			}
			activity.setOne(strings[5]);
			activity.setTwo(strings[6]);
			activity.setThree(strings[7]);
			activity.setFour(strings[8]);
			activity.setFive(strings[9]);
			activity.setSix(strings[10]);
			activity.setSeven(strings[11]);
			activity.setPlaces(tempStr);
			activity.setPrices(Integer.parseInt(strings[3]));
			activity.setImageFile(strings[5]);
			activity.setInfo(strings[4]);
			activitys.add(activity);
		}
		return activitys;
	}

}
