package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class EarthSword extends ItemSword
{
	private final String name = "earthSword";
	
	public EarthSword(ToolMaterial material)
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
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.xpCooldown < 1) {
			PotionEffect absorbtion = new PotionEffect(22, 200, 4, false, true);
			playerIn.addPotionEffect(absorbtion);
			playerIn.xpCooldown = 200; 
		}
		return itemStackIn;
	}
}