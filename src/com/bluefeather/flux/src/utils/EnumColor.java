package com.bluefeather.flux.src.utils;
/*
 * Copyright � 2013 BlueFeather Solutions LLC
 * All Rights Reserved.
 * 
 *  This file is part of The Fl�x Engine.
 *
 *  The Fl�x Engine is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Fl�x Engine is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with The Fl�x Engine.  If not, see <http://www.gnu.org/licenses/>.
 */
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
