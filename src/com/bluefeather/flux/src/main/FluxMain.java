package com.bluefeather.flux.src.main;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class FluxMain {
	public World world = new World("World 1");
	public static int width = 800,height = 600;
	
	private EnumGameState gameState = EnumGameState.GAME;

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

 
 public void init() {
	 
	 glClearColor(0f,0f,0f,1f);
	 glMatrixMode(GL_PROJECTION);
	 glLoadIdentity();
	 glOrtho(0,width,height,0,1,-1);
	 glMatrixMode(GL_MODELVIEW);
	 glEnable(GL_TEXTURE_2D); 
	 glEnable(GL_BLEND);
	 glBlendFunc(GL_SRC_ALPHA, GL_ONE);
	 
 }
 
 

 
 public static void main(String[] args) throws IOException {
	 FluxMain thegame =  new FluxMain();
	 thegame.start();
 }
}

