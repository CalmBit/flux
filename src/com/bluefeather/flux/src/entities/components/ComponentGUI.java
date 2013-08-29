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
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.bluefeather.flux.src.entities.components.message.Message;
import com.bluefeather.flux.src.entities.components.message.MessageItemPacket;
import com.bluefeather.flux.src.items.Item;
import com.bluefeather.flux.src.main.FluxMain;

public class ComponentGUI extends Component {

	public Item[] inv;
	public int slots = 9;
	public int tid;
	private int doffset = 10;
	public ComponentGUI(ComponentManager holder, int t) {
		super(holder, "GUI");
		// TODO Auto-generated constructor stub
		inv = new Item[slots];
		this.tid = t;
	}

	public void update()
	{
		super.update();
			//GL11.glColor3f(1, 1, 1);
			
			for(int i = 0;i < slots;i++)
			{
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glBegin(GL11.GL_LINES);
			GL11.glVertex2f(doffset+(i*50)+FluxMain.cx, doffset + FluxMain.cy);
			GL11.glVertex2f(doffset+(i*50) + FluxMain.cx, 64 + FluxMain.cy);
			
			GL11.glVertex2f(doffset+(i*50) + FluxMain.cx, doffset + FluxMain.cy);
			GL11.glVertex2f(doffset+(i*50) + FluxMain.cx + 50, doffset + FluxMain.cy);
			
			GL11.glVertex2f(doffset+(i*50)+50 + FluxMain.cx, doffset + FluxMain.cy);
			GL11.glVertex2f(doffset+(i*50)+50 + FluxMain.cx, 64 + FluxMain.cy);
			
			GL11.glVertex2f(doffset+(i*50) + 50 + FluxMain.cx, 64 + FluxMain.cy);
			GL11.glVertex2f(doffset+(i*50) + FluxMain.cx, 64 + FluxMain.cy);
			GL11.glEnd();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
				if(inv[i] != null)
				{
					GL11.glBindTexture(GL11.GL_TEXTURE_2D, inv[i].texId);
					GL11.glBegin(GL11.GL_QUADS);
					GL11.glTexCoord2f(0, 0);
					GL11.glVertex2f(doffset+(i*50) + FluxMain.cx, doffset + FluxMain.cy);
					GL11.glTexCoord2f(1, 0);
					GL11.glVertex2f(doffset+(i*50)+50 + FluxMain.cx, doffset + FluxMain.cy);
					GL11.glTexCoord2f(1, 1);
					GL11.glVertex2f(doffset+(i*50)+50 + FluxMain.cx, doffset+50 + FluxMain.cy);
					GL11.glTexCoord2f(0, 1);
					GL11.glVertex2f(doffset+(i*50) + FluxMain.cx, doffset+50 + FluxMain.cy);
					GL11.glEnd();
				}
			}
			
			
			
			
		
	}
	public void recieveMessage(Message message) {
		if(message.name == "ItemPacket")
		{
			MessageItemPacket ip = (MessageItemPacket)message;
			for(int i = 0; i < slots;i++)
			{
				if(inv[i] == null)
				{
					inv[i] = ip.itemReturned.item;
					break;
				}
			}
		}

	}

}
