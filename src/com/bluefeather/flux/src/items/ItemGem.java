package com.bluefeather.flux.src.items;
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
import org.lwjgl.util.vector.Vector3f;

import com.bluefeather.flux.src.main.FluxMain;
import com.bluefeather.flux.src.utils.EnumColor;

public class ItemGem extends Item {

	public EnumColor color;
	public ItemGem(EnumColor color) {
		super("Gem");
		this.color = color;
		texId = FluxMain.item_gem.getTextureID();
	}


	public ItemGem getInstance() {
		ItemGem n = new ItemGem(this.color);
		return n;
	}
	

}
