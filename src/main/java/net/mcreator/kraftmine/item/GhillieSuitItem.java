
package net.mcreator.kraftmine.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import net.mcreator.kraftmine.init.KraftmineModBlocks;

import java.util.List;
import java.util.EnumMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class GhillieSuitItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 1);
				map.put(ArmorItem.Type.LEGGINGS, 2);
				map.put(ArmorItem.Type.CHESTPLATE, 2);
				map.put(ArmorItem.Type.HELMET, 1);
				map.put(ArmorItem.Type.BODY, 2);
			}), 0, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("block.azalea_leaves.place")),
					() -> CompoundIngredient.of(Ingredient.of(new ItemStack(KraftmineModBlocks.MAHOGANY_LEAVES.get())), Ingredient.of(new ItemStack(KraftmineModBlocks.CHERRY_LEAVES.get())),
							Ingredient.of(new ItemStack(KraftmineModBlocks.PALM_WOOD_LEAVES.get())), Ingredient.of(ItemTags.create(ResourceLocation.parse("minecraft:leaves"))), Ingredient.of(new ItemStack(Blocks.OAK_LEAVES)),
							Ingredient.of(new ItemStack(Blocks.SPRUCE_LEAVES)), Ingredient.of(new ItemStack(Blocks.BIRCH_LEAVES)), Ingredient.of(new ItemStack(Blocks.JUNGLE_LEAVES)),
							Ingredient.of(ItemTags.create(ResourceLocation.parse("minecraft:leaves"))), Ingredient.of(new ItemStack(Blocks.ACACIA_LEAVES)), Ingredient.of(new ItemStack(Blocks.DARK_OAK_LEAVES)),
							Ingredient.of(new ItemStack(Blocks.AZALEA_LEAVES)), Ingredient.of(new ItemStack(Blocks.FLOWERING_AZALEA_LEAVES))),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("kraftmine:leaf_"))), 0f, 0f);
			registerHelper.register(ResourceLocation.parse("kraftmine:ghillie_suit"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public GhillieSuitItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends GhillieSuitItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(5)));
		}
	}

	public static class Chestplate extends GhillieSuitItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(5)));
		}
	}

	public static class Leggings extends GhillieSuitItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(5)));
		}
	}

	public static class Boots extends GhillieSuitItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(5)));
		}
	}
}
