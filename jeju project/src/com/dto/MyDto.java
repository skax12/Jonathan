package com.dto;

import java.util.Date;

public class MyDto {

	private int num;
	private int groupNo;
	private int groupSq;
	private int titleTab;
	private String name;
	private String title;
	private String content;
	private Date date;
	
	
	public MyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MyDto(int num, String name, String title, String content, Date date) {
		super();
		this.num = num;
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	
	public MyDto(int groupNo, int groupSq, int titleTab, String name, String title, String content) {
		super();
		this.groupNo = groupNo;
		this.groupSq = groupSq;
		this.titleTab = titleTab;
		this.name = name;
		this.title = title;
		this.content = content;
	}

	public MyDto(int num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}


	public MyDto(int num, int groupNo, int groupSq, int titleTab, String name, String title, String content,
			Date date) {
		super();
		this.num = num;
		this.groupNo = groupNo;
		this.groupSq = groupSq;
		this.titleTab = titleTab;
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
	}


	public MyDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getGroupNo() {
		return groupNo;
	}


	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}


	public int getGroupSq() {
		return groupSq;
	}


	public void setGroupSq(int groupSq) {
		this.groupSq = groupSq;
	}


	public int getTitleTab() {
		return titleTab;
	}


	public void setTitleTab(int titleTab) {
		this.titleTab = titleTab;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	


	
	
	
	
}
