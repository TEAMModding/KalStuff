package com.team.kalstuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StartupClientOnly 
{
	public static void preInitClientOnly()
	{
		KeyBinding binding = new KeyBinding("key.kalstuff.test", 37, "key.categories.kalstuff");
		ClientRegistry.registerKeyBinding(binding);
	}
	
	public static void initClientOnly()
	{
		registerItemRendering("blockBridge");
		registerItemRendering("itemEnderPowder");
		registerItemRendering("itemCoffee");
		registerItemRendering("itemCoffeeMug");
		registerItemRendering("blockSquidMat");
		registerItemRendering("blockEnder");
		registerItemRendering("itemTea");
		registerItemRendering("itemLightCoffee");
		registerItemRendering("blockBlaze");
		registerItemRendering("blockCarrot");
		registerItemRendering("blockApple");
		registerItemRendering("itemGoldenMug");
		registerItemRendering("itemJewelSoup");
		registerItemRendering("blockPotato");
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
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(GameRegistry.findItem("kalstuff", name), 0, new ModelResourceLocation("kalstuff:" + name, "inventory"));
	}
}
