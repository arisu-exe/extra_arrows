package io.github.fallOut015.extra_arrows;

import io.github.fallOut015.extra_arrows.client.particle.FrostParticle;
import io.github.fallOut015.extra_arrows.client.particle.SparkParticle;
import io.github.fallOut015.extra_arrows.client.registry.RenderingRegistryExtraArrows;
import io.github.fallOut015.extra_arrows.enchantment.EnchantmentsExtraArrows;
import io.github.fallOut015.extra_arrows.entity.EntitiesExtraArrows;
import io.github.fallOut015.extra_arrows.item.ItemsExtraArrows;
import io.github.fallOut015.extra_arrows.particles.ParticlesExtraArrows;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(MainExtraArrows.MODID)
public class MainExtraArrows {
    public static final String MODID = "extra_arrows";

    public MainExtraArrows() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        ItemsExtraArrows.register(FMLJavaModLoadingContext.get().getModEventBus());
        EnchantmentsExtraArrows.register(FMLJavaModLoadingContext.get().getModEventBus());
        EntitiesExtraArrows.register(FMLJavaModLoadingContext.get().getModEventBus());
        ParticlesExtraArrows.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistryExtraArrows.doClientStuff(event);
    }
    private void enqueueIMC(final InterModEnqueueEvent event) {
    }
    private void processIMC(final InterModProcessEvent event) {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SuppressWarnings("resource")
        @SubscribeEvent
        public static void onParticleFactoryRegistry(final ParticleFactoryRegisterEvent event) {
            Minecraft.getInstance().particleEngine.register(ParticlesExtraArrows.FROST.get(), FrostParticle.Factory::new);
            Minecraft.getInstance().particleEngine.register(ParticlesExtraArrows.SPARK.get(), SparkParticle.Factory::new);
        }
    }

    @Mod.EventBusSubscriber
    public static class Events {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public static void onRenderPlayerEventPre(final RenderPlayerEvent.Pre event) {
            /*if (event.getPlayer().getEffect(PotionsExtraArrows.FROZEN.get()) != null) {
                // render with light blue overlay (same as potion effect but translucent)
            }*/
        }
    }
}