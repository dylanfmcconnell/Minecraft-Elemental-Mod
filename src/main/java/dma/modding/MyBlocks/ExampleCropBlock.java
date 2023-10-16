package dma.modding.MyBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import dma.modding.Other.CropBlockBase;

public class ExampleCropBlock extends CropBlockBase
{
	private final String name = "exampleCropBlock";
	
	public ExampleCropBlock()
	{
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
	}
	
	@Override
	protected Item getSeed()
	{
		return ExampleCode.exampleCropItem;
	}
   
	@Override
	protected Item getCrop()
	{
		return ExampleCode.exampleCropItem;
	}
		
	public String getName()
	{
		return name;
	}
}