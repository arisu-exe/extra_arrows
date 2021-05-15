package io.github.fallOut015.extra_arrows.entity.projectile;

import io.github.fallOut015.extra_arrows.entity.EntitiesExtraArrows;
import io.github.fallOut015.extra_arrows.item.ItemsExtraArrows;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.HashMap;
import java.util.Map;

public class CappedArrowEntity extends AbstractArrowEntity implements IEntityAdditionalSpawnData {
    private IItemTier tier;
    private static final Map<IItemTier, Item> ITEM_FOR_ARROW_TIER = new HashMap<>();

    public CappedArrowEntity(EntityType<? extends CappedArrowEntity> entityType, World worldIn) {
        super(entityType, worldIn);
    }
    public CappedArrowEntity(World worldIn, double x, double y, double z) {
        super(EntitiesExtraArrows.CAPPED_ARROW.get(), x, y, z, worldIn);
    }
    public CappedArrowEntity(World worldIn, LivingEntity shooter) {
        super(EntitiesExtraArrows.CAPPED_ARROW.get(), shooter, worldIn);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ITEM_FOR_ARROW_TIER.get(this.tier));
    }

    public void setItemTier(IItemTier tier) {
        this.tier = tier;
    }
    public IItemTier getItemTier() {
        return this.tier;
    }
    public float getVelocityMultiplier() {
        return this.tier.getSpeed() / ItemTier.IRON.getSpeed(); // iron is the same speed as a regular arrow, below iron is worse, above iron is better
    }
    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("tier", this.tier.toString());
    }
    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.tier = ItemTier.valueOf(compound.getString("tier"));
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, velocity * this.getVelocityMultiplier(), inaccuracy);
    }
    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    static {
        ITEM_FOR_ARROW_TIER.put(ItemTier.WOOD, ItemsExtraArrows.WOODEN_CAPPED_ARROW.get());
        ITEM_FOR_ARROW_TIER.put(ItemTier.STONE, ItemsExtraArrows.STONE_CAPPED_ARROW.get());
        ITEM_FOR_ARROW_TIER.put(ItemTier.GOLD, ItemsExtraArrows.GOLDEN_CAPPED_ARROW.get());
        ITEM_FOR_ARROW_TIER.put(ItemTier.IRON, ItemsExtraArrows.IRON_CAPPED_ARROW.get());
        ITEM_FOR_ARROW_TIER.put(ItemTier.DIAMOND, ItemsExtraArrows.DIAMOND_CAPPED_ARROW.get());
        ITEM_FOR_ARROW_TIER.put(ItemTier.NETHERITE, ItemsExtraArrows.NETHERITE_CAPPED_ARROW.get());
    }

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeUtf(this.tier.toString());
    }
    @Override
    @OnlyIn(Dist.CLIENT)
    public void readSpawnData(PacketBuffer additionalData) {
        String t = additionalData.readUtf();
        this.tier = ItemTier.valueOf(t);
    }
}