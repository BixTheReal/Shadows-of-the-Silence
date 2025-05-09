package bixstudio.sots.render;

import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.post.PostPipeline;
import foundry.veil.api.client.render.post.PostProcessingManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;

public class ShaderManager {
    private static final Identifier VHS_SHADER = Identifier.of("sots", "vhs");
    private static boolean vhsEnabled = true;
    private static boolean registered = false;

    public static void initialize() {
        // Optional: Log or do other setup here if needed
    }

    private static void ensureRegistered() {
        if (registered) return;

        boolean added = VeilRenderSystem.renderer().getPostProcessingManager().add(VHS_SHADER);
        if (added) {
            System.out.println("VHS pipeline registered.");
            registered = true;
        } else {
            System.err.println("Failed to register VHS pipeline!");
        }
    }

    public static void toggleVhs() {
        vhsEnabled = !vhsEnabled;

        if (!vhsEnabled) {
            PostProcessingManager manager = VeilRenderSystem.renderer().getPostProcessingManager();
            manager.remove(VHS_SHADER);
            System.out.println("VHS pipeline removed.");
        } else {
            ensureRegistered();
        }
    }

    public static void updateVHSShader() {
        if (!vhsEnabled) return;

        ensureRegistered();

        MinecraftClient client = MinecraftClient.getInstance();
        int width = client.getWindow().getFramebufferWidth();
        int height = client.getWindow().getFramebufferHeight();

        PostProcessingManager manager = VeilRenderSystem.renderer().getPostProcessingManager();
        PostPipeline vhsPipeline = manager.getPipeline(VHS_SHADER);

        if (vhsPipeline != null) {
            RenderTickCounter tickCounter = client.getRenderTickCounter();

            float deltaTime = tickCounter.getTickDelta(true);

            assert client.world != null;
            float accumulatedTime = client.world.getTime() * deltaTime;

            vhsPipeline.setFloat("time", accumulatedTime);
            vhsPipeline.setFloat("resolutionX", (float) width);
            vhsPipeline.setFloat("resolutionY", (float) height);

            manager.runPipeline(vhsPipeline);
        }
    }
}