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
import com.bluefeather.flux.src.entities.components.message.MessageHealthChange;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.main.World;

public class ComponentPosition extends Component {

	float x,y;
	float velocity = 1;
	float xvelocity = 0;
	boolean ascending = true;
	boolean wasAsc = false;
	boolean strafing = false;
	boolean hasInput;
	boolean living;
	int steps;
	public ComponentPosition(ComponentManager holder, float i_x, float i_y, boolean i_living, boolean hasInput) {
		super(holder, "Position");
		this.x = i_x;
		this.y = i_y;
		this.living = i_living;
		this.hasInput = hasInput;
		fireMessage(new MessagePositionChange(this.name,"Input",x,y));
	}

	public void update() {
		super.update();
		
		if(ascending) wasAsc = true;
		x += xvelocity;
		if(!World.collisionMap[(int)(x+.50)/50][(int)((y+50)/50)] && !World.collisionMap[(int)(x+50)/50][(int)((y+50)/50)])
		{
			if(wasAsc && !ascending) velocity = 1;
			y += velocity;
			velocity += 0.1;
			fireMessage(new MessagePositionChange(this.name,"Input",x,y));
			fireMessage(new MessagePositionChange(this.name,"Render",x,y));
			//System.out.println(velocity);
		}
		else
		{
			y = (int)y;
			x = (int)x;
			//collide left block
			if(World.collisionMap[(int)((x+.50)+50)/50][(int)((y)/50)])
			{
				if(xvelocity > 0)
				{
				
				x = World.posMap[(int)((x+.50)+50)/50][(int)((y)/50)].x - 50;
				
				}
			}
			//collide right block
			if(World.collisionMap[(int)((x+.50))/50][(int)((y)/50)])
			{
				if(xvelocity < 0)
				{
					x = World.posMap[(int)((x+.50))/50][(int)((y)/50)].x + 50;
				}
			}
			fireMessage(new MessagePositionChange(this.name,"Input",x,y));
			fireMessage(new MessagePositionChange(this.name,"Render",x,y));
			//make sure the bloody thing is living before executing a command that isn't there
			if(living)
			{
				if(ascending) {
				if((velocity - 5) > 7){
					fireMessage(new MessageHealthChange(this.name,"EntVal", (int)velocity, false, false));
					}
				
				}
				else
				{
					if((velocity) > 7){
						fireMessage(new MessageHealthChange(this.name,"EntVal",(int)velocity , false, false));
						}
				}
				velocity = 1;
			}
		}
		if(!strafing)
		{
			if(xvelocity != 0)
			{
				if(xvelocity > 0)
				{
					xvelocity -= 0.1;
					steps++;
				}
				if(xvelocity < 0)
				{
					xvelocity += 0.1;
					steps++;
				}
				
				if(xvelocity <= 0.01 && xvelocity >= -0.01)
				{
					xvelocity = 0;
					System.out.println("Steps: " + steps);
					steps = 0;
				}
				System.out.println(xvelocity);
			}
		}
		if(!ascending) wasAsc = false;
		ascending = false;
		if(strafing) strafing = false;
		

	}
	
	public void fireMessage(Message message)
	{
		if(message.destinationName == "Input" && !hasInput)
		{
			
		}
		else
		{
			super.fireMessage(message);
		}
	}



	public void recieveMessage(Message message) {
		
		if(message.name == "PositionChange")
		{
			MessagePositionChange pmessage = (MessagePositionChange) message;
			x = pmessage.nx;
			y = pmessage.ny;
			fireMessage(new MessagePositionChange(this.name,message.originatorName,x,y));
		}
		if(message.name == "RequestPosition")
		{
			fireMessage(new MessagePositionChange(this.name, message.originatorName, x,y));
		}
		if(message.name == "Ascending")
		{
			ascending = true;
		}
		if(message.name == "ChangeXVelocity")
		{
			MessageChangeXVelocity vmessage = (MessageChangeXVelocity)message;
			xvelocity = vmessage.newVelocity;
			strafing = true;
		}

	}

}
