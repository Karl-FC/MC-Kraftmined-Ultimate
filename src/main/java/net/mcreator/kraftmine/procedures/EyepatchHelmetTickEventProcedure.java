package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class EyepatchHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double PirateTick = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.EYEPATCH_HELMET.get() && world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) >= 7) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("Recharging", (true));
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.EYEPATCH_HELMET.get() && world.getMaxLocalRawBrightness(new BlockPos(x, y, z)) < 7
				&& (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).eyepatch_counter > 0) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putBoolean("Recharging", (false));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.EYEPATCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("Recharging") == true) {
			{
				double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).eyepatch_counter + 1;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.eyepatch_counter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.EYEPATCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getBoolean("Recharging") == false
				&& (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).eyepatch_counter > 0) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.EYEPATCH_ON_EFFECT.get(),
						(int) (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).eyepatch_counter, 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(
						new MobEffectInstance(MobEffects.NIGHT_VISION, (int) (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).eyepatch_counter, 1, (false), (false)));
			{
				double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).eyepatch_counter - 1;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.eyepatch_counter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
