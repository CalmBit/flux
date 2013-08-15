package com.bluefeather.flux.src.entities;
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


import com.bluefeather.flux.src.entities.components.Component;
import com.bluefeather.flux.src.entities.components.ComponentEntValues;


import com.bluefeather.flux.src.entities.components.ComponentManager;
import com.bluefeather.flux.src.entities.components.ComponentPosition;
import com.bluefeather.flux.src.entities.components.ComponentRender;
import com.bluefeather.flux.src.main.World;
import com.bluefeather.flux.src.particles.Particle;


public class Entity {
	public String name;
	protected int uID;
	public World world;
	public ComponentManager componentManager = new ComponentManager(this);
	public int texID;
	public Entity(String name, World world, float x, float y, int texID)
	{
		boolean hI = false;
		this.texID = texID;
		this.name = name;
		this.world = world;
		if(name == "Player") hI = true;
		componentManager.addComponent(new ComponentPosition(componentManager, x, y,true, hI));
		componentManager.addComponent(new ComponentRender(componentManager, x, y, 50, 50, 1, 1, 1, this.texID));
		
		
	}
	
	public void update()
	{
		componentManager.update();
	}
	
	
	public void registerComponent(Component component)
	{
		
	}

	public void died() {
		
		
	}
}
