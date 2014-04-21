package com.aachaerandio.wastedtime.service;

import java.util.Date;

public class TimeBean {
	public enum WastedTimeIcon {ICON1, ICON2, ICON3};
	
	public Long elapsedTime; //millis 
	public WastedTimeIcon icon;
	public String comment; 
	public Date insertDate;
}