package com.bluefeather.flux.src.tile;

import org.lwjgl.opengl.GL11;

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
		GL11.glColor3f(r, g, b);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + 50, y);
		GL11.glVertex2f(x + 50, y + 50);
		GL11.glVertex2f(x, y + 50);
		GL11.glEnd();
		
		GL11.glColor3f(1, 1, 1);
		GL11.glBegin(GL11.GL_LINES);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + 50, y);
		
		GL11.glVertex2f(x + 50, y);
		GL11.glVertex2f(x + 50, y + 50);
		
		GL11.glVertex2f(x + 50, y + 50);
		GL11.glVertex2f(x, y + 50);
		
		GL11.glVertex2f(x, y + 50);
		GL11.glVertex2f(x, y);
		GL11.glEnd();
	}
	
	public abstract void update();

}
