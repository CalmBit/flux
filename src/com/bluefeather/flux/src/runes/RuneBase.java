package com.bluefeather.flux.src.runes;

public abstract class RuneBase {

	public RunePrimaryMark pm;
	public RuneSecondaryMark sm1,sm2;
	public RuneTertiaryMark tm;
	public RuneBase(RunePrimaryMark pm, RuneSecondaryMark sm1, RuneSecondaryMark sm2, RuneTertiaryMark tm)
	{
		this.pm = pm;
		this.sm1 = sm1;
		this.sm2 = sm2;
		this.tm = tm;
	}
}
