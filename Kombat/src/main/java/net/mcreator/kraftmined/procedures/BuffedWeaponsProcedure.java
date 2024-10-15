package net.mcreator.kraftmined.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.kraftmined.init.KraftminedModItems;
import net.mcreator.kraftmined.init.KraftminedModAttributes;

public class BuffedWeaponsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Difficulty = 0;
		double Buff = 0;
		double BuffChance = 0;
		Buff = entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(KraftminedModAttributes.BUFF_LEVEL) ? _livingEntity0.getAttribute(KraftminedModAttributes.BUFF_LEVEL).getBaseValue() : 0;
		if (entity.getType().is(EntityTypeTags.UNDEAD) && !(entity instanceof ZombifiedPiglin) && !(entity instanceof Piglin)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				if (Buff == 1) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(
								(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("kraftmined:weapon1"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
								.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (Buff == 2) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(
								(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("kraftmined:weapon2"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
								.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (Buff == 3) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(
								(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("kraftmined:weapon3"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
								.copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			}
			if (entity instanceof Skeleton) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack(KraftminedModItems.QUIVER_CHESTPLATE.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftminedModItems.QUIVER_CHESTPLATE.get()));
					}
				}
			}
		}
		if (Math.random() <= 0.05) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		SwitchHandsProcedure.execute(entity);
	}
}
