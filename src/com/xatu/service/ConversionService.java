package com.xatu.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.xatu.bean.Activity;
import com.xatu.bean.Attraction;
import com.xatu.bean.Car;
import com.xatu.bean.Hotel;
import com.xatu.bean.Message;
import com.xatu.bean.User;

/**
 * 负责完成转换任务
 * 
 * @author zsl
 *
 */
public class ConversionService {

	public static List<Attraction> object2Attraction(List<String[]> objectsList, ServletContext sc) {
		List<Attraction> attractionList = new ArrayList<>();
		int n = objectsList.size();
		for (int i = 0; i < n; i++) {
			Attraction tempAttraction = new Attraction();
			String[] temp = objectsList.get(i);
			// 赋值
			tempAttraction.setId(Integer.parseInt(temp[0]));
			tempAttraction.setName(temp[1]);
			tempAttraction.setDescribe(FileService.fileToString(temp[2], sc));
			tempAttraction.setSeeNum(Integer.parseInt(temp[3]));
			tempAttraction.setQueryNum(Integer.parseInt(temp[4]));
			tempAttraction.setImgFile(FileService.getImageFile(temp[5], sc));
			tempAttraction.setTicketPrices(Integer.parseInt(temp[6]));
			tempAttraction.setAddress(temp[7]);
			attractionList.add(tempAttraction);
		}
		return attractionList;
	}

	public static List<Car> object2Car(List<String[]> objectsList, ServletContext sc) {
		List<Car> cars = new ArrayList<>();
		int n = objectsList.size();
		for (int i = 0; i < n; i++) {
			Car tempCar = new Car();
			String[] temp = objectsList.get(i);
			tempCar.setId(Integer.parseInt(temp[0]));
			tempCar.setTime(temp[1]);
			tempCar.setContactName(temp[2]);
			tempCar.setName(temp[3]);
			tempCar.setContactPhone(temp[4]);
			tempCar.setPrices(Integer.parseInt(temp[5]));
			tempCar.setAddress(temp[6]);
			cars.add(tempCar);
		}
		return cars;
	}

	public static List<Hotel> object2Hotel(List<String[]> objectsList, ServletContext sc) {
		List<Hotel> hotels = new ArrayList<>();
		int n = objectsList.size();
		for (int i = 0; i < n; i++) {
			Hotel tempHotel = new Hotel();
			String[] temp = objectsList.get(i);
			tempHotel.setId(Integer.parseInt(temp[0]));
			tempHotel.setTime(temp[1]);
			tempHotel.setContactName(temp[2]);
			tempHotel.setName(temp[3]);
			tempHotel.setContactPhone(temp[4]);
			tempHotel.setPrices(Integer.parseInt(temp[5]));
			tempHotel.setAddress(temp[6]);
			hotels.add(tempHotel);
		}
		return hotels;
	}

	public static List<Activity> object2Activity(List<String[]> objectsList, ServletContext sc) {
		List<Activity> activitys = new ArrayList<>();
		int n = objectsList.size();
		for (int i = 0; i < n; i++) {
			Activity tempActivity = new Activity();
			String[] temp = objectsList.get(i);
			tempActivity.setId(Integer.parseInt(temp[0]));
			tempActivity.setName(temp[1]);
			int num = Integer.parseInt(temp[2]);
			tempActivity.setNumber(num);
			String[] tempStr = new String[num];
			for (int j = 0; j < num; j++) {
				tempStr[j] = temp[6 + j];
			}
			tempActivity.setPlaces(tempStr);
			tempActivity.setPrices(Integer.parseInt(temp[3]));
			tempActivity.setImageFile(temp[5]);
			tempActivity.setInfo(temp[4]);
			activitys.add(tempActivity);
		}
		return activitys;
	}

	public static List<Message> object2Message(List<String[]> objectsList, ServletContext sc) {
		List<Message> messages = new ArrayList<>();
		int n = objectsList.size();
		for (int i = 0; i < n; i++) {
			// message
			Message tempHotel = new Message();
			String[] temp = objectsList.get(i);
			tempHotel.setId(Integer.parseInt(temp[0]));
			tempHotel.setUserName(temp[1]);
			// System.out.println(temp[1]);
			tempHotel.setContent(temp[2]);
			tempHotel.setAgreeNum(Integer.parseInt(temp[3]));
			tempHotel.setDisagreeNum(Integer.parseInt(temp[4]));
			tempHotel.setTime(temp[5]);
			// tempHotel.setNum(Integer.parseInt(temp[6]));
			tempHotel.setAddress(temp[6]);
			tempHotel.setUserId(temp[7]);
			messages.add(tempHotel);
		}
		return messages;
	}

	public static User object2User(String[] objectsList, ServletContext sc) {
		User tempUser = new User();
		String[] temp = objectsList;
		tempUser.setId(Integer.parseInt(temp[0]));
		tempUser.setUserName(temp[1]);
		tempUser.setPassword(temp[2]);
		tempUser.setPhone(temp[3]);
		tempUser.setName(temp[4]);
		tempUser.setSex(temp[5]);
		tempUser.setEmail(temp[6]);
		tempUser.setAddress(temp[7]);
		tempUser.setQqNum(temp[8]);
		tempUser.setPhoto(temp[9]);
		tempUser.setDescribe(temp[10]);
		if (temp[11] == null) {
			tempUser.setAge(null);
		} else {
			tempUser.setAge(Integer.parseInt(temp[11]));
		}
		tempUser.setBirthday(temp[12]);
		System.out.println(tempUser.getId());
		return tempUser;
	}

	public static Attraction object2Attraction1(String[] objectsList, ServletContext sc) {
		Attraction tempAttraction = new Attraction();
		String[] temp = objectsList;
		// 赋值
		tempAttraction.setId(Integer.parseInt(temp[0]));
		tempAttraction.setName(temp[1]);
		tempAttraction.setDescribe(FileService.fileToString(temp[2], sc));
		tempAttraction.setSeeNum(Integer.parseInt(temp[3]));
		tempAttraction.setQueryNum(Integer.parseInt(temp[4]));
		tempAttraction.setImgFile(FileService.getImageFile(temp[5], sc));
		tempAttraction.setTicketPrices(Integer.parseInt(temp[6]));
		tempAttraction.setAddress(temp[7]);
		return tempAttraction;
	}
}
