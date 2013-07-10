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
import java.util.ArrayList;

public class EntityManager {
	
	private static int uID = 1;
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public EntityManager()
	{
		
	}
	
	public void registerEntity(Entity ent)
	{
		if(ent != null) {
			ent.uID = uID;
			uID++;
			entities.add(ent);
		}
		System.out.println(ent.name + " was registered under ID" + ent.uID);
	}
	
	public void deregisterEntity(int uID)
	{
		for(Entity ent : entities)
		{
			if(ent.uID == uID)
			{
				entities.remove(ent);
			}
		}
	}
	
	public void update()
	{
		for(Entity en : entities)
		{
			en.update();
		}
	}
	
	
	

}
