package com.bluefeather.flux.src.entities.components;

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
			GL11.glVertex2f(doffset+(i*50), doffset);
			GL11.glVertex2f(doffset+(i*50), 64);
			
			GL11.glVertex2f(doffset+(i*50), doffset);
			GL11.glVertex2f(doffset+(i*50) + 50, doffset);
			
			GL11.glVertex2f(doffset+(i*50)+50, doffset);
			GL11.glVertex2f(doffset+(i*50)+50, 64);
			
			GL11.glVertex2f(doffset+(i*50) + 50, 64);
			GL11.glVertex2f(doffset+(i*50), 64);
			GL11.glEnd();
			GL11.glEnable(GL11.GL_TEXTURE_2D);
				if(inv[i] != null)
				{
					GL11.glBindTexture(GL11.GL_TEXTURE_2D, inv[i].texId);
					GL11.glBegin(GL11.GL_QUADS);
					GL11.glTexCoord2f(0, 0);
					GL11.glVertex2f(doffset+(i*50), doffset);
					GL11.glTexCoord2f(1, 0);
					GL11.glVertex2f(doffset+(i*50)+50, doffset);
					GL11.glTexCoord2f(1, 1);
					GL11.glVertex2f(doffset+(i*50)+50, doffset+50);
					GL11.glTexCoord2f(0, 1);
					GL11.glVertex2f(doffset+(i*50), doffset+50);
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
					inv[i] = ip.itemReturned;
					System.out.println("ADDED ITEM SLOT " + i);
					break;
				}
			}
		}

	}

}
