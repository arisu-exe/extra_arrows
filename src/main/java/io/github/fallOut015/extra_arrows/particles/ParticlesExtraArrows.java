package io.github.fallOut015.extra_arrows.particles;

import io.github.fallOut015.extra_arrows.MainExtraArrows;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticlesExtraArrows {
    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MainExtraArrows.MODID);



    public static final RegistryObject<BasicParticleType> FROST = PARTICLE_TYPES.register("frost", () -> new BasicParticleType(false));
    public static final RegistryObject<BasicParticleType> SPARK = PARTICLE_TYPES.register("spark", () -> new BasicParticleType(false));



    public static void register(IEventBus bus) {
        PARTICLE_TYPES.register(bus);
    }
}