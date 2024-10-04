package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.KraftmineMod;

public class DashOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (DashConditionsProcedure.execute(entity)) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.IsDashing = true;
				_vars.syncPlayerVariables(entity);
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
					KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
					_vars.IsDashing = false;
					_vars.syncPlayerVariables(entity);
				}
			});
			if (SwiftfootedProcedureProcedure.execute(world, entity)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:swiftfooted")))), false, false));
			}
		}
	}
}
