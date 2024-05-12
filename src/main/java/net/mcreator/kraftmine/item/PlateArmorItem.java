
package net.mcreator.kraftmine.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModTabs;

public abstract class PlateArmorItem extends ArmorItem {
	public PlateArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{0, 0, 11, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.IRON_INGOT));
			}

			@Override
			public String getName() {
				return "plate_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends PlateArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/plate__layer_1.png";
		}
	}

	public static class Chestplate extends PlateArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/plate__layer_1.png";
		}
	}
}
