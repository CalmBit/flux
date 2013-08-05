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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class FluxMain {
	public World world;
	public static int width = 800,height = 600;
	public static float br = 0.54f,bg = 0.98f,bb = 1f,ba = 1f;
	public static int fpscap = 120;
	public Camera camera = new Camera(0,0,0,0,0,0,90,800,0,0);
	public static float cx,cy;
	private EnumGameState gameState = EnumGameState.GAME;
	
	public static Texture enttex;
	public static Texture dirttex;
	public static Texture grasstex;
	public static Texture enttex2;
	public static Texture bloodparticle;
	public static Texture gooparticle;
	public static Texture gooblasttex;
	public static Texture smokeparticle;
	public static Texture splash;
	public static Texture sky;
 public void start() throws IOException {
	try {
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
		Display.setTitle("Flüx Engine V.0.0.1");
		
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
			case SPLASH:
				displaySplash();
				break;
			case GAME:
				cx = camera.x;
				cy = camera.y;
				world.update();
				camera.processKeyboard(10);
				camera.translate();
				break;
			default:
				break;
		}
		Display.update();
		Display.sync(fpscap);
	}
	Display.destroy();
 }

 public void displaySplash()
 {
	
	 splash.bind();
	 glBegin(GL_QUADS);
	 glTexCoord2f(0,0);
	 glVertex2f(0,0);
	 glTexCoord2f(1,0);
	 glVertex2f(width,0);
	 glTexCoord2f(1,1);
	 glVertex2f(width,height);
	 glTexCoord2f(0,1);
	 glVertex2f(0,height);
	 glEnd();
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
	 glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
	 
	 
	 
	 enttex = addTexture("PNG",ResourceLoader.getResourceAsStream("res/theguytrans.png"),"theguytrans.png");
	 enttex2 = addTexture("PNG",ResourceLoader.getResourceAsStream("res/theguytrans2.png"),"theguytrans2.png");
	 dirttex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/dirt.png"), "dirt.png");
	 grasstex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/grass.png"), "grass.png");
	 bloodparticle = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/blood.png"), "blood.png");
	 smokeparticle = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/smoke.png"),"smoke.png");
	 gooparticle = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/goo.png"),"goo.png");
	 gooblasttex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/gooblast.png"), "gooblast.png");
	 splash = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/splash.png"),"splash.png");
	 sky = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/sky.png"),"sky.png");
	 world = new World("World 1");
 }
 
 

 
 public static void main(String[] args) throws IOException {
	 FluxMain thegame =  new FluxMain();
	 thegame.start();
 }
}

