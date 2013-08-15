package com.bluefeather.flux.src.tile;
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
import org.lwjgl.opengl.GL11;

import com.bluefeather.flux.src.main.FluxMain;

public abstract class Tile {
	
	public float x,y;
	public float r,g,b;
	public String name;
	
	public Tile(float x, float y, float r, float g, float b, String name)
	{
		this.x = x;
		this.y = y;
		this.name = name;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void render()
	{
		//GL11.glColor3f(r, g, b);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0f, 0f);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1f, 0f);
		GL11.glVertex2f(x + 50, y);
		GL11.glTexCoord2f(1f, 1f);
		GL11.glVertex2f(x + 50, y + 50);
		GL11.glTexCoord2f(0f, 1f);
		GL11.glVertex2f(x, y + 50);
		GL11.glEnd();
		

	}
	
	public abstract void update();
	
	public void save()
	{
		//TBA (simple json?)
	}

}
