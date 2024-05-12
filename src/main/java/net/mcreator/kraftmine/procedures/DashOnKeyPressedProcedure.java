package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.Direction;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;
import net.mcreator.kraftmine.KraftmineMod;

public class DashOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DashConditionsProcedure.execute(entity)) {
			{
				boolean _setval = true;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsDashing = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getDirection()) == Direction.NORTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (-1)));
			} else if ((entity.getDirection()) == Direction.SOUTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), 1));
			} else if ((entity.getDirection()) == Direction.EAST) {
				entity.setDeltaMovement(new Vec3(1, (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
			} else if ((entity.getDirection()) == Direction.WEST) {
				entity.setDeltaMovement(new Vec3((-1), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
			}
			KraftmineMod.queueServerWork(20, () -> {
				{
					boolean _setval = false;
					entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsDashing = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
			if (SwiftfootedProcedureProcedure.execute(entity)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20,
							EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SWIFTFOOTED.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)), (false), (false)));
			}
		}
	}
}
