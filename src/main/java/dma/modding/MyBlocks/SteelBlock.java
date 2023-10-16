package dma.modding.MyBlocks;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SteelBlock extends Block 
{
	private final String name = "steelBlock";
	
    public SteelBlock ()
    {
    	super(Material.anvil);
    	GameRegistry.registerBlock(this, name);
    	setUnlocalizedName(BaseMod.MODID + "_" + name);
    	setCreativeTab(CreativeTabs.tabBlock);
    	setStepSound(soundTypeMetal);
    }
    
	public String getName()
	{
		return name;
	}
}