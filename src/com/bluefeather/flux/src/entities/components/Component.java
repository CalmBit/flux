package com.bluefeather.flux.src.entities.components;


public abstract class Component {
	
	private ComponentManager holder;
	public String name;
	
	public Component(ComponentManager holder, String name)
	{
		this.holder = holder;
		this.name = name;
	}
	
	public abstract void update();

	public abstract void fireMessage();
	
	public abstract void recieveMessage(Message message);
}
