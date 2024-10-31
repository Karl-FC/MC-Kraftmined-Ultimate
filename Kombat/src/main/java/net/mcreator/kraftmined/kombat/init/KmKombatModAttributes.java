
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.kraftmined.kombat.KmKombatMod;

import java.util.stream.Collectors;
import java.util.List;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KmKombatModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, KmKombatMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> BUFFED = REGISTRY.register("buffed", () -> new RangedAttribute("attribute.km_kombat.buffed", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> ENHANCED = REGISTRY.register("enhanced", () -> new RangedAttribute("attribute.km_kombat.enhanced", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> BUFF_LEVEL = REGISTRY.register("buff_level", () -> new RangedAttribute("attribute.km_kombat.buff_level", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> DUMMY_MODE = REGISTRY.register("dummy_mode", () -> new RangedAttribute("attribute.km_kombat.dummy_mode", 0, 0, 3).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, BUFFED));
		event.getTypes().forEach(entity -> event.add(entity, ENHANCED));
		event.getTypes().forEach(entity -> event.add(entity, BUFF_LEVEL));
		List.of(KmKombatModEntities.TEST_DUMMY.get()).stream().filter(DefaultAttributes::hasSupplier).map(entityType -> (EntityType<? extends LivingEntity>) entityType).collect(Collectors.toList()).forEach(entity -> event.add(entity, DUMMY_MODE));
	}
}
