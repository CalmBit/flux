package com.bluefeather.flux.src.entities.components.message;

public class MessageCollision extends Message {

	public MessageCollision(String originatorName,
			String destinationName) {
		super("Collision", 8, originatorName, destinationName);
		
	}

}
