
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
	public static final DeferredHolder<Attribute, Attribute> COMMITTMENT = REGISTRY.register("committment", () -> new RangedAttribute("attribute.kraftmined.committment", 0, 0, 5).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.getTypes().forEach(entity -> event.add(entity, COMMITTMENT));
	}
}
