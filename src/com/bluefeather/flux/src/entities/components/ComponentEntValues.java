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
import com.bluefeather.flux.src.entities.components.message.MessageDamageChange;
import com.bluefeather.flux.src.entities.components.message.MessageDeath;
import com.bluefeather.flux.src.entities.components.message.MessageHealthChange;

public class ComponentEntValues extends Component {

	
	public int health;
	public int damage;
	public ComponentEntValues(ComponentManager holder, int i_health, int i_damage) {
		super(holder, "EntVal");
		health = i_health;
		damage = i_damage;
		
	}


	public void recieveMessage(Message message) {
		if(message.name == "DamageChange")
		{
			MessageDamageChange hmessage = (MessageDamageChange)message;
			if(hmessage.positive)
			damage += hmessage.newDamage;
			else damage -= hmessage.newDamage;
			System.out.println(holder.process.name + ": Damage changed to " + damage);
		}

		if(message.name == "HealthChange")
		{
			MessageHealthChange hmessage = (MessageHealthChange)message;
			if(hmessage.positive)
				if(hmessage.mult)
				{
					health *= hmessage.newHealth;
				}
				else{
					health += hmessage.newHealth;
				}
			
			else
			{
				if(hmessage.mult)
				{
					health /= hmessage.newHealth;
				}
				else {
				health -= hmessage.newHealth;
				}
				System.out.println(holder.process.name + ": Youch! " + health);
			}
		}
	}
		
		public void update()
		{
			super.update();
			if(health <= 0)
			{
				fireMessage(new MessageDeath(this.name,"Manager"));
			}
		}


	

}
