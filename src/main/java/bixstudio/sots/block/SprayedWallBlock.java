package bixstudio.sots.block;

import bixstudio.sots.blockentity.SprayedWallBE;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class SprayedWallBlock extends BlockWithEntity {

    public SprayedWallBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SprayedWallBE(pos, state);
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }
}
