package com.bluefeather.flux.src.entities.components;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessageHealthChange;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.main.World;

public class ComponentPosition extends Component {

	float x,y;
	float velocity = 1;
	boolean ascending = true;
	boolean wasAsc = false;
	boolean living;
	public ComponentPosition(ComponentManager holder, float i_x, float i_y, boolean i_living) {
		super(holder, "Position");
		this.x = i_x;
		this.y = i_y;
		this.living = i_living;
		fireMessage(new MessagePositionChange(this.name,"Input",x,y));
	}

	public void update() {
		super.update();
		
		if(ascending) wasAsc = true;
		
		if(World.collisionMap[(int)x/50][(int)(y+50)/50])
		{
			y = (int)y-1;
			fireMessage(new MessagePositionChange(this.name,"Input",x,y));
			fireMessage(new MessagePositionChange(this.name,"Render",x,y));
		}
		if(!World.collisionMap[(int)x/50][(int)((y+50)/50)])
		{
			if(wasAsc && !ascending) velocity = 1;
			y = y + velocity;
			velocity += 0.1;
			fireMessage(new MessagePositionChange(this.name,"Input",x,y));
			fireMessage(new MessagePositionChange(this.name,"Render",x,y));
			//System.out.println(velocity);
		}
		else
		{
			y = (int)y;
			//make sure the bloody thing is living before executing a command that isn't there
			if(living)
			{
				if(ascending) {
				if((velocity - 5) > 7){
					fireMessage(new MessageHealthChange(this.name,"Health", (int)velocity, false));
					}
				
				}
				else
				{
					if((velocity) > 7){
						fireMessage(new MessageHealthChange(this.name,"Health",(int)velocity , false));
						}
				}
				velocity = 1;
			}
		}
		if(!ascending) wasAsc = false;
		ascending = false;
		

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
		if(message.name == "Ascending")
		{
			ascending = true;
		}

	}

}
