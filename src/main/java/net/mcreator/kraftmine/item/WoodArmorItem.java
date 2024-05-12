
package net.mcreator.kraftmine.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.procedures.WoodArmorProcedureProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public abstract class WoodArmorItem extends ArmorItem {
	public WoodArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 2;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{1, 1, 1, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 1;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}

			@Override
			public String getName() {
				return "wood_armor";
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

	public static class Helmet extends WoodArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/wood_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			WoodArmorProcedureProcedure.execute(entity);
		}
	}

	public static class Chestplate extends WoodArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/wood_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			WoodArmorProcedureProcedure.execute(entity);
		}
	}

	public static class Leggings extends WoodArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/wood_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			WoodArmorProcedureProcedure.execute(entity);
		}
	}

	public static class Boots extends WoodArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/wood_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			WoodArmorProcedureProcedure.execute(entity);
		}
	}
}
