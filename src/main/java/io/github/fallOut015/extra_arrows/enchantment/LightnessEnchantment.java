package io.github.fallOut015.extra_arrows.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class LightnessEnchantment extends Enchantment {
    public LightnessEnchantment(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.BOW, slots);
    }

    public int getMinCost(int enchantmentLevel) {
        return 20;
    }

    public int getMaxCost(int enchantmentLevel) {
        return 40;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean checkCompatibility(Enchantment ench) {
        return !(ench instanceof LightnessEnchantment) && super.checkCompatibility(ench);
    }
}
