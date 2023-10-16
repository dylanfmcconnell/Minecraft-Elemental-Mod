package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExampleSword extends ItemSword
{
	private final String name = "exampleSword";
	
	public ExampleSword(ToolMaterial material)
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