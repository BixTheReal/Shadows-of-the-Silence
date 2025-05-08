package bixstudio.sots.blockentity;

import bixstudio.sots.ShadowsOfTheSilence;
import foundry.veil.api.client.render.rendertype.VeilRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class LightBlockBERender implements BlockEntityRenderer<LightBlockBE> {

    private final BlockRenderManager blockRenderManager;

    public LightBlockBERender(BlockEntityRendererFactory.Context context) {
        this.blockRenderManager = context.getRenderManager();
    }

    @Override
    public void render(LightBlockBE entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        matrices.push();

        World world = entity.getWorld();
        BlockPos pos = entity.getPos();
        BlockState state = entity.getCachedState();


        if (world != null && state != null) {
            BakedModel model = blockRenderManager.getModel(state);

            VertexConsumerProvider.Immediate immediate = (VertexConsumerProvider.Immediate) vertexConsumers;
            VertexConsumer vertexConsumer = immediate.getBuffer(VeilRenderType.get(Identifier.of(ShadowsOfTheSilence.MOD_ID, "light_block"), "sots:textures/block/light_block"));


            blockRenderManager.getModelRenderer().render(world, model, state, pos, matrices, vertexConsumer, false, world.random, 42, overlay);
        }

        matrices.pop();
    }
}
