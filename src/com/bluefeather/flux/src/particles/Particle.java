package com.bluefeather.flux.src.particles;
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


public class Particle {
	
	Random rand = new Random();
	public float x,y,rotx,roty,sx,sy;

	public float velocity = 1;
	public float xvelocity;
	public short lifetime;
	public int tex;
	public int xvs;
	public boolean floatp;
	public Particle(float i_x, float i_y, short time, int xvs, boolean floatp)
	{
		this.x= i_x;
		this.y = i_y;
		this.rotx = rand.nextFloat()*360;
		this.sx = 8;
		this.sy = 8;
		this.lifetime = time;
		this.xvs = xvs;
		this.floatp = floatp;
		if(rand.nextBoolean()) {
		this.xvelocity = rand.nextFloat()*xvs;
		}
		else
		{
			this.xvelocity = -(rand.nextFloat()*xvs);
		}
	}
	
	public Particle clone()
	{
		Particle c = new Particle(this.x,this.y,this.lifetime,this.xvs,this.floatp);
		c.velocity = this.velocity;
		return c;
	}
	

}
