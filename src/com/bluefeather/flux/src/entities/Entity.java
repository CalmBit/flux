package com.bluefeather.flux.src.entities;

import java.util.ArrayList;
import java.util.List;

import com.bluefeather.flux.src.entities.components.Component;

public abstract class Entity {
	
	public String name;
	protected int uID;
	
	public List<Component> components = new ArrayList<Component>();

	public Entity(String name)
	{
		this.name = name;
	}
	
	public void registerComponent(Component component)
	{
		if(!components.contains(component))
		{
			components.add(component);
		}
	}
}
