package com.github.canisartorus.prospectorjournal;

// @author Alexander James 2019-03-24

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	private static final String PATCHES = "Optional Patches", POINTER = "Pointer", GENERAL = "general";

	public static Configuration tMainConfig;
	
	public static boolean bookOnly, needHUD, //makeBook = true, 
		trackRock, fortunateBoxes, smeltBoxes,
		allowSmelt, exportDwarf,
		applyPatches, patchHazMat, generateArmour,
		debug, makeBoxes
		;
	public static double arrowSize
		;
	public static int arrowX, arrowY
		;
	public static String[] HUDsList;
	
	public static void init(java.io.File configFile) {
//		boolean bDirty = false;
		if (tMainConfig == null) {
			tMainConfig = new Configuration(configFile);
//			bDirty = true;
		}
		tMainConfig.load();
		
//		ConfigHandler.makeBook = tMainConfig.getBoolean("Register_Notebook_true", "general", true, "Should the notebook item be registered. REQUIRES mod to be installed on the Server!");
		ConfigHandler.bookOnly = tMainConfig.getBoolean("DiageticMode_false", GENERAL, false, "If true only the Notebook can add sample locations, navigation only works while you are holding the Notebook, and the SuveyData screen can only be accessed by reading the Notebook.");
		ConfigHandler.needHUD = tMainConfig.getBoolean("HelmetHUD_false", GENERAL, false, "If the tracking arrow should only be visible when wearing headgear with an integrated HUD, instead of when carrying the notebook.");
		ConfigHandler.HUDsList = tMainConfig.getStringList("Available HUDs", GENERAL, new String[] {"glasses", "item.BiblioGlasses", "sonicglasses", "item.logisticHUDGlasses", "reactorcraft_item_goggles", "rotarycraft_item_iogoggles", "armor.goggles", "ItemGoggles", "magitechGoggles", "pneumaticHelmet", "naturalistHelmet"}, "The internal names of every piece of headgear that is considered have a HUD.");
		ConfigHandler.trackRock = tMainConfig.getBoolean("TrackStoneRocks_false", GENERAL, false, "Should indicator rocks for stone layer types be tracked? Normally non-ore rock data is discarded.");
		ConfigHandler.makeBoxes = tMainConfig.getBoolean("CreateSampleBags_true", GENERAL, false, "Register the sample bag and Smaple Box items to hold lots of Rocks. \n ACHTUNG! Currently very buggy.");
		ConfigHandler.fortunateBoxes = tMainConfig.getBoolean("FortuneHarvestRocks_true", GENERAL, true, "If the sample box and sample bag items should have built-in enchantments like a GT Tool.");
		ConfigHandler.smeltBoxes = tMainConfig.getBoolean("AutoSmeltRocks_false", GENERAL, false, "Will smaple boxes made of hot metals bake the rocks they contain?");
		
		ConfigHandler.allowSmelt = tMainConfig.getBoolean("Include smelting transform_true", "Ore Helper", true, "Chose if it should detect melting in a crucible as an allowed method to get a product from the ore. Disable to get only sluice / sifter / centrifuge by products.");
		ConfigHandler.exportDwarf = tMainConfig.getBoolean("ExportFile_false", "Ore Helper", false, "Set to true to export ore by product data to $instance$/ProspectorJournal/GT6_Geochemistry.json. \n I suggest excluding Smelting transforms for this.");
		
		ConfigHandler.arrowX = tMainConfig.getInt("Arrow X Coord_0", POINTER, 0, -512, 512, "Horizontal offset from screen centre of the navigation pointer.");
		ConfigHandler.arrowY = tMainConfig.getInt("Arrow Y Coord_0", POINTER, 0, -512, 512, "Vertical offset from screen centre of the navigation pointer.");
		ConfigHandler.arrowSize = tMainConfig.get(POINTER, "Arrow Scale_1", 1.0D, "Relative size of the navigation overlay pointer.", 0.01D, 4.0D).getDouble(1.0D);
		
		ConfigHandler.applyPatches = tMainConfig.getBoolean("ChangeGT_false", PATCHES, false, "Master switch for the section. Should any of the listed extensions to GT6 code be applied?");
		ConfigHandler.patchHazMat = tMainConfig.getBoolean("More_HazMat_Suits_true", PATCHES, true, "Register additional armour pieces as HazMat protection.");
		
		ConfigHandler.debug = tMainConfig.getBoolean("debug_logs_false", "Dbug", false, "");
		
		// XXX additional configs go inside here

		if( tMainConfig.hasChanged())
//		if (bDirty)
			tMainConfig.save();
		
//		if(!makeBook)
//			bookOnly = false;
	}
	

}