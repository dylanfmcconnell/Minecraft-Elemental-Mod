package dma.modding.Other;

import java.util.Random;

import dma.modding.ExampleCode;
import dma.modding.MyCode;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ElementalOreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		// Runs 'generateNether' or 'generateSurface' depending on which dimension you're loading
		switch (world.provider.getDimensionId())
		{
			case -1:
				GenerateNether(world, random, chunkX*16, chunkZ*16);
				break;
			case 0:
				GenerateSurface(world, random, chunkX*16, chunkZ*16);
				break;
		}
	}
	
	public void GenerateSurface(World world, Random random, int x, int z)
	{
		this.AddOreSpawn(MyCode.elementalOre.getDefaultState(), world, random, x, z, 16, 16, 12, 3, 0, 63);
		this.AddOreSpawn(MyCode.elementalOre.getDefaultState(), world, random, x, z, 16, 16, 12, 3, 0, 63);
	}
	
	public void GenerateNether(World world, Random random, int x, int z)
	{
		// If you want to spawn this ore in the nether, add code similar to surface function
	}
	
	public void AddOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
	{
		for(int i = 0; i < chancesToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY -minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			BlockPos position = new BlockPos(posX, posY, posZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, position);
		}
	}
}