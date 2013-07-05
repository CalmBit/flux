package com.bluefeather.flux.src.entities.components;

import java.util.ArrayList;
import java.util.List;

import com.bluefeather.flux.src.entities.Entity;

public class ComponentManager {
	
	protected Entity process;
	public List<Component> components = new ArrayList<Component>();
	
	public ComponentManager(Entity process)
	{
		this.process = process;
	}
	
	public void addComponent(Component component)
	{
		boolean can = true;
		for (Component c : components)
		{
			if(c.name == component.name) can = false;
		}
		if(can)
		{
			components.add(component);
		}
	}
	
	public void update()
	{
		for(Component c : components)
		{
			c.update();
		}
	}
	
	public void disperseMessage(Message message)
	{
		for(Component c : components)
		{
			if(c.name != message.originatorName)
			{
			c.recieveMessage(message);
			}
		}
	}

}
