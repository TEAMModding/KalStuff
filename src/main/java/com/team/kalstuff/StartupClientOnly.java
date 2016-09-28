package com.team.kalstuff;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class StartupClientOnly 
{
	public static void preInitClientOnly()
	{
		
	}
	
	public static void initClientOnly()
	{
		registerItemRendering("bridge");
		registerItemRendering("crushed_ender");
		registerItemRendering("coffee");
		registerItemRendering("coffee_mug");
		registerItemRendering("ender_block");
		registerItemRendering("tea");
		registerItemRendering("light_coffee");
		registerItemRendering("blaze_block");
		registerItemRendering("carrot_block");
		registerItemRendering("apple_block");
		registerItemRendering("golden_mug");
		registerItemRendering("jewel_soup");
		registerItemRendering("potato_block");
		registerItemRendering("baked_potato_block");
		registerItemRendering("chicken_nest");
		registerItemRendering("bacon_wand");
		registerItemRendering("chocolate_cap");
		registerItemRendering("bacon_core");
		registerItemRendering("infused_bacon_core");
		registerItemRendering("trash_can");
		registerItemRendering("wild_grape_vine");
		registerItemRendering("grapes");
		registerItemRendering("grape_seeds");
		registerItemRendering("plantable_grape_seeds");
		registerItemRendering("grape_vine");
		registerItemRendering("moon_flower");
		registerItemRendering("moon_flower1");
		registerItemRendering("moon_flower2");
		registerItemRendering("moon_flower3");
		registerItemRendering("moon_flower4");
		registerItemRendering("moon_flower5");
		registerItemRendering("blaze_soup");
		registerItemRendering("walking_stick");
		registerItemRendering("soda_can");
		registerItemRendering("root_beer");
		registerItemRendering("apple_soda");
		registerItemRendering("melon_soda");
		registerItemRendering("grape_soda");
	    registerItemRendering("closed_root_beer");
		registerItemRendering("closed_apple_soda");
		registerItemRendering("closed_melon_soda");
		registerItemRendering("closed_grape_soda");
		registerItemRendering("iron_dagger");
		registerItemRendering("wooden_dagger");
		registerItemRendering("stone_dagger");
		registerItemRendering("diamond_dagger");
		registerItemRendering("golden_dagger");
		registerItemRendering("round_wooden_shield");
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
