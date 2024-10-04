package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BuffMobArmorProcedure {
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
		if (!(entity instanceof Player) && world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.BUFFEDMOBS) == true) {
			KraftmineMod.queueServerWork(1, () -> {
				if (Math.random() >= 0.5 && entity.getPersistentData().getBoolean("isBuffed") == true && (entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) > 3) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.PLATE_ARMOR_HELMET.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.PLATE_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.PLATE_ARMOR_CHESTPLATE.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.TNT_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.TNT_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.TNT_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.TNT_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.TNT_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.TNT_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.TNT_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.CACTUS_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.CACTUS_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.CACTUS_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.CACTUS_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.CACTUS_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.CACTUS_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.CACTUS_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.DRIP_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.DRIP_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.DRIP_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.DRIP_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.DRIP_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.DRIP_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.DRIP_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.EGGHELL_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.EGGHELL_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.EGGHELL_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.EGGHELL_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.EGGHELL_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.EGGHELL_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.EGGHELL_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.STUDDED_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.STUDDED_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.STUDDED_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.STUDDED_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.STUDDED_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.STUDDED_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.STUDDED_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.CONDENSED_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.CONDENSED_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.CONDENSED_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.CONDENSED_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.CONDENSED_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.CONDENSED_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.CONDENSED_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.LAPIS_LAZULI_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.LAPIS_LAZULI_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.LAPIS_LAZULI_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.LAPIS_LAZULI_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.LAPIS_LAZULI_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.LAPIS_LAZULI_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.LAPIS_LAZULI_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.REDSTONE_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.REDSTONE_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.REDSTONE_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.REDSTONE_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.REDSTONE_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.REDSTONE_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.REDSTONE_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.DIAMOND_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.DIAMOND_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.DIAMOND_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.OBSIDIAN_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.OBSIDIAN_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.OBSIDIAN_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.OBSIDIAN_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.OBSIDIAN_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.OBSIDIAN_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.OBSIDIAN_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.TITANIUM_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.TITANIUM_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.TITANIUM_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.TITANIUM_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.TITANIUM_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.TITANIUM_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.TITANIUM_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.CARBON_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.CARBON_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.CARBON_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.CARBON_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.CARBON_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.CARBON_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.CARBON_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.EGG_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.EGG_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.EGG_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.EGG_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.EGG_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.EGG_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.EGG_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.WOOD_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.WOOD_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.WOOD_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.WOOD_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.WOOD_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.WOOD_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.WOOD_ARMOR_BOOTS.get()));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.NETHERITE_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.NETHERITE_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.NETHERITE_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
							}
						}
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.NICKEL_ARMOR_LEGGINGS.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.NICKEL_ARMOR_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.NICKEL_ARMOR_HELMET.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.NICKEL_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.NICKEL_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.NICKEL_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.NICKEL_ARMOR_BOOTS.get()));
							}
						}
					}
				}
			});
		}
	}
}
