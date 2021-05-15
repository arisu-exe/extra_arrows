package io.github.fallOut015.extra_arrows.client.renderer.entity;

import io.github.fallOut015.extra_arrows.entity.projectile.BombArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BombArrowRenderer extends ArrowRenderer<BombArrowEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("extra_arrows", "textures/entity/projectiles/bomb_arrow.png");

    public BombArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(BombArrowEntity entity) {
        return TEXTURE;
    }
}