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
import com.bluefeather.flux.src.entities.components.message.MessageHealthChange;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
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
		if(x >= 0 && x + 50 <= FluxMain.width && y >= 0 && y + 50 <= FluxMain.height) {
			if(isKeyDown(KEY_W) || isKeyDown(KEY_S) || isKeyDown(KEY_A) || isKeyDown(KEY_D) || isKeyDown(KEY_F)  || isKeyDown(KEY_K)) {
				if(isKeyDown(KEY_W))
				{
					y -= 5;
					fireMessage(new MessageAscending(this.name, "Position"));
				}
				if(isKeyDown(KEY_A))
				{
					x -= 5;
				}
				if(isKeyDown(KEY_D))
				{
					x += 5;
				}
				if(isKeyDown(KEY_K))
				{
					fireMessage(new MessageHealthChange(this.name, "EntVal", 1000, false, false));
				}
				if(isKeyDown(KEY_F))
				{
					Particle p = new Particle(x+25+baseRand.nextFloat()*5, y, 100,2);
					p.velocity = -5;
					holder.process.world.particleManager.addParticle(p);
				}
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
		}
		else
		{
			if(x < 0)
			{
				x = 0;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
			if(x + 50 > FluxMain.width)
			{
				x = FluxMain.width - 50;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
			if(y < 0)
			{
				y = 0;
				fireMessage(new MessagePositionChange(name, "Position", x, y));
			}
			if(y + 50 > FluxMain.height)
			{
				y = FluxMain.height - 50;
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

	}

}
