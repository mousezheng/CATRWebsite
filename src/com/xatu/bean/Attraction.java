package com.xatu.bean;

/**
 * �羰
 * 
 * @author zsl
 *
 */
public class Attraction {

	private int id;			
	private String name;		//����
	private String describe;	//����
	private int seeNum;			//�鿴����
	private int queryNum;		//�������
	private String[] imgFile;	//ͼƬ�ļ�·��
	private String address;		//��ַ
	private int ticketPrices;	//Ʊ��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getSeeNum() {
		return seeNum;
	}

	public void setSeeNum(int seeNum) {
		this.seeNum = seeNum;
	}

	public int getQueryNum() {
		return queryNum;
	}

	public void setQueryNum(int queryNum) {
		this.queryNum = queryNum;
	}

	public String[] getImgFile() {
		return imgFile;
	}

	public void setImgFile(String[] imgFile) {
		this.imgFile = imgFile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTicketPrices() {
		return ticketPrices;
	}

	public void setTicketPrices(int ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

}
