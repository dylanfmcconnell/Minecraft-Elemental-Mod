package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExampleSpade extends ItemSpade
{
	private final String name = "exampleSpade";
	
	public ExampleSpade(ToolMaterial material)
	{
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(ExampleCode.exampleTab);
	}
	
	public String getName()
	{
		return name;
	}
}