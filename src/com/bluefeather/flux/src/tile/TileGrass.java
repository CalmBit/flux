package com.bluefeather.flux.src.tile;

import org.lwjgl.opengl.GL11;

import com.bluefeather.flux.src.main.FluxMain;

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
public class TileGrass extends Tile {

	public TileGrass(float x, float y) {
		super(x, y,0,1,0, "Grass");
		
	}

	
	public void update() {
		

	}
	
	public void render()
	{
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, FluxMain.grasstex.getTextureID());
		super.render();
	}

}
