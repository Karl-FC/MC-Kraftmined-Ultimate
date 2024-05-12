
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import java.util.List;

public class CommittedEnchantment extends Enchantment {
	public CommittedEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		return List.of(KraftmineModEnchantments.SABER_SWING.get(), KraftmineModEnchantments.DYING_PAN.get(), KraftmineModEnchantments.RECONSTRUCTION.get(), KraftmineModEnchantments.CONJURING.get(), KraftmineModEnchantments.REPLENISHMENT.get(),
				KraftmineModEnchantments.EFFICACY.get(), KraftmineModEnchantments.SLICING.get(), KraftmineModEnchantments.STAB.get(), KraftmineModEnchantments.COMMITTED.get(), Enchantments.ALL_DAMAGE_PROTECTION, Enchantments.FIRE_PROTECTION,
				Enchantments.FALL_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.RESPIRATION, Enchantments.AQUA_AFFINITY, Enchantments.THORNS, Enchantments.DEPTH_STRIDER, Enchantments.FROST_WALKER,
				Enchantments.BINDING_CURSE, Enchantments.SHARPNESS, Enchantments.SMITE, Enchantments.BANE_OF_ARTHROPODS, Enchantments.KNOCKBACK, Enchantments.FIRE_ASPECT, Enchantments.MOB_LOOTING, Enchantments.SWEEPING_EDGE,
				Enchantments.BLOCK_EFFICIENCY, Enchantments.SILK_TOUCH, Enchantments.UNBREAKING, Enchantments.BLOCK_FORTUNE, Enchantments.POWER_ARROWS, Enchantments.PUNCH_ARROWS, Enchantments.FLAMING_ARROWS, Enchantments.INFINITY_ARROWS,
				Enchantments.FISHING_LUCK, Enchantments.FISHING_SPEED, Enchantments.LOYALTY, Enchantments.IMPALING, Enchantments.RIPTIDE, Enchantments.CHANNELING, Enchantments.MULTISHOT, Enchantments.QUICK_CHARGE, Enchantments.PIERCING,
				Enchantments.MENDING, Enchantments.VANISHING_CURSE, Enchantments.SOUL_SPEED).contains(ench);
	}
}
