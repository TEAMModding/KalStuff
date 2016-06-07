package com.team.kalstuff;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CommandWorldGen extends CommandBase
{

	@Override
	public String getName() {
		return "worldgen";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 0;
    }

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "commands.worldgen.usage";
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		
		if (args.length != 7)
		{
			throw new WrongUsageException("commands.worldgen.usage", new Object[0]);
		}
		else 
		{
			BlockPos blockpos = func_175757_a(sender, args, 0, false);
            BlockPos blockpos1 = func_175757_a(sender, args, 3, false);
            
            BlockPos minBlockpos = new BlockPos(Math.min(blockpos.getX(), blockpos1.getX()), Math.min(blockpos.getY(), blockpos1.getY()), Math.min(blockpos.getZ(), blockpos1.getZ()));
            BlockPos maxBlockpos = new BlockPos(Math.max(blockpos.getX(), blockpos1.getX()), Math.max(blockpos.getY(), blockpos1.getY()), Math.max(blockpos.getZ(), blockpos1.getZ()));
            int j = (maxBlockpos.getX() - minBlockpos.getX() + 1) * (maxBlockpos.getY() - minBlockpos.getY() + 1) * (maxBlockpos.getZ() - minBlockpos.getZ() + 1);

            if (j > 32768)
            {
                throw new CommandException("commands.worldgen.tooManyBlocks", new Object[] {Integer.valueOf(j), Integer.valueOf(32768)});
            }
            else if (minBlockpos.getY() >= 0 && maxBlockpos.getY() < 256)
            {
                World world = sender.getEntityWorld();

                for (int k = minBlockpos.getZ(); k < maxBlockpos.getZ() + 16; k += 16)
                {
                    for (int l = minBlockpos.getX(); l < maxBlockpos.getX() + 16; l += 16)
                    {
                        if (!world.isBlockLoaded(new BlockPos(l, maxBlockpos.getY() - minBlockpos.getY(), k)))
                        {
                            throw new CommandException("commands.worldgen.outOfWorld", new Object[0]);
                        }
                    }
                }
                
                try {
                	DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("worldgen-export/" + args[6] + ".worldgen")));
                	for (int x = minBlockpos.getX(); x < maxBlockpos.getX(); x++)
                	{
                		for (int y = minBlockpos.getY(); y < maxBlockpos.getY(); y++)
                		{
                			for (int z = minBlockpos.getZ(); z < maxBlockpos.getZ(); z++)
                			{
                				BlockPos pos = new BlockPos(x - minBlockpos.getX(), y - minBlockpos.getY(), z - minBlockpos.getZ());
                            	out.writeInt(pos.getX());
                            	out.writeInt(pos.getY());
                            	out.writeInt(pos.getZ());
                            	out.writeInt(Block.getStateId(world.getBlockState(new BlockPos(x, y, z))));
                            }
                		}
                	}
                	out.close();
                }
                catch (IOException e)
                {
                     System.out.println("encountered an IO exception: " + e);
                }
            }
			notifyOperators(sender, this, "commands.worldgen.success", new Object[] {Integer.valueOf(blockpos.getX()), Integer.valueOf(blockpos.getY()), Integer.valueOf(blockpos.getZ()), Integer.valueOf(blockpos1.getX()), Integer.valueOf(blockpos1.getY()), Integer.valueOf(blockpos1.getZ())});
		}
	}

}
