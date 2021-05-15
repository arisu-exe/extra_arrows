package io.github.fallOut015.extra_arrows.entity;

import io.github.fallOut015.extra_arrows.MainExtraArrows;
import io.github.fallOut015.extra_arrows.entity.projectile.*;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntitiesExtraArrows {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MainExtraArrows.MODID);

    public static final RegistryObject<EntityType<CappedArrowEntity>> CAPPED_ARROW = ENTITIES.register("capped_arrow", () -> EntityType.Builder.<CappedArrowEntity>of(CappedArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build("capped_arrow"));
    public static final RegistryObject<EntityType<FireArrowEntity>> FIRE_ARROW = ENTITIES.register("fire_arrow", () -> EntityType.Builder.<FireArrowEntity>of(FireArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build("fire_arrow"));
    public static final RegistryObject<EntityType<IceArrowEntity>> ICE_ARROW = ENTITIES.register("ice_arrow", () -> EntityType.Builder.<IceArrowEntity>of(IceArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build("ice_arrow"));
    public static final RegistryObject<EntityType<BombArrowEntity>> BOMB_ARROW = ENTITIES.register("bomb_arrow", () -> EntityType.Builder.<BombArrowEntity>of(BombArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build("bomb_arrow"));
    public static final RegistryObject<EntityType<ShockArrowEntity>> SHOCK_ARROW = ENTITIES.register("shock_arrow", () -> EntityType.Builder.<ShockArrowEntity>of(ShockArrowEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).build("shock_arrow"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}