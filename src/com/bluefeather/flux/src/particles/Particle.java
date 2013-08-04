package com.bluefeather.flux.src.particles;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

public class Particle {
	
	Random rand = new Random();
	public float x,y,rotx,roty,sx,sy;

	public float velocity = 1;
	public float xvelocity;
	public int lifetime;
	public int tex;
	public int xvs;
	public boolean floatp;
	public Particle(float i_x, float i_y, int time, int xvs, boolean floatp)
	{
		this.x= i_x;
		this.y = i_y;
		this.rotx = rand.nextFloat()*360;
		this.sx = 8;
		this.sy = 8;
		this.lifetime = time;
		this.xvs = xvs;
		this.floatp = floatp;
		this.tex = tex;
		if(rand.nextBoolean()) {
		this.xvelocity = rand.nextFloat()*xvs;
		}
		else
		{
			this.xvelocity = -(rand.nextFloat()*xvs);
		}
	}
	
	
	public void render()
	{
		
	}

}
