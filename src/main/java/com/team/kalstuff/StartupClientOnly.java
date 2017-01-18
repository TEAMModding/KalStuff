package com.team.kalstuff;

import com.team.kalstuff.client.renderer.entity.RenderDuck;
import com.team.kalstuff.entity.EntityDuck;
import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class StartupClientOnly {
	public static void preInitClientOnly() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class, manager -> new RenderDuck(manager, new ModelChicken(), 0.3F));
		
		registerItemRendering("bridge");
		registerItemRendering("crushed_ender");
		registerItemRendering("coffee");
		registerItemRendering("coffee_mug");
		registerItemRendering("ender_block");
		registerItemRendering("tea");
		registerItemRendering("light_coffee");
		registerItemRendering("lute");
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
		//registerItemRendering("round_wooden_shield");
		registerItemRendering("great_grape");
		registerItemRendering("wine");
		registerItemRendering("wine_bottle");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.BLACK.getDyeDamage(), "boxing_glove_black");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.RED.getDyeDamage(), "boxing_glove_red");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.GREEN.getDyeDamage(), "boxing_glove_green");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.BROWN.getDyeDamage(), "boxing_glove_brown");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.BLUE.getDyeDamage(), "boxing_glove_blue");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.PURPLE.getDyeDamage(), "boxing_glove_purple");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.CYAN.getDyeDamage(), "boxing_glove_cyan");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.SILVER.getDyeDamage(), "boxing_glove_silver");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.GRAY.getDyeDamage(), "boxing_glove_gray");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.PINK.getDyeDamage(), "boxing_glove_pink");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.LIME.getDyeDamage(), "boxing_glove_lime");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.YELLOW.getDyeDamage(), "boxing_glove_yellow");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.LIGHT_BLUE.getDyeDamage(), "boxing_glove_light_blue");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.MAGENTA.getDyeDamage(), "boxing_glove_magenta");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.ORANGE.getDyeDamage(), "boxing_glove_orange");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.WHITE.getDyeDamage(), "boxing_glove_white");
        //from now on add itemRendering here
	}
	
	public static void initClientOnly() {
		
	}
	 
	public static void postInitClientOnly() {
		
	}
	
	/**Registers a new ItemModel.
	 * 
	 * Will only work if the itemModel json
	 * file has the same name as the registered
	 * blocks/items id.
	 * 
	 * @param name The itemModel/block name
	 */
	private static void registerItemRendering(String name) {
		ModelLoader.setCustomModelResourceLocation(Item.REGISTRY.getObject(new ResourceLocation("kalstuff", name)), 0, new ModelResourceLocation("kalstuff:" + name, "inventory"));
	}
	
	/**Registers a new ItemModel.
	 * 
	 * You must specify the Item object,
	 * the metadata, and the String name of
	 * the item.
	 * 
	 * @param itm The Item object you wish to register
	 * @param subType The metadata of the item
	 * @param identifier The string name of the item
	 */
	private static void registerItemRendering(Item itm, int subType, String identifier) {
		ModelLoader.setCustomModelResourceLocation(itm, subType, new ModelResourceLocation("kalstuff:" + identifier, "inventory"));
	}    
}
