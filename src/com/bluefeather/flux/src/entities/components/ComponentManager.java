package com.bluefeather.flux.src.entities.components;

import java.util.ArrayList;
import java.util.List;

import com.bluefeather.flux.src.entities.Entity;
import com.bluefeather.flux.src.entities.components.message.Message;

public class ComponentManager {
	
	protected Entity process;
	public List<Component> components = new ArrayList<Component>();
	private boolean stop;
	
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
		if(!stop) {
		for(Component c : components)
		{
			c.update();
		}
		}
	}
	
	public void disperseMessage(Message message)
	{
		boolean found = false;
		if(message.destinationName == "Manager")
		{
			found = true;
			if(message.name == "Death")
			{
				stop = true;
				System.out.println(process.name + " Died...");
			}
		}
		for(Component c : components)
		{
			if(c.name == message.destinationName)
			{
				found = true;
				c.recieveMessage(message);
			}
		}
		
		if(!found)
		{
			System.out.println(process.name + " doesn't have a component named " + message.destinationName + "!");
		}
	}

}
