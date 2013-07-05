package com.bluefeather.flux.src.entities.components;

import com.bluefeather.flux.src.entities.components.message.Message;


public abstract class Component {
	
	protected ComponentManager holder;
	public String name;
	
	public Component(ComponentManager holder, String name)
	{
		this.holder = holder;
		this.name = name;
	}
	
	public void update()
	{
		
	}

	public void fireMessage(Message message)
	{
		this.holder.disperseMessage(message);
	}
	
	public abstract void recieveMessage(Message message);
}
