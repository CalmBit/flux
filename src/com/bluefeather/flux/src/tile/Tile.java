package com.bluefeather.flux.src.tile;

public abstract class Tile {
	
	public float x,y;
	public float r,g,b;
	public String name;
	
	public Tile(float x, float y, float r, float g, float b, String name)
	{
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public void render()
	{
		
	}
	
	public abstract void update();

}
