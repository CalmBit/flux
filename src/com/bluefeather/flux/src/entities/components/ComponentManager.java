package com.bluefeather.flux.src.entities.components;
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
import java.util.ArrayList;
import java.util.List;

import com.bluefeather.flux.src.entities.Entity;
import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessageDeath;
import com.bluefeather.flux.src.particles.Particle;

public class ComponentManager {
	
	public Entity process;
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
				disperseMessage(new MessageDeath("Manager", "Render"));
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
