package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JungleZombieSkeletonProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof Zombie || sourceentity instanceof Skeleton)
				&& world.getBiome(new BlockPos(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ())).is(TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("minecraft:is_jungle")))) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1, (false), (false)));
		}
	}
}
