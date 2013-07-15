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
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.GL11;


import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.entities.components.message.MessageRequestPosition;

public class ComponentRender extends Component {

	float x,y,sx,sy;
	float r,g,b;
	int texID;
	public ComponentRender(ComponentManager holder, float i_x, float i_y,float sx,float sy, float r, float g, float b, int texID) {
		super(holder, "Render");
		this.x = i_x;
		this.y = i_y;
		this.sx = sx;
		this.sy = sy;
		this.r = r;
		this.g = g;
		this.b = b;
		this.texID = texID;
	}
	
	public void update()
	{
		fireMessage(new MessageRequestPosition(this.name,"Position"));
		GL11.glColor3f(r, g, b);
		glBindTexture(GL_TEXTURE_2D, texID);
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
