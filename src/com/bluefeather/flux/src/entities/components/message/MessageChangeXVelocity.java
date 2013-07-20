package com.bluefeather.flux.src.entities.components.message;

public class MessageChangeXVelocity extends Message {

	public float newVelocity;
	public MessageChangeXVelocity(String originatorName,
			String destinationName, float newVelocity) {
		super("ChangeXVelocity", 7, originatorName, destinationName);
		this.newVelocity = newVelocity;
	}

}
