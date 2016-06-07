package com.team;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
/**
* ClientProxy is used to set up the mod and start it running on normal minecraft. It contains all the code that should run on the
* client side only.
* For more background information see here http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
*/
public class ClientOnlyProxy extends CommonProxy
{
/**
* Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
*/
public void preInit()
{
super.preInit();
com.team.kalstuff.StartupClientOnly.preInitClientOnly();

}
/**
* Do your mod setup. Build whatever data structures you care about. Register recipes,
* send FMLInterModComms messages to other mods.
*/
public void init()
{
super.init();
com.team.kalstuff.StartupClientOnly.initClientOnly();

}
/**
* Handle interaction with other mods, complete your setup based on this.
*/
public void postInit()
{
super.postInit();
com.team.kalstuff.StartupClientOnly.postInitClientOnly();

}
@Override
public boolean playerIsInCreativeMode(EntityPlayer player) {
if (player instanceof EntityPlayerMP) {
EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
//return entityPlayerMP.theItemInWorldManager.isCreative();
return entityPlayerMP.isCreative();
} else if (player instanceof EntityPlayerSP) {
return Minecraft.getMinecraft().playerController.isInCreativeMode();
}
return false;
}
}
