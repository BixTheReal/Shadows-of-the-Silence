package bixstudio.sots.keybinds;

import bixstudio.sots.render.ShaderManager;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindsManager {

    public static final KeyBinding toggleVhsShader = new KeyBinding(
            "key.backroomswanderer.toggle_vhs_shader",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "category.sots"
    );

    public static void register() {
        KeyBindingHelper.registerKeyBinding(toggleVhsShader);
    }


    public static boolean isVhsShaderTogglePressed() {
        return toggleVhsShader.wasPressed();
    }


    public static void handleVhsShaderToggle() {
        if (isVhsShaderTogglePressed()) {
            ShaderManager.toggleVhs();
        }
    }
}
