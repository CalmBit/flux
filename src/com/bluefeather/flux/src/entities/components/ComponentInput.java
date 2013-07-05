package com.bluefeather.flux.src.entities.components;

import static org.lwjgl.input.Keyboard.*;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;

public class ComponentInput extends Component {

	public float x,y;
	public ComponentInput(ComponentManager holder) {
		super(holder, "Input");
		
	}

	
	public void update() {
		super.update();
		if(isKeyDown(KEY_W) || isKeyDown(KEY_S) || isKeyDown(KEY_A) || isKeyDown(KEY_D) ) {
		if(isKeyDown(KEY_W))
		{
			y += 5;
		}
		if(isKeyDown(KEY_S))
		{
			y -= 5;
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
