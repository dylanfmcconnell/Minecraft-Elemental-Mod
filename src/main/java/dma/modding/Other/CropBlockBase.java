package dma.modding.Other;

import java.util.Random;

import dma.modding.ExampleCode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CropBlockBase extends BlockCrops
{
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
	{
      return EnumWorldBlockLayer.CUTOUT; 
    }
   
	public boolean isFullCube()
	{
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }
   
    @Override
   	protected boolean canPlaceBlockOn(Block ground)
    {
        return ground == Blocks.farmland;
    }
   
   	public CropBlockBase()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        float f = 0.5F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
        this.setCreativeTab((CreativeTabs)null);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
        this.disableStats();
    }
   
   	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
	    return EnumPlantType.Plains;
	}
}