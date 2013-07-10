package com.bluefeather.flux.src.entities;

import com.bluefeather.flux.src.entities.components.ComponentInput;
import com.bluefeather.flux.src.main.FluxMain;

public class EntityPlayer extends Entity {
	
	private String networkedName;

	public EntityPlayer(float x, float y, String networkedName, int TexID) {
		super("Player", x, y, 100, TexID);
		this.networkedName = networkedName;
		componentManager.addComponent(new ComponentInput(componentManager));
	}

}
