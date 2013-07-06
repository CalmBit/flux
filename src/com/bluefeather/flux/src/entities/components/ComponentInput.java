package com.bluefeather.flux.src.entities.components;

import static org.lwjgl.input.Keyboard.*;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.main.FluxMain;
import com.bluefeather.flux.src.main.World;

public class ComponentInput extends Component {

	public float x,y;
	public ComponentInput(ComponentManager holder) {
		super(holder, "Input");
		
	}

	
	public void update() {
		super.update();
		if(x >= 0 && x + 50 <= FluxMain.width && y >= 0 && y + 50 <= FluxMain.height) {
			if(isKeyDown(KEY_W) || isKeyDown(KEY_S) || isKeyDown(KEY_A) || isKeyDown(KEY_D) ) {
				if(isKeyDown(KEY_W))
				{
					y -= 5;
				}
				if(isKeyDown(KEY_S))
				{
					y += 5;
				}
				if(isKeyDown(KEY_A))
				{
					x -= 5;
				}
				if(isKeyDown(KEY_D))
				{
					x += 5;
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
			System.out.println(x + "," + y);
		}

	}

}
