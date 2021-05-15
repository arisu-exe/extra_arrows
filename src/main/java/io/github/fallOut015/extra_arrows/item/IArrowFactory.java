package io.github.fallOut015.extra_arrows.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.world.World;

public interface IArrowFactory {
    AbstractArrowEntity createArrow(World worldIn, LivingEntity shooter);
}