package dma.modding;
import dma.modding.MyBlocks.ElementalOre;
// Imports Go Here
import dma.modding.MyBlocks.SteelBlock;
import dma.modding.MyItems.SteelPipe;
import dma.modding.MyItems.EarthIngot;
import dma.modding.MyItems.EarthSword;
import dma.modding.MyItems.ElementalArmor;
import dma.modding.MyItems.ElementalIngot;
import dma.modding.MyItems.FireIngot;
import dma.modding.MyItems.FireSword;
import dma.modding.MyItems.IceIngot;
import dma.modding.MyItems.IceSword;
import dma.modding.MyItems.LightningIngot;
import dma.modding.MyItems.LightningSword;
import dma.modding.MyItems.SteelArmor;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

// Class
public class MyCode
{
	// Declarations Go Here
	public static Block steelBlock;
	public static Item steelPipe;
	public static ArmorMaterial steelArmorMaterial =
		EnumHelper.addArmorMaterial("steelArmorMaterial", "What", 200, new int[]
				{0, 0, 0, 0} , 15);
	public static ArmorMaterial elementalArmorMaterial =
			EnumHelper.addArmorMaterial("elementalArmorMaterial", "suh", 200, new int[]
					{ 4, 9, 7, 4 } , 15);
	public static ToolMaterial earthMaterial =
			EnumHelper.addToolMaterial("earthMaterial", 0, 10000, 0, 2.0F, 15);
	public static ToolMaterial fireMaterial =
			EnumHelper.addToolMaterial("fireMaterial", 0, 1000, 0, 4.0F, 15);
	public static ToolMaterial iceMaterial =
			EnumHelper.addToolMaterial("iceMaterial", 0, 20, 0, 3.0F, 15);
	public static ToolMaterial lightningMaterial =
			EnumHelper.addToolMaterial("lightningMaterial", 0, 5000, 0, 6.0F, 15);
	public static ItemArmor steelHelmet;
	public static ItemArmor steelChestPlate;
	public static ItemArmor steelLeggings;
	public static ItemArmor steelBoots;
	public static ItemArmor elementalHelmet;
	public static ItemArmor elementalChestplate;
	public static ItemArmor elementalLeggings;
	public static ItemArmor elementalBoots;
	public static Block elementalOre;
	public static Item elementalIngot;
	public static Item earthIngot;
	public static Item fireIngot;
	public static Item iceIngot;
	public static Item lightningIngot;
	public static Item earthSword;
	public static Item fireSword;
	public static Item iceSword;
	public static Item lightningSword;
	
	// Functions
	public static void CreateBlocks()
	{
		steelBlock = new SteelBlock();
		elementalOre = new ElementalOre();
		
	}
	
	public static void CreateItems()
	{
		elementalIngot = new ElementalIngot();
		earthIngot = new EarthIngot();
		fireIngot = new FireIngot();
		iceIngot = new IceIngot();
		lightningIngot = new LightningIngot();
		steelPipe = new SteelPipe();
		steelHelmet = new SteelArmor(steelArmorMaterial, 0, 0);
		steelChestPlate = new SteelArmor(steelArmorMaterial, 0, 1);
		steelLeggings = new SteelArmor(steelArmorMaterial, 0, 2);
		steelBoots = new SteelArmor(steelArmorMaterial, 0, 3);
		elementalHelmet = new ElementalArmor(elementalArmorMaterial, 0, 0);
		elementalChestplate = new ElementalArmor(elementalArmorMaterial, 0, 1);
		elementalLeggings = new ElementalArmor(elementalArmorMaterial, 0, 2);
		elementalBoots = new ElementalArmor(elementalArmorMaterial, 0, 3);
		earthSword = new EarthSword(earthMaterial);
		fireSword = new FireSword(fireMaterial);
		iceSword = new IceSword(iceMaterial);
		lightningSword = new LightningSword(lightningMaterial);
		
	}
	
	public static void CreateRecipes()
	{
		//USELESS STUFF:
		
		GameRegistry.addShapelessRecipe(
				//output
				new ItemStack(Blocks.gold_block), 
				//input
				new Object[] {new ItemStack(Blocks.dirt)});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(Items.blaze_rod, 4),
				new Object[] {
						"  A",
						" A ",
						"A  ",
						'A', Items.gold_ingot});
		
		ItemStack enchItem = new ItemStack(Items.iron_chestplate);
		enchItem.addEnchantment(Enchantment.thorns, 9999);
		GameRegistry.addSmelting(Items.iron_chestplate, enchItem, 0.01F);

