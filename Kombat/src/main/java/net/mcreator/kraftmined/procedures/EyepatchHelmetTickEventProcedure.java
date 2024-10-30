package net.mcreator.kraftmined.procedures;

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

import net.mcreator.kraftmined.network.KraftminedModVariables;
import net.mcreator.kraftmined.init.KraftminedModMobEffects;
import net.mcreator.kraftmined.init.KraftminedModItems;

public class EyepatchHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftminedModItems.EYEPATCH_HELMET.get() && world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) >= 7) {
			{
				final String _tagName = "Recharging";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftminedModItems.EYEPATCH_HELMET.get()
				&& world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) < 7 && entity.getData(KraftminedModVariables.PLAYER_VARIABLES).Eyepatch_timer > 0) {
			{
				final String _tagName = "Recharging";
				final boolean _tagValue = false;
				CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY), tag -> tag.putBoolean(_tagName, _tagValue));
			}
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftminedModItems.EYEPATCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Recharging") == true) {
			{
				KraftminedModVariables.PlayerVariables _vars = entity.getData(KraftminedModVariables.PLAYER_VARIABLES);
				_vars.Eyepatch_timer = entity.getData(KraftminedModVariables.PLAYER_VARIABLES).Eyepatch_timer + 1;
				_vars.syncPlayerVariables(entity);
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftminedModItems.EYEPATCH_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("Recharging") == false
				&& entity.getData(KraftminedModVariables.PLAYER_VARIABLES).Eyepatch_timer > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(KraftminedModMobEffects.EYEPATCH_EFFECT, (int) entity.getData(KraftminedModVariables.PLAYER_VARIABLES).Eyepatch_timer, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int) entity.getData(KraftminedModVariables.PLAYER_VARIABLES).Eyepatch_timer, 1, false, false));
			{
				KraftminedModVariables.PlayerVariables _vars = entity.getData(KraftminedModVariables.PLAYER_VARIABLES);
				_vars.Eyepatch_timer = entity.getData(KraftminedModVariables.PLAYER_VARIABLES).Eyepatch_timer - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
