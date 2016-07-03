package com.austinv11.peripheralsplusplus.init;

import com.austinv11.peripheralsplusplus.reference.Config;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
	public static void init() {
		if (Config.enableChatBox)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockChatBox),
					"GNG",
					"NDN",
					"GNG",
					'G', "ingotGold", 'N', new ItemStack(Blocks.NOTEBLOCK), 'D', "gemDiamond"));

		if (Config.enablePlayerSensor)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockPlayerSensor),
					"GRG",
					"EDE",
					"GRG",
					'G', "ingotGold", 'R', "dustRedstone", 'E', new ItemStack(Items.ENDER_EYE), 'D', "gemDiamond"));

		if (Config.enableEnvScanner)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockEnvScanner),
					"IEI",
					"RMR",
					"IRI",
					'I', "ingotIron", 'E', new ItemStack(Items.ENDER_EYE), 'R', "dustRedstone", 'M', Items.MAP));

		if (Config.enableOreDict)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockOreDict),
					"ISI",
					"SBS",
					"ISI",
					'I', "ingotIron", 'S', "stone", 'B', new ItemStack(Items.BOOK)));

		if (Config.enableSorter)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockSorter),
					"DPD",
					"PEP",
					"DPD", 'D', "gemDiamond", 'P', Blocks.PISTON, 'E', Items.ENDER_EYE));

		if (Config.enablePlayerInterface) {
			GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockPlayerInterface),
					"IPI",
					"INI",
					"IMI", 'i', new ItemStack(Items.IRON_INGOT), 'P', new ItemStack(ModItems.itemPermCard), 'N', new ItemStack(Items.NETHER_STAR), 'M', new ItemStack(GameRegistry.findBlock("ComputerCraft", "CC-Peripheral"), 1, 1));

			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemPermCard), new ItemStack(ModItems.itemPermCard));

			GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemPermCard), new ItemStack(Items.EMERALD), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.REDSTONE));
		}

		if (Config.enableIronNoteBlock)
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockIronNote),
					"IGI",
					"RNR",
					"IGI", 'I', "ingotIron", 'G', "ingotGold", 'R', "dustRedstone", 'N', Blocks.NOTEBLOCK));



	}
}
