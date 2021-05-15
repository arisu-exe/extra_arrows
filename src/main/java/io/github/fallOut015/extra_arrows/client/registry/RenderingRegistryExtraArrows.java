package io.github.fallOut015.extra_arrows.client.registry;

import io.github.fallOut015.extra_arrows.client.renderer.entity.BombArrowRenderer;
import io.github.fallOut015.extra_arrows.client.renderer.entity.CappedArrowRenderer;
import io.github.fallOut015.extra_arrows.client.renderer.entity.FireArrowRenderer;
import io.github.fallOut015.extra_arrows.client.renderer.entity.IceArrowRenderer;
import io.github.fallOut015.extra_arrows.client.renderer.entity.ShockArrowRenderer;
import io.github.fallOut015.extra_arrows.entity.EntitiesExtraArrows;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class RenderingRegistryExtraArrows {
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntitiesExtraArrows.CAPPED_ARROW.get(), CappedArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesExtraArrows.FIRE_ARROW.get(), FireArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesExtraArrows.ICE_ARROW.get(), IceArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesExtraArrows.BOMB_ARROW.get(), BombArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitiesExtraArrows.SHOCK_ARROW.get(), ShockArrowRenderer::new);
    }
}