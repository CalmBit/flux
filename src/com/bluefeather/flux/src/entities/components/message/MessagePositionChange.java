package com.bluefeather.flux.src.entities.components.message;

public class MessagePositionChange extends Message{
	
	public float nx,ny;

	public MessagePositionChange(String originatorName, String destinationName, float nx, float ny) {
		super("PositionChange", 1, originatorName, destinationName);
		this.nx = nx;
		this.ny = ny;
	}
	


}
