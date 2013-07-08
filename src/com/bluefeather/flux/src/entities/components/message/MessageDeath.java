package com.bluefeather.flux.src.entities.components.message;

public class MessageDeath extends Message {

	public MessageDeath(String originatorName,
			String destinationName) {
		super("Death", 5, originatorName, destinationName);
	}

}
