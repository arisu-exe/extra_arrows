package io.github.fallOut015.extra_arrows.entity.projectile;

import io.github.fallOut015.extra_arrows.entity.EntitiesExtraArrows;
import io.github.fallOut015.extra_arrows.item.ItemsExtraArrows;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BombArrowEntity extends AbstractArrowEntity {
    public BombArrowEntity(EntityType<? extends BombArrowEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }
    public BombArrowEntity(World worldIn, double x, double y, double z) {
        super(EntitiesExtraArrows.BOMB_ARROW.get(), x, y, z, worldIn);
    }
    public BombArrowEntity(World worldIn, LivingEntity shooter) {
        super(EntitiesExtraArrows.BOMB_ARROW.get(), shooter, worldIn);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ItemsExtraArrows.BOMB_ARROW.get());
    }
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        if(!this.level.isClientSide) {
            explode();
        }
    }
    @Override
    public void tick() {
        super.tick();
        if(this.inGroundTime > 10 && !this.level.isClientSide) {
            this.explode();
        }
        if (this.level.isClientSide && !this.inGround) {
            this.level.addParticle(ParticleTypes.FIREWORK, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }
    private void explode() {
        this.level.explode(this, this.getX(), this.getY(), this.getZ(), 2.0f, Explosion.Mode.BREAK);
        this.remove();
    }
}