package com.bluefeather.flux.src.main;

import com.bluefeather.flux.src.entities.Entity;
import com.bluefeather.flux.src.entities.EntityManager;
import com.bluefeather.flux.src.tile.Tile;
import com.bluefeather.flux.src.tile.TileDirt;
import com.bluefeather.flux.src.tile.TileGrass;

public class World {
	
	
	private String name;
	public Tile[][] tileMap = new Tile[100][100];
	public static boolean[][] collisionMap = new boolean[100][100];
	public EntityManager entityManager = new EntityManager();
	public World(String worldname)
	{
		this.name = worldname;
		worldInit();
	}
	
	public void worldInit()
	{
		//Begin generation
		for(int i = 0; i < FluxMain.width/50;i++)
		{
			for(int j = 0;j < FluxMain.height/50;j++)
			{
				if(j == 8)
				{
					tileMap[i][j] = new TileGrass(i*50,j*50);
					collisionMap[i][j] = true;
				}
				else if(j > 8)
				{
					tileMap[i][j] = new TileDirt(i*50,j*50);
					collisionMap[i][j] = true;
				}
				
			}
			System.out.println(i + " of " + FluxMain.width/50);
		}
		System.out.println("World " + name + " generated.");
		entityManager.registerEntity(new Entity("Entity", 1, 1));
	}
	
	
	
	
	public void update()
	{
		entityManager.update();
		for(int i = 0; i < FluxMain.width/50; i++)
		{
			for(int j = 0; j < FluxMain.height/50;j++)
			{
				if(tileMap[i][j] != null) {
					tileMap[i][j].render();
				}
			}
		}
	}

}
