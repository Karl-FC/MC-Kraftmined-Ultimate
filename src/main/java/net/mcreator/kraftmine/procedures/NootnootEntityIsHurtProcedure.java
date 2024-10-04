package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.entity.PenguinbigEntity;
import net.mcreator.kraftmine.entity.PenguinEntity;

import java.util.List;
import java.util.Comparator;

public class NootnootEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity pingu = null;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 250 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 200) {
			pingu = entity;
			pingu.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:pingu.die")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:pingu.die")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (entityiterator instanceof PenguinbigEntity || entityiterator instanceof PenguinEntity) {
						for (int index0 = 0; index0 < 4; index0++) {
							entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.STARVE)), 10);
							if (pingu instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 10));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 5, 2, 2, 2, 1);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, (pingu.getX()), (pingu.getY()), (pingu.getZ()), 5, 2, 2, 2, 1);
						}
					}
				}
			}
		}
	}
}
