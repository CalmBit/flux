package com.bluefeather.flux.src.utils;

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
	private float LIGHT_DIVISOR = 255/15;
	private EnumLightLevels(float num)
	{
		this.col = new Color(LIGHT_DIVISOR*num, LIGHT_DIVISOR*num, LIGHT_DIVISOR*num);
	}
}
