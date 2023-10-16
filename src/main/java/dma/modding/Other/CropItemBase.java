package dma.modding.Other;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class CropItemBase extends ItemSeedFood implements IPlantable
{
	// Block ID of the actual crop which is planted.
    private final Block associatedCropBlock;
    // Block ID of the soil this seed food should be planted on.
    private final Block soilId;

    public CropItemBase(int parHealAmount, float parSaturationModifier, Block parBlockPlant, Block parSoilBlock)
    {
        super(parHealAmount, parSaturationModifier, parBlockPlant, parSoilBlock);
        associatedCropBlock = parBlockPlant;
        soilId = parSoilBlock;
    }

    public Block getSoilId() 
    {
        return soilId;
    }

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return associatedCropBlock.getDefaultState();
	}
}