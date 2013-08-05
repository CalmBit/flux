package com.bluefeather.flux.src.particles;

public class ParticleEmitter {

	private Particle template;
	protected ParticleManager manager;
	public ParticleEmitter(Particle template, ParticleManager manager)
	{
		this.template = template;
		this.manager = manager;
	}
	
	public void update()
	{
		Particle p = this.template.clone();
		this.manager.addParticle(p);
	}
}
