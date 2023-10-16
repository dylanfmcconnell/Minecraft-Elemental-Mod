package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IceIngot extends Item 
{
	private final String name = "iceIngot";
	
	public IceIngot()
	{
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public String getName()
	{
		return name;
	}
}