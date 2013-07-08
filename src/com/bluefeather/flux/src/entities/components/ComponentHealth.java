package com.bluefeather.flux.src.entities.components;

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
				System.out.println("Youch! " + health);
			}
		}
	}

}
