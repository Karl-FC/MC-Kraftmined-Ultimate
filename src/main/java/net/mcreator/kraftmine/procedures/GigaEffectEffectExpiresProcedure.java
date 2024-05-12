package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class GigaEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_HELMET.get()) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_3));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_3));
				}
			}
		}
		if (!((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_CHESTPLATE.get())) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_2));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_2));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_LEGGINGS.get()) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_1));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_1));
				}
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftmineModItems.GIGA_ARMOR_BOOTS.get()) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_0));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).SavedArmor_0));
				}
			}
		}
	}
}
