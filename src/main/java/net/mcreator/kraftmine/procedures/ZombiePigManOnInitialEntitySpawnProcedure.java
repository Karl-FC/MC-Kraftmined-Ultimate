package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.entity.ZombiePigManEntity;

public class ZombiePigManOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ZombiePigManEntity) {
			if (Math.random() <= 0.9) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_main_hand"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR)));
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(KraftmineModItems.NETHERS_WRATH.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (Math.random() < 0.6) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_3"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_3"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
					}
				}
			} else if (Math.random() < 0.2) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
					}
				}
			} else if (Math.random() < 0.1) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(Items.ZOMBIE_HEAD));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.ZOMBIE_HEAD));
					}
				}
			} else if (Math.random() < 0.1) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(Items.WITHER_SKELETON_SKULL));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.WITHER_SKELETON_SKULL));
					}
				}
			}
			if (Math.random() < 0.8) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_2"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_2"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
					}
				}
			} else if (Math.random() < 0.2) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack(Blocks.AIR));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
					}
				}
			}
			if (Math.random() < 0.8) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_1"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_1"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
					}
				}
			} else if (Math.random() < 0.2) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, new ItemStack(Blocks.AIR));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
					}
				}
			}
			if (Math.random() < 0.8) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_0"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:pigman_armor_0"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
					}
				}
			} else if (Math.random() < 0.2) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, new ItemStack(Blocks.AIR));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Blocks.AIR));
					}
				}
			}
		}
	}
}
