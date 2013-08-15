package com.bluefeather.flux.src.entities.components.message;

public class MessageReadInventorySlot extends Message {

	public int slot;
	public MessageReadInventorySlot(String originatorName,
			String destinationName, int slot) {
		super("ReadInventorySlot", 9, originatorName, destinationName);
		this.slot = slot;
	}

}
