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
import com.bluefeather.flux.src.entities.components.message.MessageDeath;
import com.bluefeather.flux.src.entities.components.message.MessageHealthChange;

public class ComponentHealth extends Component {

	private int health;
	public ComponentHealth(ComponentManager holder, int i_Health) {
		super(holder,"Health");
		this.health = i_Health;
	}
	
	public void update()
	{
		super.update();
		if(health <= 0)
		{
			fireMessage(new MessageDeath(this.name,"Manager"));
		}
	}

	public void recieveMessage(Message message) {
		
		if(message.name == "HealthChange")
		{
			MessageHealthChange hmessage = (MessageHealthChange)message;
			if(hmessage.positive)
			health += hmessage.newHealth;
			else
			{
				health -= hmessage.newHealth;
				System.out.println(holder.process.name + ": Youch! " + health);
			}
		}
	}

}
