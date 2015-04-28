package com.team.kalstuff.structure;

import net.minecraft.block.*;
import net.minecraft.init.Blocks;

public class StructureHut extends Structure {
	
	
	public void create() {

		Block p = Blocks.planks;
		Block a = Blocks.air;
		
		this.addLayer(new Block[][]
			{	{p, p, a, p, p},
				{p, a, a, a, p},
				{p, a, a, a, p},
				{p, a, a, a, p},
				{p, p, p, p, p}	});
		
		this.addLayer(new Block[][]
			{	{p, p, a, p, p},
				{p, a, a, a, p},
				{p, a, a, a, p},
				{p, a, a, a, p},
				{p, p, p, p, p}	});
		
		this.addLayer(new Block[][] 
			{	{p, p, p, p, p},
				{p, p, p, p, p},
				{p, p, p, p, p},
				{p, p, p, p, p},
				{p, p, p, p, p}	});
	}

}
