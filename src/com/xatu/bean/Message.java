package com.xatu.bean;

/**
 * ����
 * 
 * @author zsl
 *
 */
public class Message {

	private int id;
	private String userId; // �û�id
	private String content; // ����
	private int agreeNum; // ��ͬ����
	private int disagreeNum; // ����ͬ����
	private String time; // ʱ��
	private String adress; // ��ַ
	private int num; // ¥��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getAgreeNum() {
		return agreeNum;
	}

	public void setAgreeNum(int agreeNum) {
		this.agreeNum = agreeNum;
	}

	public int getDisagreeNum() {
		return disagreeNum;
	}

	public void setDisagreeNum(int disagreeNum) {
		this.disagreeNum = disagreeNum;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
