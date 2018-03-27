package com.team.kalstuff;

import com.team.kalstuff.client.renderer.entity.RenderDuck;
import com.team.kalstuff.entity.EntityDuck;
import com.team.kalstuff.item.KalStuffItems;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class StartupClientOnly {
	public static void preInitClientOnly(FMLPreInitializationEvent event)
	{	

	}
	
	public static void initClientOnly(FMLInitializationEvent event)
	{
		
	}
	 
	public static void postInitClientOnly(FMLPostInitializationEvent event)
	{
		
	}
	
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {

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
		registerItemRendering("wooden_round_shield");
		registerItemRendering("great_grape");
		registerItemRendering("wine");
		registerItemRendering("wine_bottle");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.WHITE.getMetadata(), "boxing_glove_white");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.ORANGE.getMetadata(), "boxing_glove_orange");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.MAGENTA.getMetadata(), "boxing_glove_magenta");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.LIGHT_BLUE.getMetadata(), "boxing_glove_light_blue");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.YELLOW.getMetadata(), "boxing_glove_yellow");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.LIME.getMetadata(), "boxing_glove_lime");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.PINK.getMetadata(), "boxing_glove_pink");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.GRAY.getMetadata(), "boxing_glove_gray");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.SILVER.getMetadata(), "boxing_glove_silver");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.CYAN.getMetadata(), "boxing_glove_cyan");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.PURPLE.getMetadata(), "boxing_glove_purple");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.BLUE.getMetadata(), "boxing_glove_blue");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.BROWN.getMetadata(), "boxing_glove_brown");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.GREEN.getMetadata(), "boxing_glove_green");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.RED.getMetadata(), "boxing_glove_red");
        registerItemRendering(KalStuffItems.boxing_glove, EnumDyeColor.BLACK.getMetadata(), "boxing_glove_black");

		
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
		ResourceLocation resource = new ResourceLocation("kalstuff", name);
		Item item = ForgeRegistries.ITEMS.getValue(resource);
		ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");
		
		ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
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
	private static void registerItemRendering(Item item, int subType, String identifier) {
		ModelResourceLocation modelResource = new ModelResourceLocation("kalstuff:" + identifier, "inventory");
		
		ModelLoader.setCustomModelResourceLocation(item, subType, modelResource);
	}    
}
