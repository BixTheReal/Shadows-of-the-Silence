package bixstudio.sots.block;

import bixstudio.sots.blockentity.LightBlockBE;
import bixstudio.sots.blockentity.SprayedWallBE;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class LightBlockBlock extends BlockWithEntity {

    public LightBlockBlock(Settings settings) {
        super(settings);
    }

    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LightBlockBE(pos, state);
    }

    public boolean hasBlockEntity(BlockState state) {
        return true;
    }
}
