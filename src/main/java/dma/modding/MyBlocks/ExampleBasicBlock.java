package dma.modding.MyBlocks;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExampleBasicBlock extends Block 
{
	private final String name = "exampleBasicBlock";
	
    public ExampleBasicBlock ()
    {
    	super(Material.rock);
    	GameRegistry.registerBlock(this, name);
    	setUnlocalizedName(BaseMod.MODID + "_" + name);
    	setCreativeTab(ExampleCode.exampleTab);
    	setStepSound(soundTypeStone);
    }
    
	public String getName()
	{
		return name;
	}
}