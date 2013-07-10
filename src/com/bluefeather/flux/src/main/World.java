package com.bluefeather.flux.src.main;
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
import com.bluefeather.flux.src.entities.Entity;
import com.bluefeather.flux.src.entities.EntityManager;
import com.bluefeather.flux.src.entities.EntityMob;
import com.bluefeather.flux.src.entities.EntityPlayer;
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

		entityManager.registerEntity(new EntityPlayer(1, 1, "CalmBit", FluxMain.enttex.getTextureID()));
		entityManager.registerEntity(new EntityMob("Mob", 1,1,100, FluxMain.enttex2.getTextureID()));
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
