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
import java.util.ArrayList;
import org.lwjgl.opengl.GL11;
import com.bluefeather.flux.src.main.FluxMain;
import com.bluefeather.flux.src.main.World;
import com.bluefeather.flux.src.particles.Particle;

public class ParticleManager {

	int limit;
	int numOfParticles = 0;
	protected ArrayList<Particle> particles = new ArrayList<Particle>();
	protected ArrayList<Particle> debris = new ArrayList<Particle>();
	public ParticleManager(int limit)
	{
		this.limit = limit;
	}
	
	public void addParticle(Particle particle)
	{
		if(numOfParticles < limit)
		{
			numOfParticles++;
			particles.add(particle);
		}
		else
		{
			System.out.println("Particle manager has reached capacity! " + limit);
		}
	}
	
	public void update()
	{	for(Particle p : particles) {
			if(p.y >= 0 && p.y + p.sy <= FluxMain.height) {
				if(World.collisionMap[(int)p.x/50][(int)((p.y+50)/50)-1])
				{
					p.y = (int)p.y;
					p.velocity = 1;
					p.xvelocity = 0;
					p.lifetime--;
					if(p.lifetime <= 0) {
						debris.add(p);
					}
				}
				else if(!World.collisionMap[(int)p.x/50][(int)((p.y+50)/50)-1])
				{
					p.y += p.velocity;
					p.x += p.xvelocity;
					if(!p.floatp) {
					p.velocity += 0.1;
					}
					else p.velocity -= 0.01;
					if(p.xvelocity > 0) {
					p.xvelocity -= 0.01;
					}
					else
					{
						p.xvelocity += 0.01;
					}
				}
			}
			if(p.y <= 0)
			{
				p.y = (int)p.y + 100;
				p.velocity = 0;
				debris.add(p);
			}
			if(p.x <= 0)
			{
				p.x = (int)p.x + 1;
				p.xvelocity = 0;
			}
			
		}
	
		for(Particle p : debris)
		{
			destroyParticle(p);
		}
		
		debris.clear();
		
	}
	
	public void destroyParticle(Particle p)
	{
		if(particles.contains(p) && debris.contains(p))
		{
			particles.remove(p);
			numOfParticles--;
		}
	}
	public void render()
	{
		for(Particle p : particles) {
			if(p.tex == 0)
			{
				p.tex = FluxMain.gooparticle.getTextureID();
			}
			GL11.glPushMatrix();
			GL11.glTranslatef(p.x + (p.sx/2), p.y + (p.sy/2), 0);
			GL11.glRotatef(p.rotx, 0, 0, 1);
			GL11.glRotatef(p.roty, 1, 0, 0);
			GL11.glTranslatef(-(p.x + (p.sx/2)),-(p.y + (p.sy/2)), 0);
			
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, p.tex);
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(p.x, p.y);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(p.x + p.sx, p.y);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(p.x + p.sx, p.y + p.sy);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(p.x, p.y  + p.sy);
			GL11.glEnd();
			GL11.glPopMatrix();
		}
		
	}
}
