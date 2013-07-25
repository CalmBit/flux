package com.bluefeather.flux.src.entities.components;
import java.util.Random;

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
import com.bluefeather.flux.src.entities.components.message.Message;


public abstract class Component {
	
	protected ComponentManager holder;
	public String name;
	
	public Random rand = new Random();
	
	public Component(ComponentManager holder, String name)
	{
		this.holder = holder;
		this.name = name;
	}
	
	public void update()
	{
		
	}

	public void fireMessage(Message message)
	{
		this.holder.disperseMessage(message);
	}
	
	public abstract void recieveMessage(Message message);
}
