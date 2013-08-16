package com.bluefeather.flux.src.entities.components;
/*
 * Copyright © 2013 BlueFeather Solutions LLC
 * All Rights Reserved.
 * 
 *  This file is part of The Flüx Engine.
 *
 *  The Flüx Engine is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Flüx Engine is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with The Flüx Engine.  If not, see <http://www.gnu.org/licenses/>.
 */
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
		
	}


	public void recieveMessage(Message message) {
		
		if(message.name == "ReadInventorySlot")
		{
			MessageReadInventorySlot r = (MessageReadInventorySlot)message;
			fireMessage(new MessageItemPacket(this.name,r.originatorName,inv[r.slot]));
		}
		if(message.name == "ItemPacket")
		{
			MessageItemPacket i = (MessageItemPacket)message;
			fireMessage(new MessageItemPacket(this.name,"GUI",i.itemReturned));
			for(int id = 0;id < slots;id++)
			{
				if(inv[id] == null)
				{
					inv[id] = i.itemReturned;
					System.out.println("A " + inv[id].registeredName + " was picked up in slot " + id);
					break;
				}
			}
		}
		
	}

}
