
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmined.unplayable.entity.GooseEntity;
import net.mcreator.kraftmined.unplayable.entity.FlyingSquidEntity;
import net.mcreator.kraftmined.unplayable.entity.BigEntity;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmUnplayableModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, KmUnplayableMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<BigEntity>> BIG = register("big", EntityType.Builder.<BigEntity>of(BigEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.7f, 0.6f));
	public static final DeferredHolder<EntityType<?>, EntityType<GooseEntity>> GOOSE = register("goose",
			EntityType.Builder.<GooseEntity>of(GooseEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.5f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlyingSquidEntity>> FLYING_SQUID = register("flying_squid",
			EntityType.Builder.<FlyingSquidEntity>of(FlyingSquidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.8f, 0.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		BigEntity.init(event);
		GooseEntity.init(event);
		FlyingSquidEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BIG.get(), BigEntity.createAttributes().build());
		event.put(GOOSE.get(), GooseEntity.createAttributes().build());
		event.put(FLYING_SQUID.get(), FlyingSquidEntity.createAttributes().build());
	}
}
