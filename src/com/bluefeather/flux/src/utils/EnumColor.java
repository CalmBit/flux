package com.bluefeather.flux.src.utils;

public enum EnumColor {

	RED(1,0,0),
	GREEN(0,1,0),
	BLUE(0,0,1),
	YELLOW(1,1,0),
	VIOLET(1,0,1),
	CYAN(0,1,1),
	GREY(.5f,.5f,.5f),
	BLACK(0,0,0),
	WHITE(1,1,1);
	
	public float red, green, blue;
	EnumColor(float r, float b, float g)
	{
		this.red = r;
		this.blue = b;
		this.green = g;
	}
	
}