		ItemStack enchItem2 = new ItemStack(Items.diamond_sword);
		enchItem2.addEnchantment(Enchantment.sharpness, 9001);
		enchItem2.addEnchantment(Enchantment.fireAspect, 9001);
		enchItem2.addEnchantment(Enchantment.looting, 9001);
		enchItem2.setStackDisplayName("sUpeR sWord");
		GameRegistry.addShapedRecipe(
				(enchItem2), 
				new Object[] {
						"ABA",
						"BCB",
						"ABA",
						'A', Items.nether_star,
						'B', Items.blaze_powder,
						'C', Items.diamond_sword});
		
		//THE ACTUAL MOD:
		
		GameRegistry.addSmelting(elementalOre, new ItemStack(elementalIngot), 5.0F);
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(earthIngot), 
				new Object[] 
						{new ItemStack(Blocks.obsidian), new ItemStack(elementalIngot)});
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(fireIngot), 
				new Object[] 
						{new ItemStack(Items.blaze_rod, 8), new ItemStack(elementalIngot)});
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(iceIngot), 
				new Object[] 
						{new ItemStack(Blocks.ice), new ItemStack(elementalIngot)});
		
		GameRegistry.addShapelessRecipe(
				new ItemStack(lightningIngot), 
				new Object[] 
						{new ItemStack(Items.skull), new ItemStack(elementalIngot)});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(earthSword),
				new Object[] {
						" A ",
						" A ",
						" B ",
						'A', earthIngot,
						'B', Items.stick});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(fireSword),
				new Object[] {
						" A ",
						" A ",
						" B ",
						'A', fireIngot,
						'B', Items.stick});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(iceSword),
				new Object[] {
						" A ",
						" A ",
						" B ",
						'A', iceIngot,
						'B', Items.stick});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(lightningSword),
				new Object[] {
						" A ",
						" A ",
						" B ",
						'A', lightningIngot,
						'B', Items.stick});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(elementalHelmet),
				new Object[] {
						"ABC",
						"D A",
						"   ",
						'A', earthIngot,
						'B', fireIngot,
						'C', iceIngot,
						'D', lightningIngot,
						});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(elementalChestplate),
				new Object[] {
						"A B",
						"CDA",
						"BCD",
						'A', earthIngot,
						'B', fireIngot,
						'C', iceIngot,
						'D', lightningIngot,
						});
		
		GameRegistry.addShapedRecipe(
				new ItemStack(elementalLeggings),
				new Object[] {
						"ABC",
						"D A",
						"B C",
						'A', earthIngot,
						'B', fireIngot,
						'C', iceIngot,
						'D', lightningIngot,
						});
		GameRegistry.addShapedRecipe(
				new ItemStack(elementalBoots),
				new Object[] {
						"   ",
						"A B",
						"C D",
						'A', earthIngot,
						'B', fireIngot,
						'C', iceIngot,
						'D', lightningIngot,
						});
		GameRegistry.addShapedRecipe(
				new ItemStack(elementalBoots),
				new Object[] {
						"A B",
						"C D",
						"   ",
						'A', earthIngot,
						'B', fireIngot,
						'C', iceIngot,
						'D', lightningIngot,
						});
		
		
	}
	
	public static void RenderItems()
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(steelBlock), 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((SteelBlock) steelBlock).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(steelPipe, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((SteelPipe) steelPipe).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(steelHelmet, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((SteelArmor) steelHelmet).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(steelChestPlate, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((SteelArmor) steelChestPlate).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(steelLeggings, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((SteelArmor) steelLeggings).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(steelBoots, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((SteelArmor) steelBoots).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(elementalHelmet, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ElementalArmor) elementalHelmet).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(elementalChestplate, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ElementalArmor) elementalChestplate).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(elementalLeggings, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ElementalArmor) elementalLeggings).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(elementalBoots, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ElementalArmor) elementalBoots).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(elementalOre), 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ElementalOre) elementalOre).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(elementalIngot, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ElementalIngot) elementalIngot).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(earthIngot, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((EarthIngot) earthIngot).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(fireIngot, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((FireIngot) fireIngot).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(iceIngot, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((IceIngot) iceIngot).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(lightningIngot, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((LightningIngot) lightningIngot).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(earthSword, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((EarthSword) earthSword).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(fireSword, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((FireSword) fireSword).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(iceSword, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((IceSword) iceSword).getName(), "inventory"));
		
		renderItem.getItemModelMesher().register(lightningSword, 
				0, new ModelResourceLocation(BaseMod.MODID + ":" + ((LightningSword) lightningSword).getName(), "inventory"));
	}
	
	
	
	
	
}