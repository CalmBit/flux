package com.bluefeather.flux.src.entities;

import java.util.ArrayList;
import java.util.List;

import com.bluefeather.flux.src.entities.components.Component;
import com.bluefeather.flux.src.entities.components.ComponentManager;

public class Entity {
	
	public String name;
	protected int uID;
	public ComponentManager componentManager = new ComponentManager(this);

	public Entity(String name)
	{
		this.name = name;
	}
	
	public void update()
	{
		
	}
	
	public void registerComponent(Component component)
	{
		
	}
}
