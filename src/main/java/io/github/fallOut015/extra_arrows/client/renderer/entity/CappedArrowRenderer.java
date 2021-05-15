package io.github.fallOut015.extra_arrows.client.renderer.entity;

import io.github.fallOut015.extra_arrows.entity.projectile.CappedArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CappedArrowRenderer extends ArrowRenderer<CappedArrowEntity> {
    private static final ResourceLocation RESOURCE_LOCATION_WOOD = new ResourceLocation("extra_arrows", "textures/entity/projectiles/wooden_capped_arrow.png");
    private static final ResourceLocation RESOURCE_LOCATION_STONE = new ResourceLocation("extra_arrows", "textures/entity/projectiles/stone_capped_arrow.png");
    private static final ResourceLocation RESOURCE_LOCATION_GOLD = new ResourceLocation("extra_arrows", "textures/entity/projectiles/golden_capped_arrow.png");
    private static final ResourceLocation RESOURCE_LOCATION_IRON = new ResourceLocation("extra_arrows", "textures/entity/projectiles/iron_capped_arrow.png");
    private static final ResourceLocation RESOURCE_LOCATION_DIAMOND = new ResourceLocation("extra_arrows", "textures/entity/projectiles/diamond_capped_arrow.png");
    private static final ResourceLocation RESOURCE_LOCATION_NETHERITE = new ResourceLocation("extra_arrows", "textures/entity/projectiles/netherite_capped_arrow.png");

    private static final Map<IItemTier, ResourceLocation> RESOURCE_FOR_ARROW_TIER = new HashMap<IItemTier, ResourceLocation>();

    public CappedArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(CappedArrowEntity entity) {
        return RESOURCE_FOR_ARROW_TIER.get(entity.getItemTier());
    }

    static {
        RESOURCE_FOR_ARROW_TIER.put(ItemTier.WOOD, RESOURCE_LOCATION_WOOD);
        RESOURCE_FOR_ARROW_TIER.put(ItemTier.STONE, RESOURCE_LOCATION_STONE);
        RESOURCE_FOR_ARROW_TIER.put(ItemTier.GOLD, RESOURCE_LOCATION_GOLD);
        RESOURCE_FOR_ARROW_TIER.put(ItemTier.IRON, RESOURCE_LOCATION_IRON);
        RESOURCE_FOR_ARROW_TIER.put(ItemTier.DIAMOND, RESOURCE_LOCATION_DIAMOND);
        RESOURCE_FOR_ARROW_TIER.put(ItemTier.NETHERITE, RESOURCE_LOCATION_NETHERITE);
    }
}