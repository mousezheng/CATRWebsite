package com.xatu.bean;

/**
 * 租车服务
 * 
 * @author zsl
 *
 */
public class Car {
 
	private int id;
	private String time; // 时间
	private String address; // 地址
	private int prices; // 价格
	private String contactName; // 联系人姓名
	private String contactPhone;// 联系人电话
	private String name; // 姓名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public int getPrices() {
		return prices;
	}

	public void setPrices(int prices) {
		this.prices = prices;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
