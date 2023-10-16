package dma.modding;

// Java Imports
import java.util.List;






// Minecraft Imports
import net.minecraft.enchantment.Enchantment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

// Forge Imports
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;

// Block Imports
import dma.modding.MyBlocks.ExampleBasicBlock;
import dma.modding.MyBlocks.ExampleCropBlock;
import dma.modding.MyItems.ExampleArmor;
// Item Imports
import dma.modding.MyItems.ExampleBasicItem;
import dma.modding.MyItems.ExampleCropItem;
import dma.modding.MyItems.ExampleSpade;
import dma.modding.MyItems.ExampleSword;

// Ore Generator Imports
import dma.modding.Other.ExampleOreGenerator;

// Other Imports
import dma.modding.Other.ExampleCreativeTab;


public class ExampleCode
{
	// Block Declarations
	public static Block exampleBasicBlock;
	public static Block exampleCropBlock;
	
	// Material Declarations
	public static ToolMaterial exampleToolMaterial = EnumHelper.addToolMaterial("exampleToolMaterial", 3, 192, 5.0F, 1.5F, 12);
	public static ArmorMaterial exampleArmorMaterial = EnumHelper.addArmorMaterial("exampleArmorMaterial", "wurscht", 20, new int[] {6, 16, 12, 6}, 12);
		
	// Item Declarations
	public static Item exampleBasicItem;
	public static Item exampleCropItem;
	public static Item exampleSword;
	public static Item exampleSpade;
	public static ItemArmor exampleHelmet;
	public static ItemArmor exampleChestplate;
	public static ItemArmor exampleLeggings;
	public static ItemArmor exampleBoots;
	
	// Creative Tab Declarations
	public static CreativeTabs exampleTab = new ExampleCreativeTab(BaseMod.MODID);

	
	public static void CreateBlocks()
	{
		// Basic Block (Minecraft Example: stone)
		exampleBasicBlock = new ExampleBasicBlock();
		
		// Basic Crop/Plant (Minecraft Example: potato plant)
		exampleCropBlock = new ExampleCropBlock();
	}
	
	public static void CreateItems()
	{
		// Basic Item (Minecraft Example: stick)
		exampleBasicItem = new ExampleBasicItem();
		
		// Basic Seed/Food (Minecraft Example: potato)
		exampleCropItem = new ExampleCropItem();
		
		// Tools
		exampleSword = new ExampleSword(exampleToolMaterial);
		exampleSpade = new ExampleSpade(exampleToolMaterial);
		
		// Armor
		exampleHelmet = new ExampleArmor(exampleArmorMaterial, 0, 0);
		exampleChestplate = new ExampleArmor(exampleArmorMaterial, 0, 1);
		exampleLeggings = new ExampleArmor(exampleArmorMaterial, 0, 2);
		exampleBoots = new ExampleArmor(exampleArmorMaterial, 0, 3);
	}
	
	public static void CreateRecipes()
	{
		// Shapeless (Minecraft Example: 1 Log -> 4 Wood Planks)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 3), new Object[] { new ItemStack(Blocks.sapling)});
		
		// Shaped (Minecraft Example: 4 Planks -> Crafting Table)
		GameRegistry.addRecipe(new ItemStack(exampleBasicBlock, 3), new Object[]
		{
			"AAA",
			"ABA",
			"AAA",
			'A', exampleBasicItem,
			'B', Items.stick,
		});
		 
		// Smelting (Minecraft Example: Cobblestone + Furnace -> Stone)
		GameRegistry.addSmelting(exampleBasicItem, new ItemStack(Items.beef, 5), 5.0f);
		
		// Enchanting (Crafting an item with a default enchantment)
		ItemStack enchantedSword = new ItemStack(Items.diamond_sword);
		enchantedSword.addEnchantment(Enchantment.sharpness, 4);
		GameRegistry.addRecipe(enchantedSword, new Object[] 
		{
			"S", "R", 
			'S', Items.diamond_sword,
			'R', Items.redstone
		});
	}
	
	public static void RenderItems()
	{
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    
		// Blocks
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(exampleBasicBlock), 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleBasicBlock) exampleBasicBlock).getName(), "inventory"));
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(exampleCropBlock), 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleCropBlock) exampleCropBlock).getName(), "inventory"));
		
		// Items
    	renderItem.getItemModelMesher().register(ExampleCode.exampleBasicItem, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleBasicItem) exampleBasicItem).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleCropItem, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleCropItem) exampleCropItem).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleSword, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleSword) exampleSword).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleSpade, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleSpade) exampleSpade).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleHelmet, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleHelmet).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleChestplate, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleChestplate).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleLeggings, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleLeggings).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(ExampleCode.exampleBoots, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleBoots).getName(), "inventory"));
	}
}