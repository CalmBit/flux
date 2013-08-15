package com.bluefeather.flux.src.entities.components;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessageItemPacket;
import com.bluefeather.flux.src.entities.components.message.MessageReadInventorySlot;
import com.bluefeather.flux.src.items.Item;
import com.bluefeather.flux.src.items.ItemGem;
import com.bluefeather.flux.src.utils.EnumColor;

public class ComponentInventory extends Component {

	public static int slots;
	public Item[] inv;
	public ComponentInventory(ComponentManager holder, int slots) {
		super(holder, "Inventory");
		this.slots = slots;
		inv = new Item[slots];
		inv[0] = new ItemGem(EnumColor.RED);
	}


	public void recieveMessage(Message message) {
		
		if(message.name == "ReadInventorySlot")
		{
			MessageReadInventorySlot r = (MessageReadInventorySlot)message;
			fireMessage(new MessageItemPacket(this.name,r.originatorName,inv[r.slot]));
		}
		
	}

}
