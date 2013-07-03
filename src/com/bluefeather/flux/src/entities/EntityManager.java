package com.bluefeather.flux.src.entities;

import java.util.HashMap;
import java.util.Map;

public class EntityManager {
	
	private static int uID = 1;
	
	public Map<Integer,Entity> entities = new HashMap<Integer,Entity>();
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
	
	

}
