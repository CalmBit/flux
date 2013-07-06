package com.bluefeather.flux.src.entities.components;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.main.World;

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
		
		if(World.collisionMap[(int)x/50][(int)(y+50)/50])
		{
			System.out.println("COLLIDE");
			y = y-1;
			fireMessage(new MessagePositionChange(this.name,"Input",x,y));
			fireMessage(new MessagePositionChange(this.name,"Render",x,y));
		}

	}



	public void recieveMessage(Message message) {
		
		if(message.name == "PositionChange")
		{
			MessagePositionChange pmessage = (MessagePositionChange) message;
			x = pmessage.nx;
			y = pmessage.ny;
			fireMessage(new MessagePositionChange(this.name,"Render",x,y));
		}
		if(message.name == "RequestPosition")
		{
			fireMessage(new MessagePositionChange(this.name, "Render", x,y));
		}

	}

}
