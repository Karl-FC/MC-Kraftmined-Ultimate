package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.kraftmine.entity.MickeyEntity;

import java.util.List;
import java.util.Comparator;
import java.util.Calendar;

public class DomainAttacksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ResourceKey<Level> dimension, Entity entity, Entity sourceentity) {
		if (dimension == null || entity == null || sourceentity == null)
			return;
		double AttackType = 0;
		double playerx = 0;
		double playery = 0;
		double playerz = 0;
		if (entity instanceof MickeyEntity && ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:domain_expansion"))
				|| dimension == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:domain_expansion")))) {
			AttackType = Calendar.getInstance().get(Calendar.SECOND);
			if (AttackType == 10) {
				sourceentity.igniteForSeconds(5);
			}
			if (AttackType == 20) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "summon lightning_bolt");
							}
						}
					}
				}
			}
			if (AttackType == 30) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
			}
			if (AttackType == 40) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
			}
			if (AttackType == 50) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 20, 5));
			}
			if (AttackType == 59) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
			}
		}
	}
}
