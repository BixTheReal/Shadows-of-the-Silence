package bixstudio.sots.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class SprayedWallBE extends BlockEntity {

    public SprayedWallBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPRAYED_WALL_BE, pos, state);
    }
}
