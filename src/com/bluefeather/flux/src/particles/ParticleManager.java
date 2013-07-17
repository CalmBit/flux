package com.bluefeather.flux.src.particles;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
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
			if(p.x >= 0 && p.x + p.sx <= FluxMain.width && p.y >= 0 && p.y + p.sy <= FluxMain.height) {
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
					p.velocity += 0.1;
					if(p.xvelocity > 0) {
					p.xvelocity -= 0.01;
					}
					else
					{
						p.xvelocity += 0.01;
					}
				}
			}
			else if(p.y <= 0)
			{
				p.y = (int)p.y + 1;
				p.velocity = 0;
			}
			else if(p.x <= 0)
			{
				p.x = (int)p.x + 1;
				p.xvelocity = 0;
			}
			else if(p.x + 8 >= FluxMain.width)
			{
				p.x  = (int)FluxMain.width - 9;
				p.xvelocity = 0;
			}
		}
	
		for(Particle p : debris)
		{
			destroyParticle(p);
		}
	}
	
	public void destroyParticle(Particle p)
	{
		if(particles.contains(p) && debris.contains(p) && p.lifetime <= 0)
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
				p.tex = FluxMain.grasstex.getTextureID();
			}
			GL11.glPushMatrix();
			GL11.glTranslatef(p.x + (p.sx/2), p.y + (p.sy/2), 0);
			GL11.glRotatef(p.rotx, 0, 0, 1);
			GL11.glRotatef(p.roty, 1, 0, 0);
			GL11.glTranslatef(-(p.x + (p.sx/2)),-(p.y + (p.sy/2)), 0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, p.tex);
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(p.x, p.y);
			GL11.glVertex2f(p.x + p.sx, p.y);
			GL11.glVertex2f(p.x + p.sx, p.y + p.sy);
			GL11.glVertex2f(p.x, p.y  + p.sy);
			GL11.glEnd();
			GL11.glPopMatrix();
		}
		
	}
}
