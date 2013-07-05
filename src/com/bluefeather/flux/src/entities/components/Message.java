package com.bluefeather.flux.src.entities.components;

public class Message {
	
	public String content;
	public int ID;
	public String originatorName;
	public Message(String content, int ID, String originatorName)
	{
		this.content = content;
		this.ID = ID;
		this.originatorName = originatorName;
	}

}
