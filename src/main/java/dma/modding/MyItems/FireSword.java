package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FireSword extends ItemSword
{
	private final String name = "fireSword";
	
	public FireSword(ToolMaterial material)
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

			Vec3 looking = playerIn.getLookVec();
			if (looking != null) {
				double x = looking.xCoord*0.1D;
				double y = looking.yCoord*0.1D;
				double z = looking.zCoord*0.1D;
				EntitySmallFireball fireball = new EntitySmallFireball(worldIn, playerIn, x, y, z);
				fireball.accelerationX = x;
				fireball.accelerationY = y;
				fireball.accelerationZ = z;
				fireball.posY++;
				if (!playerIn.worldObj.isRemote){
					playerIn.worldObj.spawnEntityInWorld(fireball);
				}
				if (playerIn.xpCooldown < 1) {
					PotionEffect fireresistance = new PotionEffect(12, 100, 4, false, true);
					playerIn.addPotionEffect(fireresistance);
					playerIn.xpCooldown = 10; 
				}

			
		}
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
	
}