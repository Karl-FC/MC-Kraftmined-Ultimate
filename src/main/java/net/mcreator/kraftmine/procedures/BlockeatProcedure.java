package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

public class BlockeatProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.destroyBlock(new BlockPos(x, y, z), false);
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1200, 2, (false), (false)));
	}
}
