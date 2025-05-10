package bixstudio.sots.blockentity;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.light.PointLight;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.joml.Vector3d;


public class LightBlockBE extends BlockEntity implements BlockEntityTicker {

    public PointLight pointLight;

    public LightBlockBE(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LIGHT_BLOCK_BE, pos, state);
    }

    @Override
    public void tick(World world, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (world == null || !world.isClient) return;

        if (pointLight == null){
            pointLight = new PointLight();
            pointLight.setPosition(new Vector3d(pos.getX(), pos.getY() - 1, pos.getZ()));
            pointLight.setColor(0xFFFFBB33);
            pointLight.setBrightness(2f);
            VeilRenderSystem.renderer().getLightRenderer().addLight(pointLight);
        }
    }

    @Override
    public void markRemoved() {
        super.markRemoved();
        if (pointLight != null) {
            VeilRenderSystem.renderer().getLightRenderer().removeLight(pointLight);
            pointLight = null;
        }
    }
}
