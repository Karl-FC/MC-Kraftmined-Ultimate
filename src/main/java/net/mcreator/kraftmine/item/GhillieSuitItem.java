
package net.mcreator.kraftmine.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModBlocks;

public abstract class GhillieSuitItem extends ArmorItem {
	public GhillieSuitItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 5;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{1, 2, 2, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 0;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.azalea_leaves.place"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModBlocks.MAHOGANY_LEAVES.get()), new ItemStack(KraftmineModBlocks.CHERRY_LEAVES.get()), new ItemStack(KraftmineModBlocks.PALM_WOOD_LEAVES.get()), new ItemStack(Blocks.OAK_LEAVES),
						new ItemStack(Blocks.OAK_LEAVES), new ItemStack(Blocks.SPRUCE_LEAVES), new ItemStack(Blocks.BIRCH_LEAVES), new ItemStack(Blocks.JUNGLE_LEAVES), new ItemStack(Blocks.ACACIA_LEAVES), new ItemStack(Blocks.ACACIA_LEAVES),
						new ItemStack(Blocks.DARK_OAK_LEAVES), new ItemStack(Blocks.AZALEA_LEAVES), new ItemStack(Blocks.FLOWERING_AZALEA_LEAVES));
			}

			@Override
			public String getName() {
				return "ghillie_suit";
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

	public static class Helmet extends GhillieSuitItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/leaf__layer_1.png";
		}
	}

	public static class Chestplate extends GhillieSuitItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/leaf__layer_1.png";
		}
	}

	public static class Leggings extends GhillieSuitItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/leaf__layer_2.png";
		}
	}

	public static class Boots extends GhillieSuitItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "kraftmine:textures/models/armor/leaf__layer_1.png";
		}
	}
}
