package bixstudio.sots;

import bixstudio.sots.blockentity.ModBlockEntities;
import bixstudio.sots.blockentity.SprayedWallBERender;
import bixstudio.sots.keybinds.KeyBindsManager;
import bixstudio.sots.light.LightManager;
import bixstudio.sots.render.ShaderManager;
import foundry.veil.api.event.VeilRenderLevelStageEvent;
import foundry.veil.fabric.event.FabricVeilRenderLevelStageEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;


import java.util.UUID;

public class ShadowsOfTheSilenceClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBindsManager.register();
        ShaderManager.initialize();

        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> {
            UUID playerUuid = MinecraftClient.getInstance().getSession().getUuidOrNull();
            if (playerUuid == null) return;
            LightManager.onPlayerDisconnected(playerUuid);
        });

        ClientPlayConnectionEvents.JOIN.register((handler, client, isFirstJoin) -> {
            UUID playerUuid = MinecraftClient.getInstance().getSession().getUuidOrNull();
            if (playerUuid != null) {
                LightManager.onPlayerRejoined(playerUuid);
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            KeyBindsManager.handleFlashlightToggle();
            KeyBindsManager.handleVhsShaderToggle();
            LightManager.removeInactiveFlashlights();
        });

        FabricVeilRenderLevelStageEvent.EVENT.register((stage, levelRenderer, bufferSource, matrixStack, frustumMatrix, projectionMatrix, renderTick, deltaTracker, camera, frustum) -> {
            if (stage == VeilRenderLevelStageEvent.Stage.AFTER_LEVEL) {
                LightManager.updateFlashlights();
                ShaderManager.updateVHSShader();
            }
        });
    }
}