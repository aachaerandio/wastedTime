package com.aachaerandio.wastedtime.service;

import java.util.Date;

import com.aachaerandio.wastedtime.R;

public class TimeBean {
	
	public enum WastedTimeIcon {
		ICON1(R.drawable.wastedtime_icon_001, R.id.imageButton1), //0
		ICON2(R.drawable.wastedtime_icon_002, R.id.imageButton2), //1
		ICON3(R.drawable.wastedtime_icon_003, R.id.imageButton3), //2
		ICON4(R.drawable.wastedtime_icon_004, R.id.imageButton4),
		ICON5(R.drawable.wastedtime_icon_005, R.id.imageButton5),
		ICON6(R.drawable.wastedtime_icon_006, R.id.imageButton6),
		ICON7(R.drawable.wastedtime_icon_007, R.id.imageButton7),
		ICON8(R.drawable.wastedtime_icon_008, R.id.imageButton8),
		ICON9(R.drawable.wastedtime_icon_009, R.id.imageButton9),
		ICON10(R.drawable.wastedtime_icon_010, R.id.imageButton10),
		ICON11(R.drawable.wastedtime_icon_011, R.id.imageButton11),
		ICON12(R.drawable.wastedtime_icon_012, R.id.imageButton12),
		ICON13(R.drawable.wastedtime_icon_013, R.id.imageButton13),
		ICON14(R.drawable.wastedtime_icon_014, R.id.imageButton14),
		ICON15(R.drawable.wastedtime_icon_015, R.id.imageButton15),
		ICON16(R.drawable.wastedtime_icon_016, R.id.imageButton16);
		
		public int id;
		
		public int associatedBackgroundId;
	
		private WastedTimeIcon(int id, int associatedBackgroundId) {
			this.id = id;
			this.associatedBackgroundId = associatedBackgroundId;
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