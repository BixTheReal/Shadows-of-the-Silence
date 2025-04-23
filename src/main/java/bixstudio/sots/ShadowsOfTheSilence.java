package bixstudio.sots;

import bixstudio.sots.block.ModBlocks;
import bixstudio.sots.item.ModItemGroups;
import bixstudio.sots.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShadowsOfTheSilence implements ModInitializer {
	public static final String MOD_ID = "sots";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}