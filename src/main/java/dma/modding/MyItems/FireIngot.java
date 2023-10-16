package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FireIngot extends Item 
{
	private final String name = "fireIngot";
	
	public FireIngot()
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