package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LightningSword extends ItemSword
{
	private final String name = "lightningSword";
	
	public LightningSword(ToolMaterial material)
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
			Vec3 look = playerIn.getLookVec();
			MovingObjectPosition Coord = playerIn.rayTrace(300, 1);
			if(Coord != null && Coord.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK){
				EntityLightningBolt Lightning = new EntityLightningBolt(worldIn, 1, 1, 1);
				Lightning.setPosition(Coord.getBlockPos().getX(),Coord.getBlockPos().getY(),Coord.getBlockPos().getZ());
				worldIn.spawnEntityInWorld(Lightning);
			}
			if (!playerIn.capabilities.isCreativeMode){
			playerIn.xpCooldown = 60;
			}
		}
		return itemStackIn;
    }

}