package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmined.kombat.network.KmKombatModVariables;
import net.mcreator.kraftmined.kombat.init.KmKombatModMobEffects;
import net.mcreator.kraftmined.kombat.init.KmKombatModItems;

public class EyepatchHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KmKombatModItems.EYEPATCH_HELMET.get() && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 7) {
			{
				final String _tagName = "Recharging";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KmKombatModItems.EYEPATCH_HELMET.get()
				&& world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 7 && entity.getData(KmKombatModVariables.PLAYER_VARIABLES).Eyepatch_timer > 0) {
			{
				final String _tagName = "Recharging";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KmKombatModItems.EYEPATCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Recharging") == true) {
			{
				KmKombatModVariables.PlayerVariables _vars = entity.getData(KmKombatModVariables.PLAYER_VARIABLES);
				_vars.Eyepatch_timer = entity.getData(KmKombatModVariables.PLAYER_VARIABLES).Eyepatch_timer + 1;
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KmKombatModItems.EYEPATCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Recharging") == false
				&& entity.getData(KmKombatModVariables.PLAYER_VARIABLES).Eyepatch_timer > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(KmKombatModMobEffects.EYEPATCH_EFFECT, (int) entity.getData(KmKombatModVariables.PLAYER_VARIABLES).Eyepatch_timer, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int) entity.getData(KmKombatModVariables.PLAYER_VARIABLES).Eyepatch_timer, 1, false, false));
			{
				KmKombatModVariables.PlayerVariables _vars = entity.getData(KmKombatModVariables.PLAYER_VARIABLES);
				_vars.Eyepatch_timer = entity.getData(KmKombatModVariables.PLAYER_VARIABLES).Eyepatch_timer - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
