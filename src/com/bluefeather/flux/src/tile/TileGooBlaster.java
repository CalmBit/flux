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
import org.newdawn.slick.Color;

import com.bluefeather.flux.src.main.FluxMain;
import com.bluefeather.flux.src.main.World;
import com.bluefeather.flux.src.particles.Particle;
import com.bluefeather.flux.src.particles.ParticleEmitter;
import com.bluefeather.flux.src.utils.EnumLightLevels;

public class TileGooBlaster extends Tile {

	World world;
	protected ParticleEmitter emitter;
	public TileGooBlaster(float x, float y, World world) {
		super(x, y, 1,1, 1, "GooBlaster",EnumLightLevels.FIFTEEN);
		this.world = world;
		Particle p = new Particle(x+25,y-8, 100 ,3,false);
		p.velocity = -5;
		this.emitter = new ParticleEmitter(p,world.particleManager);
	}

	public void update() {
		emitter.update();
	}
	public void render()
	{
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, FluxMain.gooblasttex.getTextureID());
		super.render();
	}

}
