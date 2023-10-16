package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SteelArmor extends ItemArmor
{
	private final String name = "steel";
	private String armorTypeName = "";
	
	public SteelArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
		
		switch (armorType)
		{
		case 0:
			armorTypeName = "Helmet";
			break;
			
		case 1:
			armorTypeName = "Chestplate";
			break;
			
		case 2:
			armorTypeName = "Leggings";
			break;
			
		case 3:
			armorTypeName = "Boots";
			break;
		}
		
		setUnlocalizedName(BaseMod.MODID + "_" + name + armorTypeName);
		setCreativeTab(CreativeTabs.tabCombat);
		
		GameRegistry.registerItem(this, (name + armorTypeName));
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (slot == 0 ||slot == 1 || slot == 3)
		{
			return (BaseMod.MODID + ":textures/models/armor/steel_layer_1.png");
		}
		else if (slot == 2)
		{
			return (BaseMod.MODID + ":textures/models/armor/steel_layer_2.png");
		}
		else
		{
			return null;
		}
	}

	public String getName()
	{
		return (name + armorTypeName);
	}
}