package com.team.kalstuff.proxy;

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
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent e)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class,
				manager -> new RenderDuck(manager, new ModelChicken(), 0.3F));

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

		// getDyeDamage returns the actual metadata for dyes - not getMetadata,
		// strangely
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.WHITE.getDyeDamage(), "boxing_glove_white");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.ORANGE.getDyeDamage(), "boxing_glove_orange");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.MAGENTA.getDyeDamage(), "boxing_glove_magenta");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.LIGHT_BLUE.getDyeDamage(),
				"boxing_glove_light_blue");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.YELLOW.getDyeDamage(), "boxing_glove_yellow");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.LIME.getDyeDamage(), "boxing_glove_lime");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.PINK.getDyeDamage(), "boxing_glove_pink");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.GRAY.getDyeDamage(), "boxing_glove_gray");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.SILVER.getDyeDamage(), "boxing_glove_silver");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.CYAN.getDyeDamage(), "boxing_glove_cyan");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.PURPLE.getDyeDamage(), "boxing_glove_purple");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.BLUE.getDyeDamage(), "boxing_glove_blue");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.BROWN.getDyeDamage(), "boxing_glove_brown");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.GREEN.getDyeDamage(), "boxing_glove_green");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.RED.getDyeDamage(), "boxing_glove_red");
		registerItemRendering(KalStuffItems.BOXING_GLOVE, EnumDyeColor.BLACK.getDyeDamage(), "boxing_glove_black");

	}

	/**
	 * Registers a new ItemModel.
	 * 
	 * Will only work if the itemModel json file has the same name as the registered
	 * blocks/items id.
	 * 
	 * @param name
	 *            The itemModel/block name
	 */
	private static void registerItemRendering(String name)
	{
		ResourceLocation resource = new ResourceLocation("kalstuff", name);
		Item item = ForgeRegistries.ITEMS.getValue(resource);
		ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");

		ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
	}

	/**
	 * Registers a new ItemModel.
	 * 
	 * You must specify the Item object, the metadata, and the String name of the
	 * item.
	 * 
	 * @param itm
	 *            The Item object you wish to register
	 * @param subType
	 *            The metadata of the item
	 * @param identifier
	 *            The string name of the item
	 */
	private static void registerItemRendering(Item item, int subType, String identifier)
	{
		ModelResourceLocation modelResource = new ModelResourceLocation("kalstuff:" + identifier, "inventory");
		ModelLoader.setCustomModelResourceLocation(item, subType, modelResource);
	}
}
