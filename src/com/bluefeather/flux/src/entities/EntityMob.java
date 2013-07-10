package com.bluefeather.flux.src.entities;

import com.bluefeather.flux.src.entities.components.ComponentAITest;

public class EntityMob extends Entity {

	public EntityMob(String name, float x, float y, int i_health, int texID) {
		super(name, x, y, i_health, texID);
		componentManager.addComponent(new ComponentAITest(componentManager));
	}

}
