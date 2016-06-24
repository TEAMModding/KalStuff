package com.team.kalstuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupClientOnly 
{
	public static void preInitClientOnly()
	{
		
	}
	
	public static void initClientOnly()
	{
		registerItemRendering("blockBridge");
		registerItemRendering("itemEnderPowder");
		registerItemRendering("itemCoffee");
		registerItemRendering("itemCoffeeMug");
		registerItemRendering("blockEnder");
		registerItemRendering("itemTea");
		registerItemRendering("itemLightCoffee");
		registerItemRendering("blockBlaze");
		registerItemRendering("blockCarrot");
		registerItemRendering("blockApple");
		registerItemRendering("itemGoldenMug");
		registerItemRendering("itemJewelSoup");
		registerItemRendering("blockPotato");
		registerItemRendering("blockBakedPotato");
		registerItemRendering("blockMystery");
		registerItemRendering("blockChickenNest");
		registerItemRendering("itemBaconWand");
		registerItemRendering("itemChocolateCap");
		registerItemRendering("itemBaconCore");
		registerItemRendering("itemInfusedBaconCore");
		registerItemRendering("blockTrashCan");
		registerItemRendering("blockWildGrapeVine");
		registerItemRendering("itemGrapes");
		registerItemRendering("itemGrapeSeeds");
		registerItemRendering("blockGrapeVine");
		registerItemRendering("blockMoonFlower");
		registerItemRendering("blockMoonFlower1");
		registerItemRendering("blockMoonFlower2");
		registerItemRendering("blockMoonFlower3");
		registerItemRendering("blockMoonFlower4");
		registerItemRendering("blockMoonFlower5");
		registerItemRendering("itemBlazeSoup");
		registerItemRendering("itemWalkingStick");
		registerItemRendering("itemSodaCan");
		registerItemRendering("itemRootBeer");
		registerItemRendering("itemAppleSoda");
		registerItemRendering("itemMelonSoda");
		registerItemRendering("itemGrapeSoda");
	    registerItemRendering("itemClosedRootBeer");
		registerItemRendering("itemClosedAppleSoda");
		registerItemRendering("itemClosedMelonSoda");
		registerItemRendering("itemClosedGrapeSoda");
		registerItemRendering("blockBlockLockedChest");
		//from now on add itemRendering here
	}
	 
	public static void postInitClientOnly()
	{
		
	}
	
	/**Registers a new ItemModel.
	 * 
	 * Will only work if the itemModel json
	 * file has the same name as the registered
	 * blocks/items id.
	 * 
	 * @param name The itemModel/block name
	 */
	private static void registerItemRendering(String name)
	{
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.REGISTRY.getObject(new ResourceLocation("kalstuff", name)), 0, new ModelResourceLocation("kalstuff:" + name, "inventory"));
	}
}
