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
import com.bluefeather.flux.src.items.ItemStack;
import com.bluefeather.flux.src.utils.EnumColor;

public class ComponentInventory extends Component {

	public static int slots;
	public ItemStack[] inv;
	public ComponentInventory(ComponentManager holder, int slots) {
		super(holder, "Inventory");
		this.slots = slots;
		inv = new ItemStack[slots];
		
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
			for(int a = 0;a < inv.length;a++)
			{
				if(inv[a] != null)
				{
					//Make sure there isn't already a non-full same item stack
					if(inv[a].item.registeredName == i.itemReturned.item.registeredName && inv[a].item.maxStackSize > inv[a].quanity)
					{
						inv[a].quanity++;
						System.out.println("Another " + inv[a].item.registeredName + " was added to slot " + a + ".");
						System.out.println("That makes " + inv[a].quanity + ".");
						System.out.println(inv[a].item.maxStackSize);
						break;
					}
				}
				//Otherwise, create a stack in a new slot
				else
				{
					inv[a] = i.itemReturned;
					System.out.println("A " + inv[a].item.registeredName + " was added to slot " + a + ".");
					fireMessage(new MessageItemPacket(this.name,"GUI",i.itemReturned));
					break;
				}
			}
		}
		
	}

}
