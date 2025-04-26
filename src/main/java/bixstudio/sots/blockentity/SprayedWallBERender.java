package bixstudio.sots.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class SprayedWallBERender implements BlockEntityRenderer<SprayedWallBE> {

    private final BlockRenderManager blockRenderManager;

    public SprayedWallBERender(BlockEntityRendererFactory.Context context) {
        this.blockRenderManager = context.getRenderManager();
    }

    @Override
    public void render(SprayedWallBE entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        matrices.push();

        World world = entity.getWorld();
        BlockPos pos = entity.getPos();
        BlockState state = entity.getCachedState();

        if (world != null && state != null) {
            BakedModel model = blockRenderManager.getModel(state);

            RenderLayer renderLayer = RenderLayers.getBlockLayer(state);
            VertexConsumerProvider.Immediate immediate = (VertexConsumerProvider.Immediate) vertexConsumers;
            var vertexConsumer = immediate.getBuffer(renderLayer);

            blockRenderManager.getModelRenderer().render(world, model, state, pos, matrices, vertexConsumer, false, world.random, 42, overlay);
        }

        matrices.pop();
    }
}
