package com.xatu.bean;

/**
 * 公告类
 * 
 * @author zsl
 *
 */
public class Announce {
	private int id;
	private String title; // 题目
	private String content; // 内容
	private String time; // 时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
