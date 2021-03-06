package com.bluefeather.flux.src.entities.components;
/*
 * Copyright � 2013 BlueFeather Solutions LLC
 * All Rights Reserved.
 * 
 *  This file is part of The Fl�x Engine.
 *
 *  The Fl�x Engine is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Fl�x Engine is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with The Fl�x Engine.  If not, see <http://www.gnu.org/licenses/>.
 */
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBindTexture;

import org.lwjgl.opengl.GL11;






import org.lwjgl.util.vector.Vector3f;
import org.newdawn.slick.Color;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessageDeath;
import com.bluefeather.flux.src.entities.components.message.MessagePositionChange;
import com.bluefeather.flux.src.entities.components.message.MessageRequestPosition;
import com.bluefeather.flux.src.main.FluxMain;
import com.bluefeather.flux.src.particles.Particle;

public class ComponentRender extends Component {

	float x,y,sx,sy;
	int texID;
	Vector3f color;
	public ComponentRender(ComponentManager holder, float i_x, float i_y,float sx,float sy, Vector3f color, int texID) {
		super(holder, "Render");
		this.x = i_x;
		this.y = i_y;
		this.sx = sx;
		this.sy = sy;
		this.color = color;
		this.texID = texID;
		
	}
	
	public void update()
	{
		fireMessage(new MessageRequestPosition(this.name,"Position"));
		new Color((float)color.x, (float)color.y, (float)color.z).bind();
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
		
		if(message.name == "Death")
		{
			MessageDeath d = (MessageDeath)message;
			if(d.announce) {
			for(int i = 0;i < 20;i++)
			{
				Particle p = new Particle(x+25, y, (short)100,2,false);
				p.velocity = -3;
				p.tex = FluxMain.bloodparticle.getTextureID();
				holder.process.world.particleManager.addParticle(p);
			}
			}
		}

	}

}
