package com.bluefeather.flux.src.tile;

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
		if(name == "Dirt")
		{
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, FluxMain.dirttex.getTextureID());
		}
		else
		{
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, FluxMain.grasstex.getTextureID());
		}
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

}
