package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SteelPipe extends Item 
{
	private final String name = "steelPipe";
	
	public SteelPipe()
	{
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(ExampleCode.exampleTab);
	}
	
	public String getName()
	{
		return name;
	}
}