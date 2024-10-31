package net.mcreator.kraftmined.unplayable.procedures;

import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmined.unplayable.init.KmUnplayableModMobEffects;
import net.mcreator.kraftmined.unplayable.init.KmUnplayableModAttributes;

public class OiledOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(KmUnplayableModMobEffects.OILED)) {
			if (entity.isInWaterRainOrBubble() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.GRAVITY))
					_livingEntity5.getAttribute(Attributes.GRAVITY)
							.setBaseValue(((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(KmUnplayableModAttributes.BASE_GRAVITY)
									? _livingEntity3.getAttribute(KmUnplayableModAttributes.BASE_GRAVITY).getBaseValue()
									: 0) * (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KmUnplayableModMobEffects.OILED) ? _livEnt.getEffect(KmUnplayableModMobEffects.OILED).getAmplifier() : 0) * (-1)));
				if (entity.isUnderWater() && (world.getBlockState(BlockPos.containing(x, y + 0.2, z))).getBlock() instanceof LiquidBlock) {
					entity.push(0, 0.2, 0);
				}
			} else if (!entity.isInWaterRainOrBubble()) {
				if (entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.GRAVITY))
					_livingEntity12.getAttribute(Attributes.GRAVITY)
							.setBaseValue((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(KmUnplayableModAttributes.BASE_GRAVITY)
									? _livingEntity11.getAttribute(KmUnplayableModAttributes.BASE_GRAVITY).getBaseValue()
									: 0));
			}
		}
	}
}
