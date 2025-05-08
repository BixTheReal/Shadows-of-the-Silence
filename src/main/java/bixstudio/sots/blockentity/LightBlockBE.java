package bixstudio.sots.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class LightBlockBE extends BlockEntity {

    public LightBlockBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LIGHT_BLOCK_BE, pos, state);
    }
}
