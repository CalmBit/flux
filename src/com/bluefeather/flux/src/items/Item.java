package com.bluefeather.flux.src.items;

import org.newdawn.slick.Color;

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
public abstract class Item {
	
	public String registeredName;
	public int texId;
	public int maxStackSize;
	public Color color;
	public Item(String name, int maxStackSize, Color color) {
		this.registeredName = name;
		this.maxStackSize = maxStackSize;
	}
	public Item(String name, Color color)
	{
		this(name,64, color);
	}
	public Item(String name)
	{
		this(name,64, Color.white);
	}
	
	public abstract Item getInstance();
	

}
