package bixstudio.sots.item;

import bixstudio.sots.ShadowsOfTheSilence;
import bixstudio.sots.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SHADOWS_OF_THE_SILENCE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ShadowsOfTheSilence.MOD_ID, "sots_tab"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.SPRAYED_WALL))
                    .displayName(Text.translatable("itemgroups.sots.sots_tab"))
                    .entries(((displayContext, entries) ->{
                        entries.add(ModBlocks.SPRAYED_WALL);
                    }))
                    .build());

    public static void registerItemGroups(){
        ShadowsOfTheSilence.LOGGER.info("Registered Item Groups for " + ShadowsOfTheSilence.MOD_ID);
    }
}
