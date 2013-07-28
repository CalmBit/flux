package com.bluefeather.flux.src.tile;

import com.bluefeather.flux.src.main.World;
import com.bluefeather.flux.src.particles.Particle;

public class TileGooBlaster extends Tile {

	World world;
	public TileGooBlaster(float x, float y, World world) {
		super(x, y, 1,1, 1, "GooBlaster");
		this.world = world;
	}

	public void update() {
		Particle p = new Particle(x+25,y-8, 100 ,3,false);
		p.velocity = -5;
		world.particleManager.addParticle(p);
	}

}
