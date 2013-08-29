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
import static org.lwjgl.input.Keyboard.*;

import java.util.Random;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessageAscending;
import com.bluefeather.flux.src.entities.components.message.MessageChangeXVelocity;
import com.bluefeather.flux.src.entities.components.message.MessageHealthChange;
import com.bluefeather.flux.src.entities.components.message.MessageItemPacket;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.entities.components.message.MessageReadInventorySlot;
import com.bluefeather.flux.src.items.ItemGem;
import com.bluefeather.flux.src.main.FluxMain;
import com.bluefeather.flux.src.particles.Particle;


public class ComponentInput extends Component {

	public float x,y;
	public Random baseRand = new Random();
	public ComponentInput(ComponentManager holder) {
		super(holder, "Input");
		
	}

	
	public void update() {
		super.update();
		if(y >= FluxMain.cy && y + 50 <= FluxMain.cy + FluxMain.height) {
			if(isKeyDown(KEY_SPACE) || isKeyDown(KEY_S) || isKeyDown(KEY_A) || isKeyDown(KEY_D) || isKeyDown(KEY_F)  || isKeyDown(KEY_K)) {
				if(isKeyDown(KEY_SPACE))
				{
					y -= 5;
					fireMessage(new MessageAscending(this.name, "Position"));
				}
				if(isKeyDown(KEY_A))
				{
					//x -= 5;
					fireMessage(new MessageChangeXVelocity(this.name,"Position",-1));
				}
				if(isKeyDown(KEY_D))
				{
					//x += 5;
					fireMessage(new MessageChangeXVelocity(this.name,"Position",1));
				}
				if(isKeyDown(KEY_K))
				{
					fireMessage(new MessageHealthChange(this.name, "EntVal", 1000, false, false));
				}
				if(isKeyDown(KEY_F))
				{
					Particle p = new Particle(x+25+baseRand.nextFloat()*5, y, (short) 100,1,true);
					p.velocity = -1;
					p.tex = FluxMain.smokeparticle.getTextureID();
					holder.process.world.particleManager.addParticle(p);
				}
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
		}
		else
		{
			if(x < FluxMain.cx)
			{
				x = FluxMain.cx;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
			if(x + 50 > FluxMain.cx + FluxMain.width)
			{
				x = FluxMain.cx + FluxMain.width - 50;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
			if(y < FluxMain.cy)
			{
				y = FluxMain.cy;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
			if(y + 50 > FluxMain.cy + FluxMain.height)
			{
				y = FluxMain.cy + FluxMain.height - 50;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
		}
	}

	
	public void recieveMessage(Message message) {
		
		if(message.name == "PositionChange")
		{
			MessagePositionChange pmessage = (MessagePositionChange) message;
			x = pmessage.nx;
			y = pmessage.ny;
		}
		if(message.name == "ItemPacket")
		{
			MessageItemPacket packet = (MessageItemPacket) message;
			ItemGem gem = (ItemGem)packet.itemReturned.item;
		}

	}

}
