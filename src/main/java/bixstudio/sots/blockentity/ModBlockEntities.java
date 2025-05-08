package bixstudio.sots.blockentity;

import bixstudio.sots.ShadowsOfTheSilence;
import bixstudio.sots.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static BlockEntityType<SprayedWallBE> SPRAYED_WALL_BE;
    public static BlockEntityType<LightBlockBE> LIGHT_BLOCK_BE;

    public static void registerModBlockEntities() {
        SPRAYED_WALL_BE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(ShadowsOfTheSilence.MOD_ID, "sprayed_wall"),
                FabricBlockEntityTypeBuilder.create(SprayedWallBE::new, ModBlocks.SPRAYED_WALL).build(null)
        );
        LIGHT_BLOCK_BE = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(ShadowsOfTheSilence.MOD_ID, "light_block"),
                FabricBlockEntityTypeBuilder.create(LightBlockBE::new, ModBlocks.LIGHT_BLOCK).build(null)
        );
    }
}
