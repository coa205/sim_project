package com.dgit.domain;

import java.util.Date;

public class SimProject {
	private int number;
	private String name;
	private String content;
	private Date start_date;
	private Date end_date;
	private String resultStartDate;
	private String resultEndDate;
	private String state;
	
	public SimProject() {}
	
	public SimProject(int number, String name, String content, String resultStartDate, String resultEndDate,
			String state) {
		this.number = number;
		this.name = name;
		this.content = content;
		this.resultStartDate = resultStartDate;
		this.resultEndDate = resultEndDate;
		this.state = state;
	}

	public SimProject(int number, String name, String content, Date start_date, Date end_date, String state) {
		this.number = number;
		this.name = name;
		this.content = content;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
	}

	public SimProject(String name, String content, Date start_date, Date end_date, String state) {
		this.name = name;
		this.content = content;
		this.start_date = start_date;
		this.end_date = end_date;
		this.state = state;
	}

	public String getResultStartDate() {
		return resultStartDate;
	}

	public void setResultStartDate(String resultStartDate) {
		this.resultStartDate = resultStartDate;
	}

	public String getResultEndDate() {
		return resultEndDate;
	}

	public void setResultEndDate(String resultEndDate) {
		this.resultEndDate = resultEndDate;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return String.format(
				"SimProject [number=%s, name=%s, content=%s, start_date=%s, end_date=%s, resultStartDate=%s, resultEndDate=%s, state=%s]",
				number, name, content, start_date, end_date, resultStartDate, resultEndDate, state);
	}
	
}
