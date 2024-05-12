package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.kraftmine.entity.Nextbot9Entity;
import net.mcreator.kraftmine.entity.Nextbot8Entity;
import net.mcreator.kraftmine.entity.Nextbot7Entity;
import net.mcreator.kraftmine.entity.Nextbot6Entity;
import net.mcreator.kraftmine.entity.Nextbot5Entity;
import net.mcreator.kraftmine.entity.Nextbot4Entity;
import net.mcreator.kraftmine.entity.Nextbot3Entity;
import net.mcreator.kraftmine.entity.Nextbot2Entity;
import net.mcreator.kraftmine.entity.Nextbot1Entity;
import net.mcreator.kraftmine.entity.Nextbot11Entity;
import net.mcreator.kraftmine.entity.Nextbot10Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NextbotTargetsProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingSetAttackTargetEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity front = null;
		Entity back = null;
		if (sourceentity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:nextbot_tags"))) && entity instanceof Player) {
			sourceentity.getPersistentData().putBoolean("locked", (true));
			if (!world.getEntitiesOfClass(Nextbot1Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot2Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot3Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot4Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot5Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot6Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot7Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot8Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot9Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot10Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			} else if (!world.getEntitiesOfClass(Nextbot11Entity.class,
					AABB.ofSize(
							new Vec3((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(16)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
							5, 5, 5),
					e -> true).isEmpty()) {
				NextbotTargetlockProcedure.execute(world, x, y, z, sourceentity);
			}
		}
	}
}
