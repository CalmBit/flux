package com.bluefeather.flux.src.entities.components;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;

public class ComponentPosition extends Component {

	float x,y;
	public ComponentPosition(ComponentManager holder, float ix, float iy) {
		super(holder, "Position");
		this.x = ix;
		this.y = iy;
		fireMessage(new MessagePositionChange(this.name,"Input",x,y));
	}

	public void update() {
		super.update();

	}



	public void recieveMessage(Message message) {
		
		if(message.name == "PositionChange")
		{
			MessagePositionChange pmessage = (MessagePositionChange) message;
			x = pmessage.nx;
			y = pmessage.ny;
			System.out.println(x + "," + y);
		}

	}

}
