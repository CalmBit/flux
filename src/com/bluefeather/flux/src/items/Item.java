package com.bluefeather.flux.src.items;

public abstract class Item {
	
	public String registeredName;
	
	public Item(String name) {
		this.registeredName = name;
	}
	
	public abstract Item getInstance();
	

}
