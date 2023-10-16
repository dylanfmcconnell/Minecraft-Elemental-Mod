package dma.modding.MyBlocks;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ElementalOre extends Block 
{
	private final String name = "elementalOre";
	
    public ElementalOre ()
    {
    	super(Material.rock);
    	GameRegistry.registerBlock(this, name);
    	setUnlocalizedName(BaseMod.MODID + "_" + name);
    	setCreativeTab(CreativeTabs.tabBlock);
    	setStepSound(soundTypeStone);
    	setHardness(4);
    	setResistance(6000.0F);
    	setHarvestLevel("pickaxe", 2);
    }
    
	public String getName()
	{
		return name;
	}
}