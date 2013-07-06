package com.bluefeather.flux.src.entities.components.message;

public class MessageRequestPosition extends Message {

	public MessageRequestPosition(String originatorName,
			String destinationName) {
		super("RequestPosition", 2, originatorName, destinationName);
		
	}

}
