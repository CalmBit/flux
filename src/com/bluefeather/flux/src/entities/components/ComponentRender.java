package com.bluefeather.flux.src.entities.components;

import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.entities.components.message.MessageRequestPosition;
import com.bluefeather.flux.src.main.FluxMain;

public class ComponentRender extends Component {

	float x,y,sx,sy;
	float r,g,b;
	static Texture tex;
	public ComponentRender(ComponentManager holder, float i_x, float i_y,float sx,float sy, float r, float g, float b, Texture tex) {
		super(holder, "Render");
		this.x = i_x;
		this.y = i_y;
		this.sx = sx;
		this.sy = sy;
		this.r = r;
		this.g = g;
		this.b = b;
		this.tex = tex;
	}
	
	public void update()
	{
		fireMessage(new MessageRequestPosition(this.name,"Position"));
		GL11.glColor3f(r, g, b);
		glBindTexture(GL_TEXTURE_2D,FluxMain.enttex.getTextureID());
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0,0);
		GL11.glVertex2f(x, y);
		GL11.glTexCoord2f(1,0);
		GL11.glVertex2f(x+sx, y);
		GL11.glTexCoord2f(1,1);
		GL11.glVertex2f(x + sx, y + sy);
		GL11.glTexCoord2f(0,1);
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
