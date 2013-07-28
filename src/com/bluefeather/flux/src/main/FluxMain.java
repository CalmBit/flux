package com.bluefeather.flux.src.main;
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
import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class FluxMain {
	public World world;
	public static int width = 800,height = 600;
	public static float br = 0.54f,bg = 0.98f,bb = 1f,ba = 1f;
	private EnumGameState gameState = EnumGameState.GAME;
	
	public static Texture enttex;
	public static Texture dirttex;
	public static Texture grasstex;
	public static Texture enttex2;
	public static Texture bloodparticle;
	public static Texture gooblasttex;
 public void start() throws IOException {
	try {
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
	} 
	catch(LWJGLException e) {
		e.printStackTrace();
		System.exit(0);
	}
	
	init();
	
	while(!Display.isCloseRequested()) {
		glClearColor(br,bg,bb,ba);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		switch(gameState)
		{
			case GAME:
				world.update();
				break;
			default:
				break;
		}
		Display.update();
		Display.sync(120);
	}
	Display.destroy();
 }

 
 public Texture addTexture(String format, InputStream stream, String path)
	{
		try {
		System.out.println("File " + path + " was loaded.");
		return TextureLoader.getTexture(format,stream);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
 
 
 public void init() {
	 
	 glClearColor(0f,0f,0f,1f);
	 glMatrixMode(GL_PROJECTION);
	 glLoadIdentity();
	 glOrtho(0,width,height,0,1,-1);
	 glMatrixMode(GL_MODELVIEW);
	 glEnable(GL_TEXTURE_2D); 
	 glEnable(GL_BLEND);
	 glBlendFunc(GL_ONE,GL_ZERO);
	 //GL14.glBlendEquation(mode);
	 
	 
	 enttex = addTexture("PNG",ResourceLoader.getResourceAsStream("res/theguy.png"),"theguy.png");
	 enttex2 = addTexture("PNG",ResourceLoader.getResourceAsStream("res/theguy2.png"),"theguy2.png");
	 dirttex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/dirt.png"), "dirt.png");
	 grasstex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/grass.png"), "grass.png");
	 bloodparticle = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/blood.png"), "blood.png");
	 gooblasttex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/gooblast.png"), "gooblast.png");
	 world = new World("World 1");
 }
 
 

 
 public static void main(String[] args) throws IOException {
	 FluxMain thegame =  new FluxMain();
	 thegame.start();
 }
}

