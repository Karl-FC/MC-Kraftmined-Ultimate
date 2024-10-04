package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEntities;
import net.mcreator.kraftmine.entity.PenguinbigEntity;

public class PenguinOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double egg = 0;
		entity.getPersistentData().putDouble("age", (entity.getPersistentData().getDouble("age") + 1));
		if (entity.getPersistentData().getDouble("age") == 48000) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = KraftmineModEntities.PENGUINBIG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR && entity.getPersistentData().getDouble("air") < 6000) {
			entity.getPersistentData().putDouble("air", (entity.getPersistentData().getDouble("air") + 1));
		} else if (entity.isInWater() && !(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.WATER_BREATHING)) && entity.getPersistentData().getDouble("air") > 0) {
			entity.getPersistentData().putDouble("air", (entity.getPersistentData().getDouble("air") - 1));
		}
		if (entity instanceof PenguinbigEntity) {
			egg = egg + 1;
			if (egg == 24000) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EGG));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
