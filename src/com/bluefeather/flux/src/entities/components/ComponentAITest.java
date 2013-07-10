package com.bluefeather.flux.src.entities.components;

import com.bluefeather.flux.src.entities.components.message.Message;
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
		fireMessage(new MessagePositionChange(this.name,"Position",x + 1, y));
		else
		fireMessage(new MessagePositionChange(this.name,"Position",x - 1, y));
			
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
