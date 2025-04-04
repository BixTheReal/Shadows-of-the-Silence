package bixstudio.sots.keybinds;

import bixstudio.sots.light.LightManager;
import bixstudio.sots.render.ShaderManager;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.lwjgl.glfw.GLFW;

public class KeyBindsManager {

    public static final KeyBinding toggleFlashlight = new KeyBinding(
            "key.sots.toggle_flashlight",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_F,
            "category.sots"
    );

    public static final KeyBinding toggleVhsShader = new KeyBinding(
            "key.sots.toggle_vhs_shader",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "category.sots"
    );




    public static void register() {
        KeyBindingHelper.registerKeyBinding(toggleFlashlight);
        KeyBindingHelper.registerKeyBinding(toggleVhsShader);
    }




    public static boolean isFlashlightTogglePressed() {
        return toggleFlashlight.wasPressed();
    }

    public static boolean isVhsShaderTogglePressed() {

        return toggleVhsShader.wasPressed();
    }




    public static void handleFlashlightToggle() {
        if (isFlashlightTogglePressed()) {
            ClientPlayerEntity player = MinecraftClient.getInstance().player;
            if (player != null) {
                LightManager.toggleDebugEnabled();
                LightManager.updateFlashlights();
            }
        }
    }

    public static void handleVhsShaderToggle() {
        if (isVhsShaderTogglePressed()) {
            ShaderManager.toggleVhs();
        }
    }
}
