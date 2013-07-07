package com.bluefeather.flux.src.main;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL14.*;
import java.io.IOException;
import java.io.InputStream;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class FluxMain {
	public World world = new World("World 1");
	public static int width = 800,height = 600;
	
	private EnumGameState gameState = EnumGameState.GAME;
	
	public static Texture enttex;
	public static Texture dirttex;
	public static Texture grasstex;

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
		glClearColor(0.54f,0.98f,1f,1f);
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
	 dirttex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/dirt.png"), "dirt.png");
	 grasstex = addTexture("PNG0",ResourceLoader.getResourceAsStream("res/grass.png"), "grass.png");
 }
 
 

 
 public static void main(String[] args) throws IOException {
	 FluxMain thegame =  new FluxMain();
	 thegame.start();
 }
}

