package com.bluefeather.flux.src.entities.components.message;

public abstract class Message {
	
	public String name;
	public int ID;
	public String originatorName;
	public String destinationName;
	
	public Message(String name, int ID, String originatorName, String destinationName)
	{
		this.name = name;
		this.ID = ID;
		this.originatorName = originatorName;
		this.destinationName = destinationName;
	}
	
	
	

}
