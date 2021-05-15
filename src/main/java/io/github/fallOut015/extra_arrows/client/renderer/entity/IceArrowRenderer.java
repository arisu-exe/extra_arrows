package io.github.fallOut015.extra_arrows.client.renderer.entity;

import io.github.fallOut015.extra_arrows.entity.projectile.IceArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceArrowRenderer extends ArrowRenderer<IceArrowEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("extra_arrows", "textures/entity/projectiles/ice_arrow.png");

    public IceArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(IceArrowEntity entity) {
        return TEXTURE;
    }
}