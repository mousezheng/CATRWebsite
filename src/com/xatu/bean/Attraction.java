package com.xatu.bean;

/**
 * 风景
 * 
 * @author zsl
 *
 */
public class Attraction {

	private int id;			
	private String name;		//名称
	private String describe;	//描述
	private int seeNum;			//查看次数
	private int queryNum;		//浏览次数
	private String[] imgFile;	//图片文件路径
	private String address;		//地址
	private int ticketPrices;	//票价

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
