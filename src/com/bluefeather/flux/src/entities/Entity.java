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


import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.Color;

import com.bluefeather.flux.src.entities.components.Component;


import com.bluefeather.flux.src.entities.components.ComponentManager;
import com.bluefeather.flux.src.entities.components.ComponentPosition;
import com.bluefeather.flux.src.entities.components.ComponentRender;
import com.bluefeather.flux.src.main.World;


public class Entity {
	public String name;
	protected int uID;
	public World world;
	public ComponentManager componentManager = new ComponentManager(this);
	public int texID;
	//Copy of the position to be accessible by components and other things.
	public float x,y;
	public int weight;
	public Color color;
	public Entity(String name, World world, float x, float y, int texID, Color color)
	{
		boolean hI = false;
		this.texID = texID;
		this.name = name;
		this.world = world;
		this.color = color;
		if(name == "Player") hI = true;
		componentManager.addComponent(new ComponentPosition(componentManager, x, y,true, hI));
		componentManager.addComponent(new ComponentRender(componentManager, x, y, 50, 50, new Vector3f(x,y,1), this.texID));
		this.x = x;
		this.y = y;
		
		
	}
	
	public void update()
	{
		componentManager.update();
	}
	
	public int getID() {
		return uID;
	}
	
	public void registerComponent(Component component)
	{
		
	}

	public void died() {
		
		
	}
}
