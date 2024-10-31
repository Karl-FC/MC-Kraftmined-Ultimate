
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

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

import net.mcreator.kraftmined.kombat.entity.TestDummyEntity;
import net.mcreator.kraftmined.kombat.KmKombatMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmKombatModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, KmKombatMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<TestDummyEntity>> TEST_DUMMY = register("test_dummy",
			EntityType.Builder.<TestDummyEntity>of(TestDummyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.85f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		TestDummyEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TEST_DUMMY.get(), TestDummyEntity.createAttributes().build());
	}
}
