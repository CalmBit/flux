package com.bluefeather.flux.src.entities.components;

import org.lwjgl.opengl.GL11;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.entities.components.message.MessageRequestPosition;

public class ComponentRender extends Component {

	float x,y,sx,sy;
	float r,g,b;
	public ComponentRender(ComponentManager holder, float x, float y,float sx,float sy, float r, float g, float b) {
		super(holder, "Render");
		this.x = x;
		this.y = y;
		this.sx = sx;
		this.sy = sy;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public void update()
	{
		fireMessage(new MessageRequestPosition(this.name,"Position"));
		GL11.glColor3f(r, g, b);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(x, y);
		GL11.glVertex2f(x+sx, y);
		GL11.glVertex2f(x + sx, y + sy);
		GL11.glVertex2f(x, y + sy);
		GL11.glEnd();
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
