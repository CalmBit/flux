package com.bluefeather.flux.src.entities;

import com.bluefeather.flux.src.entities.components.Component;
import com.bluefeather.flux.src.entities.components.ComponentHealth;
import com.bluefeather.flux.src.entities.components.ComponentInput;
import com.bluefeather.flux.src.entities.components.ComponentManager;
import com.bluefeather.flux.src.entities.components.ComponentPosition;
import com.bluefeather.flux.src.entities.components.ComponentRender;
import com.bluefeather.flux.src.main.FluxMain;

public class Entity {
	
	public String name;
	protected int uID;
	public ComponentManager componentManager = new ComponentManager(this);

	public Entity(String name, float x, float y)
	{
		this.name = name;
		componentManager.addComponent(new ComponentPosition(componentManager, x, y,true));
		componentManager.addComponent(new ComponentInput(componentManager));
		componentManager.addComponent(new ComponentRender(componentManager, x, y, 50, 50, 1, 1, 1, FluxMain.enttex));
		componentManager.addComponent(new ComponentHealth(componentManager, 100));
	}
	
	public void update()
	{
		componentManager.update();
	}
	
	
	public void registerComponent(Component component)
	{
		
	}
}
