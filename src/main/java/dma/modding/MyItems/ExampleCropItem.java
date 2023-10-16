package dma.modding.MyItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;
import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import dma.modding.Other.CropItemBase;

public class ExampleCropItem extends CropItemBase
{
	private final String name = "exampleCropItem";
	
	public ExampleCropItem()
	{
		super(1, 0.3f, ExampleCode.exampleCropBlock, Blocks.farmland);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(ExampleCode.exampleTab);
	}
	
	public String getName()
	{
		return name;
	}
}