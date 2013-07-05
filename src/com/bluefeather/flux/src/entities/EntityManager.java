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
