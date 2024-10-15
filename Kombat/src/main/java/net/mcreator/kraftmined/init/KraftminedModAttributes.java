
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.kraftmined.KraftminedMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class KraftminedModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(BuiltInRegistries.ATTRIBUTE, KraftminedMod.MODID);
	public static final DeferredHolder<Attribute, Attribute> BUFFED = REGISTRY.register("buffed", () -> new RangedAttribute("attribute.kraftmined.buffed", 0, 0, 1).setSyncable(true));
	public static final DeferredHolder<Attribute, Attribute> ENHANCED = REGISTRY.register("enhanced", () -> new RangedAttribute("attribute.kraftmined.enhanced", 0, 0, 1).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, BUFFED));
		event.getTypes().forEach(entity -> event.add(entity, ENHANCED));
	}
}
