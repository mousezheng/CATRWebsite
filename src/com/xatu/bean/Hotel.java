package com.xatu.bean;

/**
 * �Ƶ����
 * 
 * @author zsl
 *
 */
public class Hotel {

	private int id;
	private String time; // ʱ��
	private String adress; // ��ַ
	private int prices; // �۸�
	private String contactName; // ��ϵ������
	private String contactPhone;// ��ϵ�˵绰
	private String name; // ����

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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
