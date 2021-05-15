package io.github.fallOut015.extra_arrows.item;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import net.minecraft.item.Item.Properties;

public class ArrowItemExtraArrows extends ArrowItem {
    private final IArrowFactory arrow;

    public ArrowItemExtraArrows(IArrowFactory arrow, Properties builder) {
        super(builder);

        this.arrow = arrow;
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        AbstractArrowEntity arrowEntity = this.arrow.createArrow(worldIn, shooter);
        return arrowEntity;
    }
}