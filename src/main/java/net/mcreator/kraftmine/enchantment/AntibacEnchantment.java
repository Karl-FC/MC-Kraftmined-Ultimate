
package net.mcreator.kraftmine.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.kraftmine.init.KraftmineModItems;

import java.util.List;

public class AntibacEnchantment extends Enchantment {
	public AntibacEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.COMMON, EnchantmentCategory.ARMOR_HEAD, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(KraftmineModItems.TUNGSTEN_ARMOR_HELMET.get(), KraftmineModItems.OBSIDIAN_ARMOR_HELMET.get(), KraftmineModItems.DRIP_ARMOR_HELMET.get(), KraftmineModItems.NICKEL_ARMOR_HELMET.get(),
				KraftmineModItems.TITANIUM_ARMOR_HELMET.get(), KraftmineModItems.CARBON_ARMOR_HELMET.get(), KraftmineModItems.LAPIS_LAZULI_ARMOR_HELMET.get(), KraftmineModItems.REDSTONE_ARMOR_HELMET.get(),
				KraftmineModItems.DEPRESSURE_HELMET_HELMET.get(), KraftmineModItems.CURSED_IRON_ARMOR_HELMET.get(), KraftmineModItems.CACTUS_ARMOR_HELMET.get(), KraftmineModItems.TNT_ARMOR_HELMET.get(), KraftmineModItems.WOOD_ARMOR_HELMET.get(),
				KraftmineModItems.EGG_ARMOR_HELMET.get(), KraftmineModItems.EGGHELL_ARMOR_HELMET.get(), KraftmineModItems.CONDENSED_ARMOR_HELMET.get(), KraftmineModItems.STUDDED_ARMOR_HELMET.get(), KraftmineModItems.PLATE_ARMOR_HELMET.get(),
				KraftmineModItems.ROAD_CONE_HELMET.get(), KraftmineModItems.PLASTIC_ARMOR_HELMET.get(), KraftmineModItems.GHILLIE_SUIT_HELMET.get(), KraftmineModItems.PRISMARINE_ARMOR_HELMET.get(), Items.LEATHER_HELMET, Items.CHAINMAIL_HELMET,
				Items.TURTLE_HELMET, Items.IRON_HELMET, Items.GOLDEN_HELMET, Items.DIAMOND_HELMET, Items.NETHERITE_HELMET).contains(item);
	}
}
