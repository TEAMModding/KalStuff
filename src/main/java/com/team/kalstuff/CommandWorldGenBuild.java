package com.team.kalstuff;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

import net.minecraft.block.Block;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CommandWorldGenBuild extends CommandBase 
{

	@Override
	public String getName() {
		return "worldgenbuild";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 0;
    }

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "commands.worldgenbuild.usage";
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		if (args.length != 4)
		{
			throw new WrongUsageException("commands.worldgenbuild.usage", new Object[0]);
		}
		else
		{
			BlockPos blockpos = func_175757_a(sender, args, 0, false);
			String file = args[3] + ".worldgen";
			World world = sender.getEntityWorld();
			try {
				build(blockpos, file, world);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void build(BlockPos pos, String file, World world) throws IOException
	{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		try {
			while (true) {
				int x = in.readInt();
				int y = in.readInt();
				int z = in.readInt();
				int id = in.readInt();
				
				world.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()), Block.getStateById(id), 2);
			}
		}
		catch (EOFException e)
		{
			in.close();
		}
	}
}
