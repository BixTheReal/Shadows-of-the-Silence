package bixstudio.sots.block;

import bixstudio.sots.ShadowsOfTheSilence;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block SPRAYED_WALL = registerBlock("sprayed_wall",
            new SprayedWallBlock(AbstractBlock.Settings.create().strength(4.0f).sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ShadowsOfTheSilence.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(ShadowsOfTheSilence.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        ShadowsOfTheSilence.LOGGER.info("Registered Mod Blocks for " + ShadowsOfTheSilence.MOD_ID);
    }
}
