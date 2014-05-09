package com.aachaerandio.wastedtime.service;

import java.util.Date;

import com.aachaerandio.wastedtime.R;

public class TimeBean {
	
	public enum WastedTimeIcon {
		ICON1(R.drawable.wastedtime_icon_001), //0
		ICON2(R.drawable.wastedtime_icon_002), //1
		ICON3(R.drawable.wastedtime_icon_003), //2
		ICON4(R.drawable.wastedtime_icon_004),
		ICON5(R.drawable.wastedtime_icon_005),
		ICON6(R.drawable.wastedtime_icon_006),
		ICON7(R.drawable.wastedtime_icon_007),
		ICON8(R.drawable.wastedtime_icon_008),
		ICON9(R.drawable.wastedtime_icon_009),
		ICON10(R.drawable.wastedtime_icon_010),
		ICON11(R.drawable.wastedtime_icon_011),
		ICON12(R.drawable.wastedtime_icon_012),
		ICON13(R.drawable.wastedtime_icon_013),
		ICON14(R.drawable.wastedtime_icon_014),
		ICON15(R.drawable.wastedtime_icon_015),
		ICON16(R.drawable.wastedtime_icon_016);
		
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