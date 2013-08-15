package com.bluefeather.flux.src.entities.components.message;

import com.bluefeather.flux.src.items.Item;

public class MessageItemPacket extends Message {

	public Item itemReturned;
	public MessageItemPacket(String originatorName,
			String destinationName, Item item) {
		super("ItemPacket", 10, originatorName, destinationName);
		this.itemReturned = item;
	}

}
