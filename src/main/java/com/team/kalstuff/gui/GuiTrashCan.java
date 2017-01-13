package com.team.kalstuff.gui;

import java.awt.Color;

import com.team.kalstuff.container.ContainerTrashCan;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiTrashCan extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation("kalstuff", "textures/gui/trash_can.png");
	
	public GuiTrashCan(InventoryPlayer invPlayer) {
		super(new ContainerTrashCan(invPlayer));
		xSize = 176;
		ySize = 133;
	}

	//Draws the gui image
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	
	//Draws the text at the top
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		fontRendererObj.drawString(I18n.format("tile.trashCan.name", new Object[0]), 60, 5, Color.darkGray.getRGB());
	}
}
