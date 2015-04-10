package com.team;
import net.minecraft.entity.player.EntityPlayer;
/**
* CommonProxy is used to set up the mod and start it running. It contains all the code that should run on both the
* Standalone client and the dedicated server.
* For more background information see here http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
*/
public abstract class CommonProxy {
/**
* Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
*/
public void preInit()
{
com.team.kalstuff.StartupCommon.preInitCommon();
}
/**
* Do your mod setup. Build whatever data structures you care about. Register recipes,
* send FMLInterModComms messages to other mods.
*/
public void init()
{
com.team.kalstuff.StartupCommon.initCommon();

}
/**
* Handle interaction with other mods, complete your setup based on this.
*/
public void postInit()
{
com.team.kalstuff.StartupCommon.postInitCommon();
}
// helper to determine whether the given player is in creative mode
// not necessary for most examples
abstract public boolean playerIsInCreativeMode(EntityPlayer player);
}
