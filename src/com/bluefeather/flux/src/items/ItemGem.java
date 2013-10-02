package com.bluefeather.flux.src.items;
/*
 * Copyright � 2013 BlueFeather Solutions LLC
 * All Rights Reserved.
 * 
 *  This file is part of The Fl�x Engine.
 *
 *  The Fl�x Engine is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Fl�x Engine is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with The Fl�x Engine.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.newdawn.slick.Color;

import com.bluefeather.flux.src.main.FluxMain;

public class ItemGem extends Item {
	public ItemGem(Color color) {
		super("Gem", color);
		texId = FluxMain.item_gem.getTextureID();
	}


	public ItemGem getInstance() {
		ItemGem n = new ItemGem(this.color);
		return n;
	}
	

}
