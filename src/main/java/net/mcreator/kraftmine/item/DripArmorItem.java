
package net.mcreator.kraftmine.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
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

import net.mcreator.kraftmine.procedures.DripArmorBodyTickEventProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;

public abstract class DripArmorItem extends ArmorItem {
	public DripArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 15;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 7, 6, 4}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 12;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Blocks.DRIPSTONE_BLOCK));
			}

			@Override
			public String getName() {
				return "drip_armor";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		}, slot, properties);
	}

	public static class Helmet extends DripArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/drip_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DripArmorBodyTickEventProcedure.execute(entity, itemstack);
		}
	}

	public static class Chestplate extends DripArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/drip_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DripArmorBodyTickEventProcedure.execute(entity, itemstack);
		}
	}

	public static class Leggings extends DripArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/drip_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DripArmorBodyTickEventProcedure.execute(entity, itemstack);
		}
	}

	public static class Boots extends DripArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).fireResistant());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/drip_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			DripArmorBodyTickEventProcedure.execute(entity, itemstack);
		}
	}
}
