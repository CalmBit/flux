package com.bluefeather.flux.src.main;
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

import java.util.Random;


import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

import com.bluefeather.flux.src.entities.EntityItemDrop;
import com.bluefeather.flux.src.entities.EntityManager;

import com.bluefeather.flux.src.entities.EntityPlayer;
import com.bluefeather.flux.src.items.ItemGem;

import com.bluefeather.flux.src.particles.ParticleManager;
import com.bluefeather.flux.src.tile.Tile;
import com.bluefeather.flux.src.tile.TileDirt;
import com.bluefeather.flux.src.tile.TileGrass;

import com.bluefeather.flux.src.utils.EnumLightLevels;

public class World {
	
	
	private String name;
	//ugly hacks for tiles
	public Tile[][] tileMap = new Tile[100][100];
	public static boolean[][] collisionMap = new boolean[100][100];
	public static Vector2f[][] posMap = new Vector2f[100][100];
	public EnumLightLevels[][] lightMap = new EnumLightLevels[100][100];
	public EntityManager entityManager = new EntityManager();
	public ParticleManager particleManager = new ParticleManager(1000);
	public Random basRand = new Random();
	
	public World(String worldname)
	{
		this.name = worldname;
		worldInit();
	}
	
	public void worldInit()
	{
		worldGen();
		entityManager.registerEntity(new EntityPlayer(this, 50, 50, "CalmBit", FluxMain.enttex.getTextureID()));
		//entityManager.registerEntity(new EntityMob("Mob",this, 1,1,100,2,FluxMain.enttex2.getTextureID()));
		entityManager.registerEntity(new EntityItemDrop(this,170,170,new ItemGem(Color.red)));
		entityManager.registerEntity(new EntityItemDrop(this,220,220,new ItemGem(Color.red)));
	}
	
	public void worldGen()
	{
		//Begin generation
		for(int i = 0; i < 100;i++)
		{
			for(int j = 0;j < 100;j++)
			{
				/*if(i == 8 && j == 7)
				{
					tileMap[i][j] = new TileGooBlaster(i*50,j*50, this);
					collisionMap[i][j] = true;
					posMap[i][j] = new Vector2f(i*50,j*50);
				}*/
				if(j == 8)
				{
					tileMap[i][j] = new TileGrass(i*50,j*50);
					collisionMap[i][j] = true;
					posMap[i][j] = new Vector2f(i*50,j*50);
				}
				else if(j > 8)
				{
					tileMap[i][j] = new TileDirt(i*50,j*50);
					collisionMap[i][j] = true;
					posMap[i][j] = new Vector2f(i*50,j*50);
				}
				if(tileMap[i][j] != null)
				{
					lightMap[i][j] = tileMap[i][j].light;
				}
			}
			System.out.println(i + " of " + 99);
		}
		System.out.println("World " + name + " generated.");
	}
	
	
	
	
	public void update()
	{
		entityManager.update();
		particleManager.render();
		particleManager.update();
		for(int i = 0; i < 50; i++)
		{
			for(int j = 0; j < 10;j++)
			{
				if(tileMap[i][j] != null && tileMap[i][j].x + 50 > FluxMain.cx && tileMap[i][j].x < FluxMain.cx + 800) {
					tileMap[i][j].render();
					tileMap[i][j].update();
				}
			}
		}
		
		
		
	}

}
