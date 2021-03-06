package com.bluefeather.flux.src.entities;
/*
 * Copyright � 2013 BlueFeather Solutions LLC
 * All Rights Reserved.
 * 
 *  This file is part of The Fl�x Engine.
 *
 *  The Fl�x Engine is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Fl�x Engine is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with The Fl�x Engine.  If not, see <http://www.gnu.org/licenses/>.
 */
import com.bluefeather.flux.src.entities.components.ComponentGUI;
import com.bluefeather.flux.src.entities.components.ComponentInput;
import com.bluefeather.flux.src.entities.components.ComponentInventory;
import com.bluefeather.flux.src.main.World;


public class EntityPlayer extends EntityLiving {
	
	private String networkedName;
	
	public EntityPlayer(World world, float x, float y, String networkedName, int TexID) {
		super("Player", world, x, y, 100, 5, TexID);
		this.networkedName = networkedName;
		componentManager.addComponent(new ComponentInput(componentManager));
		componentManager.addComponent(new ComponentInventory(componentManager,9));
		componentManager.addComponent(new ComponentGUI(componentManager,TexID));
		System.out.println(this.networkedName + " logged in.");
		weight = 5;
	}

}
