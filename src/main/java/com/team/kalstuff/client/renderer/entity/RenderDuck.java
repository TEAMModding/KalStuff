package com.team.kalstuff.client.renderer.entity;

import com.team.kalstuff.entity.EntityDuck;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDuck extends RenderLiving<EntityDuck>
{
	private static final ResourceLocation CHICKEN_TEXTURES = new ResourceLocation("kalstuff:textures/entity/duck.png");

    public RenderDuck(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
	@Override
	protected ResourceLocation getEntityTexture(EntityDuck entity) {
		return CHICKEN_TEXTURES;
	}
}