package com.bluefeather.flux.src.items;

import org.lwjgl.util.vector.Vector3f;

import com.bluefeather.flux.src.utils.EnumColor;

public class ItemGem extends Item {

	public EnumColor color;
	public ItemGem(EnumColor color) {
		super("Gem");
		this.color = color;
	}


	public ItemGem getInstance() {
		ItemGem n = new ItemGem(this.color);
		return n;
	}
	
	public void sayHi()
	{
		System.out.println(color);
	}

}
