package com.bluefeather.flux.src.entities;

import com.bluefeather.flux.src.entities.components.Component;
import com.bluefeather.flux.src.entities.components.ComponentInput;
import com.bluefeather.flux.src.entities.components.ComponentManager;
import com.bluefeather.flux.src.entities.components.ComponentPosition;

public class Entity {
	
	public String name;
	protected int uID;
	public ComponentManager componentManager = new ComponentManager(this);

	public Entity(String name, float x, float y)
	{
		this.name = name;
		componentManager.addComponent(new ComponentPosition(componentManager, x, y));
		componentManager.addComponent(new ComponentInput(componentManager));
	}
	
	public void update()
	{
		componentManager.update();
	}
	
	public void registerComponent(Component component)
	{
		
	}
}
