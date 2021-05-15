package io.github.fallOut015.extra_arrows.enchantment;

import io.github.fallOut015.extra_arrows.MainExtraArrows;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantmentsExtraArrows {
    private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MainExtraArrows.MODID);



    public static final RegistryObject<Enchantment> LIGHTNESS = ENCHANTMENTS.register("lightness", () -> new LightnessEnchantment(Enchantment.Rarity.RARE, EquipmentSlotType.HEAD));
    public static final RegistryObject<Enchantment> GUIDANCE = ENCHANTMENTS.register("guidance", () -> new GuidanceEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlotType.HEAD));



    public static void register(IEventBus bus) {
        ENCHANTMENTS.register(bus);
    }
}
