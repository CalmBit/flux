package com.bluefeather.flux.src.main;

import com.bluefeather.flux.src.tile.Tile;
import com.bluefeather.flux.src.tile.TileDirt;
import com.bluefeather.flux.src.tile.TileGrass;

public class World {
	
	
	public Tile[][] tileMap = new Tile[100][100];
	public World(String worldname)
	{
		
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
		}
	}
	
	public void render()
	{
		
	}
	
	
	
	public void update()
	{
		
	}

}
