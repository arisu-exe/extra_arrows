package io.github.fallOut015.extra_arrows.item;

import io.github.fallOut015.extra_arrows.entity.projectile.CappedArrowEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.item.Item.Properties;

public class CappedArrowItem extends ArrowItem {
    private final IItemTier tier;

    public CappedArrowItem(IItemTier tier, Properties properties) {
        super(properties);
        this.tier = tier;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        tooltip.add(new StringTextComponent(" Speed: " + df.format(100 * (this.tier.getSpeed() / ItemTier.IRON.getSpeed())) + "%").withStyle(TextFormatting.DARK_GREEN)); // TODO replace with translation

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        CappedArrowEntity cappedarrowentity = new CappedArrowEntity(worldIn, shooter);
        cappedarrowentity.setItemTier(this.tier);
        return cappedarrowentity;
    }
}