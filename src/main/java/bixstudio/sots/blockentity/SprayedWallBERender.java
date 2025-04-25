package bixstudio.sots.blockentity;

import foundry.veil.api.client.render.rendertype.VeilRenderType;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.Resource;
import net.minecraft.scoreboard.ScoreboardCriterion;
import org.joml.Quaterniond;
import org.joml.Vector3f;

public class SprayedWallBERender implements BlockEntityRenderer<SprayedWallBE> {

    @Override
    public void render(SprayedWallBE entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

    }
}
