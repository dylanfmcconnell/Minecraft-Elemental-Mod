package dma.modding.Other;

import dma.modding.MyCode;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler {

	@SubscribeEvent
	public void onlivingUpdateEvent(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack weapon = player.getEquipmentInSlot(0);
			if (weapon != null && weapon.getItem().getUnlocalizedName().equals(MyCode.fireSword.getUnlocalizedName())){
				PotionEffect resist = new PotionEffect(12,1,2,true,false);
player.addPotionEffect(resist);
				
			}
		}
	}
}