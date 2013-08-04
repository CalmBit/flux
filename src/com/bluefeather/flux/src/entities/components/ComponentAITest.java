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
import com.bluefeather.flux.src.entities.components.message.MessageChangeXVelocity;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.entities.components.message.MessageRequestPosition;
import com.bluefeather.flux.src.main.FluxMain;

public class ComponentAITest extends Component {

	float x,y;
	boolean reverse = false;
	public ComponentAITest(ComponentManager holder) {
		super(holder, "AITest");
		fireMessage(new MessageRequestPosition(this.name, "Position"));
	}
	
	public void update()
	{
		fireMessage(new MessageRequestPosition(this.name, "Position"));
		if(x + 50 >= FluxMain.width)
		{
			reverse = true;
		}
		else if(x <= 0)
		{
			reverse = false;
		}
		if(!reverse)
		fireMessage(new MessageChangeXVelocity(this.name, "Position", 1));
		else
			fireMessage(new MessageChangeXVelocity(this.name, "Position", -1));
			
	}

	public void recieveMessage(Message message) {
		if(message.name == "PositionChange")
		{
			MessagePositionChange pmessage = (MessagePositionChange)message;
			x = pmessage.nx;
			y = pmessage.ny;
		}
	}

}
