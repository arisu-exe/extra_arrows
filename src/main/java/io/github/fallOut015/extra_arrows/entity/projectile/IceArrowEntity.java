package io.github.fallOut015.extra_arrows.entity.projectile;

import io.github.fallOut015.extra_arrows.entity.EntitiesExtraArrows;
import io.github.fallOut015.extra_arrows.item.ItemsExtraArrows;
import io.github.fallOut015.extra_arrows.particles.ParticlesExtraArrows;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class IceArrowEntity extends AbstractArrowEntity {
    public IceArrowEntity(EntityType<? extends IceArrowEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }
    public IceArrowEntity(World worldIn, double x, double y, double z) {
        super(EntitiesExtraArrows.ICE_ARROW.get(), x, y, z, worldIn);
    }
    public IceArrowEntity(World worldIn, LivingEntity shooter) {
        super(EntitiesExtraArrows.ICE_ARROW.get(), shooter, worldIn);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemsExtraArrows.ICE_ARROW.get());
    }
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide && !this.inGround) {
            this.level.addParticle(ParticlesExtraArrows.FROST.get(), this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }
    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        // TODO
        //living.addEffect(new EffectInstance(PotionsExtraArrows.FROZEN.get(), 50, 1, false, false));
    }
}