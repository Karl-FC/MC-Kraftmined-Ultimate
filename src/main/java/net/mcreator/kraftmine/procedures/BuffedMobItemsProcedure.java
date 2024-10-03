package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.entity.ZombiePigManEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BuffedMobItemsProcedure {
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
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.BUFFEDMOBS) == true) {
			if (entity.getType().is(EntityTypeTags.UNDEAD) && !(entity instanceof ZombifiedPiglin) && !(entity instanceof ZombiePigManEntity)) {
				if (entity instanceof Zombie && Math.random() < 0.04 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(KraftmineModItems.GOLEMS_ARM.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
					if (Math.random() <= 0.3) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(KraftmineModItems.GOLEMS_ARM.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (Math.random() >= 0.9) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.GOLEMS_ARM.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.GOLEMS_ARM.get()));
							}
						}
					}
				} else if (entity instanceof ZombieVillager && Math.random() < 0.1 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(KraftmineModItems.GOLEMS_ARM.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (Math.random() <= 0.5) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(KraftmineModItems.GOLEMS_ARM.get()).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				}
				if (entity instanceof Zombie && !(entity instanceof ZombieVillager) && Math.random() >= 0.75) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(Items.SKELETON_SKULL));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.SKELETON_SKULL));
						}
					}
				} else if (entity instanceof Zombie && !(entity instanceof ZombieVillager) && Math.random() <= 0.25) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(Items.ZOMBIE_HEAD));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.ZOMBIE_HEAD));
						}
					}
				}
				if (entity instanceof Skeleton && Math.random() < 0.05) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(Blocks.CARVED_PUMPKIN));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.CARVED_PUMPKIN));
						}
					}
				} else if (entity instanceof Skeleton && Math.random() >= 0.7) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(Items.PLAYER_HEAD));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.PLAYER_HEAD));
						}
					}
					if (Math.random() <= 0.5) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(
									(BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:weapons"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()))
									.copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						entity.getPersistentData().putBoolean("isBuffed", true);
					}
				}
				if (Math.random() < 0.5 && !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
				if (entity instanceof Skeleton && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && Math.random() >= 0.25) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.QUIVER_ARMOR_CHESTPLATE.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.QUIVER_ARMOR_CHESTPLATE.get()));
						}
					}
				}
				if (entity instanceof Zombie && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && Math.random() >= 0.5) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.ROAD_CONE_HELMET.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.ROAD_CONE_HELMET.get()));
						}
					}
				}
				if (entity instanceof Skeleton && Math.random() >= 0.95 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.BOW) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BOW).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if (entity instanceof Skeleton && Math.random() >= 0.9) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.CROSSBOW).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
				if (Math.random() <= 0.001 && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				}
				if (Math.random() <= 0.001 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				}
				if (Math.random() <= 0.001 && (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(KraftmineModItems.TOTEMOFCREEPING.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				}
				if (Math.random() <= 0.001 && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(KraftmineModItems.TOTEMOFCREEPING.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				}
				if (Math.random() < 0.05) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_3"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_3"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_2"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_2"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_1"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_1"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_0"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:pigman_armor_0"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				} else if (Math.random() < 0.05) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_helmet"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_helmet"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_chestplate"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_chestplate"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_leggings"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_leggings"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_boots"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("forge:more_boots"))).getRandomElement(RandomSource.create())
									.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value())));
						}
					}
					entity.getPersistentData().putBoolean("isBuffed", true);
				} else if (Math.random() < 0.1) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.PLATE_ARMOR_HELMET.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.PLATE_ARMOR_HELMET.get()));
						}
					}
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.PLATE_ARMOR_CHESTPLATE.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.PLATE_ARMOR_CHESTPLATE.get()));
						}
					}
				}
			}
		}
	}
}
