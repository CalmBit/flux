package com.bluefeather.flux.src.entities.components.message;

public class MessageHealthChange extends Message {

	public int newHealth;
	public boolean positive;
	public MessageHealthChange(String originatorName,
			String destinationName, int newHealth, boolean pos) {
		super("HealthChange", 4, originatorName, destinationName);
		this.newHealth = newHealth;
		this.positive = pos;
	}

}
