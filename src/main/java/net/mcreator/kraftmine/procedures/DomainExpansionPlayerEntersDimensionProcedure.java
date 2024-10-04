package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.entity.MickeyEntity;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class DomainExpansionPlayerEntersDimensionProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kraftmine:domain_expansion"))) {
			world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 2, y + 2, z + 2), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 3, y + 3, z + 3), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 4, y + 4, z + 4), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 5, y + 5, z + 5), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y + 6, z + 6), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 2, y + 7, z + 7), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 3, y + 8, z + 8), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 4, y + 9, z + 9), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 5, y + 10, z + 10), Blocks.AIR.defaultBlockState(), 3);
			if (KraftmineModVariables.WorldVariables.get(world).MickeyCD > 0) {
				KraftmineMod.queueServerWork(100, () -> {
					if (world instanceof ServerLevel _level) {
						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
						entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y + 3, z + 5)));
						entityToSpawn.setVisualOnly(true);
						_level.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"summon kraftmine:mickey ~ ~3 ~5");
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:theme.aot")), SoundSource.MUSIC, 5, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("kraftmine:theme.aot")), SoundSource.MUSIC, 5, 1, false);
						}
					}
					KraftmineMod.queueServerWork(20, () -> {
						if (((Entity) world.getEntitiesOfClass(MickeyEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9999, 2));
						if (((Entity) world.getEntitiesOfClass(MickeyEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 9999, 2));
						if (((Entity) world.getEntitiesOfClass(MickeyEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 9999, 2));
					});
				});
			}
		}
	}
}
