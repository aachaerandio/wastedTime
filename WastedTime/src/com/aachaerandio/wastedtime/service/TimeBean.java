package com.aachaerandio.wastedtime.service;

import java.util.Date;

import com.aachaerandio.wastedtime.R;

public class TimeBean {
	
	public enum WastedTimeIcon {
		ICON1(R.drawable.red_button), //0
		ICON2(R.drawable.red_button), //1
		ICON3(R.drawable.red_button); //2
		
		public int id;
	
		private WastedTimeIcon(int id) {
			this.id = id;
		}
	};
	
	private Long id;
	private Long elapsedTime; //millis 
	private WastedTimeIcon icon;
	private String comment; 
	private Date created;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}