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

import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

import com.bluefeather.flux.src.entities.EntityManager;
import com.bluefeather.flux.src.entities.EntityMob;
import com.bluefeather.flux.src.entities.EntityPlayer;
import com.bluefeather.flux.src.particles.Particle;
import com.bluefeather.flux.src.particles.ParticleManager;
import com.bluefeather.flux.src.tile.Tile;
import com.bluefeather.flux.src.tile.TileDirt;
import com.bluefeather.flux.src.tile.TileGooBlaster;
import com.bluefeather.flux.src.tile.TileGrass;

public class World {
	
	
	private String name;
	public Tile[][] tileMap = new Tile[100][100];
	public static boolean[][] collisionMap = new boolean[100][100];
	public static Vector2f[][] posMap = new Vector2f[100][100];
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
		entityManager.registerEntity(new EntityMob("Mob",this, 1,1,100,2,FluxMain.enttex2.getTextureID()));
		for(int i = 0;i < 101; i++) {
		particleManager.addParticle(new Particle(basRand.nextInt(100), basRand.nextInt(100),1000,5, false));
		}
	}
	
	public void worldGen()
	{
		//Begin generation
		for(int i = 0; i < 100;i++)
		{
			for(int j = 0;j < 100;j++)
			{
				if(i == 8 && j == 7)
				{
					tileMap[i][j] = new TileGooBlaster(i*50,j*50, this);
					collisionMap[i][j] = true;
					posMap[i][j] = new Vector2f(i*50,j*50);
				}
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
				
			}
			System.out.println(i + " of " + FluxMain.width/50);
		}
		System.out.println("World " + name + " generated.");
	}
	
	
	
	
	public void update()
	{
		/*GL11.glBindTexture(GL11.GL_TEXTURE_2D, FluxMain.sky.getTextureID());
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0, 0);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(FluxMain.width, 0);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(FluxMain.width, FluxMain.height);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0, FluxMain.height);
		GL11.glEnd();*/
		
		entityManager.update();
		particleManager.render();
		particleManager.update();
		for(int i = 0; i < 50; i++)
		{
			for(int j = 0; j < 10;j++)
			{
				if(tileMap[i][j] != null) {
					tileMap[i][j].render();
					tileMap[i][j].update();
				}
			}
		}
		
		
		
	}

}
