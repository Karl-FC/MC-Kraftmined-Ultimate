package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.KraftmineMod;

public class GigaEffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2100, 15, (false), (false)));
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_HELMET.get())) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				KraftmineMod.queueServerWork(5, () -> {
					{
						ItemStack _setval = new ItemStack(Blocks.AIR);
						entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SavedArmor_0 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else {
				{
					ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SavedArmor_3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				KraftmineMod.queueServerWork(5, () -> {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(KraftmineModItems.GIGA_ARMOR_HELMET.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(KraftmineModItems.GIGA_ARMOR_HELMET.get()));
						}
					}
					((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)).enchant(Enchantments.BINDING_CURSE, 10);
				});
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_CHESTPLATE.get())) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				KraftmineMod.queueServerWork(5, () -> {
					{
						ItemStack _setval = new ItemStack(Blocks.AIR);
						entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SavedArmor_0 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else {
				{
					ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SavedArmor_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				KraftmineMod.queueServerWork(5, () -> {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, new ItemStack(KraftmineModItems.GIGA_ARMOR_CHESTPLATE.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(KraftmineModItems.GIGA_ARMOR_CHESTPLATE.get()));
						}
					}
					((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)).enchant(Enchantments.BINDING_CURSE, 10);
				});
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_LEGGINGS.get())) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				KraftmineMod.queueServerWork(5, () -> {
					{
						ItemStack _setval = new ItemStack(Blocks.AIR);
						entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SavedArmor_0 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else {
				{
					ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SavedArmor_1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				KraftmineMod.queueServerWork(5, () -> {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, new ItemStack(KraftmineModItems.GIGA_ARMOR_LEGGINGS.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(KraftmineModItems.GIGA_ARMOR_LEGGINGS.get()));
						}
					}
					((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)).enchant(Enchantments.BINDING_CURSE, 10);
				});
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_BOOTS.get())) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				KraftmineMod.queueServerWork(5, () -> {
					{
						ItemStack _setval = new ItemStack(Blocks.AIR);
						entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SavedArmor_0 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			} else {
				{
					ItemStack _setval = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SavedArmor_0 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				KraftmineMod.queueServerWork(5, () -> {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, new ItemStack(KraftmineModItems.GIGA_ARMOR_BOOTS.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(KraftmineModItems.GIGA_ARMOR_BOOTS.get()));
						}
					}
					((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)).enchant(Enchantments.BINDING_CURSE, 10);
				});
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:theme.gigachad")), SoundSource.MUSIC, 1, 1);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:theme.gigachad")), SoundSource.MUSIC, 1, 1, false);
			}
		}
	}
}
