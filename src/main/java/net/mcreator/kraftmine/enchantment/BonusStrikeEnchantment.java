
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class BonusStrikeEnchantment extends Enchantment {
	public BonusStrikeEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}
}
