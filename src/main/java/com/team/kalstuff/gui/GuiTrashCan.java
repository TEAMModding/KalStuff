package com.team.kalstuff.gui;

import com.team.kalstuff.block.KalStuffBlocks;
import com.team.kalstuff.container.ContainerTrashCan;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiTrashCan extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation("kalstuff", "textures/gui/trash_can.png");
	private InventoryPlayer playerInv;
	public GuiTrashCan(InventoryPlayer playerInv)
	{
		super(new ContainerTrashCan(playerInv));
		this.playerInv = playerInv;
		xSize = 176;
		ySize = 133;
	}

	// Draws the gui image
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String name = I18n.format(KalStuffBlocks.TRASH_CAN.getUnlocalizedName() + ".name");
		fontRendererObj.drawString(name, xSize / 2 - fontRendererObj.getStringWidth(name) / 2, 6, 0x404040);
		fontRendererObj.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
	}
}
