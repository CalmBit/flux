package com.bluefeather.flux.src.entities;

import org.newdawn.slick.opengl.Texture;

import com.bluefeather.flux.src.entities.components.Component;
import com.bluefeather.flux.src.entities.components.ComponentHealth;
import com.bluefeather.flux.src.entities.components.ComponentInput;
import com.bluefeather.flux.src.entities.components.ComponentManager;
import com.bluefeather.flux.src.entities.components.ComponentPosition;
import com.bluefeather.flux.src.entities.components.ComponentRender;
import com.bluefeather.flux.src.main.FluxMain;

public class Entity {
	/*
	 * Copyright © 2013 BlueFeather Solutions LLC
	 * All Rights Reserved.
	 * 
	 *  This file is part of The Flüx Engine.
	 *
	 *  The Flüx Engine is free software: you can redistribute it and/or modify
	 *  it under the terms of the GNU General Public License as published by
	 *  the Free Software Foundation, either version 3 of the License, or
	 *  (at your option) any later version.
	 *  
	 *  The Flüx Engine is distributed in the hope that it will be useful,
	 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
	 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	 *  GNU General Public License for more details.
	 *
	 *  You should have received a copy of the GNU General Public License
	 *  along with The Flüx Engine.  If not, see <http://www.gnu.org/licenses/>.
	 */
	public String name;
	protected int uID;
	public ComponentManager componentManager = new ComponentManager(this);
	public int texID;
	public Entity(String name, float x, float y, int i_health, int texID)
	{
		boolean hI = false;
		this.texID = texID;
		this.name = name;
		if(name == "Player") hI = true;
		componentManager.addComponent(new ComponentPosition(componentManager, x, y,true, hI));
		componentManager.addComponent(new ComponentRender(componentManager, x, y, 50, 50, 1, 1, 1, this.texID));
		componentManager.addComponent(new ComponentHealth(componentManager, i_health));
	}
	
	public void update()
	{
		componentManager.update();
	}
	
	
	public void registerComponent(Component component)
	{
		
	}
}
