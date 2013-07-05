package com.bluefeather.flux.src.tile;

public abstract class Tile {
	
	public float x,y;
	public float r,g,b;
	
	public Tile(float x, float y, float r, float g, float b)
	{
		this.x = x;
		this.y = y;
	}
	
	public void render()
	{
		
	}
	
	public abstract void update();

}
