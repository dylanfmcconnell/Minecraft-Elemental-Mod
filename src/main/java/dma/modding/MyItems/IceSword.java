package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IceSword extends ItemSword
{
	private final String name = "iceSword";
	
	public IceSword(ToolMaterial material)
	{
		super(material);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabCombat);
		
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker){
		PotionEffect freeze = new PotionEffect(2, 100, 2, false, true);
		target.addPotionEffect(freeze);
		stack.damageItem(1, attacker);
		setMaxStackSize(16);
		return true;
	}
	
}