package com.bluefeather.flux.src.utils;
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
import org.newdawn.slick.Color;

public enum EnumLightLevels {

	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	ELEVEN(11),
	TWELVE(12),
	THIRTEEN(13),
	FOURTEEN(14),
	FIFTEEN(15);
	
	public Color col;
	public int num;
	private float LIGHT_DIVISOR = 255/15;
	private EnumLightLevels(float num)
	{
		this.num = (int) num;
		this.col = new Color(LIGHT_DIVISOR*num, LIGHT_DIVISOR*num, LIGHT_DIVISOR*num);
	}
}
