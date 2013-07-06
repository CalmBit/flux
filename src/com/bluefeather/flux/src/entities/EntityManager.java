package com.bluefeather.flux.src.entities;

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
		System.out.println(ent.name + " was registered!");
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
