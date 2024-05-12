package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BuffedIllagersProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.BUFFEDMOBS) == true && (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.ILLAGER : false)) {
			if (entity instanceof Evoker) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (entity instanceof Vindicator && Math.random() <= 0.3 && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.SHIELD);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (entity instanceof Vindicator && Math.random() >= 0.5 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_AXE) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("forge:axes"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR)));
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (entity instanceof Vindicator && Math.random() <= 0.01 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_AXE) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(KraftmineModItems.FIRE_BRAND.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (entity instanceof Vex && Math.random() <= 0.5 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_SWORD) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(KraftmineModItems.STONESPEAR.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (entity instanceof Vex && Math.random() > 0.5 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.IRON_SWORD) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.TRIDENT);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if (Math.random() >= 0.2 && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (Math.random() < 0.2 && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Items.FIREWORK_ROCKET);
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
			if (entity instanceof Vindicator && Math.random() <= 0.05) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 9999, 1));
			}
			if (entity instanceof Pillager && Math.random() <= 0.08) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 9999, 1));
			}
			if (entity instanceof Ravager && Math.random() <= 0.08) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 1, (false), (true)));
			}
			if (Math.random() < 0.1) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 9999, 0, (false), (false)));
			}
			if (Math.random() < 0.1) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 1, (false), (false)));
			}
			if (Math.random() < 0.1) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 9999, 1, (false), (false)));
			}
			if (Math.random() < 0.05) {
				entity.getPersistentData().putBoolean("isBuffed", (true));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, 2, (false), (true)));
			}
			if (Math.random() < 0.05) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9999, 2, (false), (true)));
				entity.getPersistentData().putBoolean("isBuffed", (true));
			}
		}
	}
}
