package com.aachaerandio.wastedtime.service;

import java.util.Date;

public class TimeBean {
	
	public enum WastedTimeIcon {
		ICON1("R.drawable.red_button"), ICON2("R.drawable.red_button"), ICON3("R.drawable.red_button");
		public String value;
	
		private WastedTimeIcon(String value) {
			this.value = value;
		}
	};
	
	private Long elapsedTime; //millis 
	private WastedTimeIcon icon;
	private String comment; 
	private Date insertDate;
	
	public Long getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public WastedTimeIcon getIcon() {
		return icon;
	}
	public void setIcon(WastedTimeIcon icon) {
		this.icon = icon;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
}