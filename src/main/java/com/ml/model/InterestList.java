package com.ml.model;

public class InterestList {
	
	private String topic;
	private String imageurl;
	public String getTopic() {
		return topic;
	}
	public InterestList(String topic, String imageurl) {
		super();
		this.topic = topic;
		this.imageurl = imageurl;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	

}
