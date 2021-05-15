package io.github.fallOut015.extra_arrows.item;

import io.github.fallOut015.extra_arrows.MainExtraArrows;
import io.github.fallOut015.extra_arrows.entity.projectile.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemsExtraArrows {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MainExtraArrows.MODID);

    public static final RegistryObject<Item> WOODEN_CAPPED_ARROW = ITEMS.register("wooden_capped_arrow", () -> new CappedArrowItem(ItemTier.WOOD, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> STONE_CAPPED_ARROW = ITEMS.register("stone_capped_arrow", () -> new CappedArrowItem(ItemTier.STONE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GOLDEN_CAPPED_ARROW = ITEMS.register("golden_capped_arrow", () -> new CappedArrowItem(ItemTier.GOLD, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_CAPPED_ARROW = ITEMS.register("iron_capped_arrow", () -> new CappedArrowItem(ItemTier.IRON, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> DIAMOND_CAPPED_ARROW = ITEMS.register("diamond_capped_arrow", () -> new CappedArrowItem(ItemTier.DIAMOND, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> NETHERITE_CAPPED_ARROW = ITEMS.register("netherite_capped_arrow", () -> new CappedArrowItem(ItemTier.NETHERITE, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    public static final RegistryObject<Item> FIRE_ARROW = ITEMS.register("fire_arrow", () -> new ArrowItemExtraArrows(FireArrowEntity::new, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> ICE_ARROW = ITEMS.register("ice_arrow", () -> new ArrowItemExtraArrows(IceArrowEntity::new, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> BOMB_ARROW = ITEMS.register("bomb_arrow", () -> new ArrowItemExtraArrows(BombArrowEntity::new, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SHOCK_ARROW = ITEMS.register("shock_arrow", () -> new ArrowItemExtraArrows(ShockArrowEntity::new, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);

        // TODO
        /*DispenserBlock.registerDispenseBehavior(WOODEN_CAPPED_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                cappedarrowentity.setItemTier(ItemTier.WOOD);
                return cappedarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(STONE_CAPPED_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                cappedarrowentity.setItemTier(ItemTier.STONE);
                return cappedarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(IRON_CAPPED_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                cappedarrowentity.setItemTier(ItemTier.IRON);
                return cappedarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(GOLDEN_CAPPED_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                cappedarrowentity.setItemTier(ItemTier.GOLD);
                return cappedarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(DIAMOND_CAPPED_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                cappedarrowentity.setItemTier(ItemTier.DIAMOND);
                return cappedarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(NETHERITE_CAPPED_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                cappedarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                cappedarrowentity.setItemTier(ItemTier.NETHERITE);
                return cappedarrowentity;
            }
        });

        DispenserBlock.registerDispenseBehavior(FIRE_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                AbstractArrowEntity abstractarrowentity = new FireArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                return abstractarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(ICE_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                AbstractArrowEntity abstractarrowentity = new IceArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                return abstractarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(BOMB_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                AbstractArrowEntity abstractarrowentity = new BombArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                return abstractarrowentity;
            }
        });
        DispenserBlock.registerDispenseBehavior(SHOCK_ARROW.get(), new ProjectileDispenseBehavior() {
            protected ProjectileEntity getProjectileEntity(World worldIn, IPosition position, ItemStack stackIn) {
                AbstractArrowEntity abstractarrowentity = new ShockArrowEntity(worldIn, position.getX(), position.getY(), position.getZ());
                abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.ALLOWED;
                return abstractarrowentity;
            }
        });*/
    }
}