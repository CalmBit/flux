package com.bluefeather.flux.src.main;

import com.bluefeather.flux.src.entities.Entity;
import com.bluefeather.flux.src.entities.EntityManager;
import com.bluefeather.flux.src.tile.Tile;
import com.bluefeather.flux.src.tile.TileDirt;
import com.bluefeather.flux.src.tile.TileGrass;

public class World {
	
	
	private String name;
	public Tile[][] tileMap = new Tile[100][100];
	public EntityManager entityManager = new EntityManager();
	public World(String worldname)
	{
		this.name = worldname;
		worldInit();
	}
	
	public void worldInit()
	{
		//Begin generation
		for(int i = 0; i < 100;i++)
		{
			for(int j = 0;j < 100;j++)
			{
				if(i == 50)
				{
					tileMap[i][j] = new TileGrass(i*50,j*50);
				}
				else if(i > 50)
				{
					tileMap[i][j] = new TileDirt(i*50,j*50);
				}
				
			}
			System.out.println(i + " of 100");
		}
		System.out.println("World " + name + " generated.");
		entityManager.registerEntity(new Entity("Entity", 1, 1));
	}
	
	public void render()
	{
		
	}
	
	
	
	public void update()
	{
		entityManager.update();
	}

}
