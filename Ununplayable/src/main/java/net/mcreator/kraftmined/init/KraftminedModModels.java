
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmined.client.model.Modelflying_squid;
import net.mcreator.kraftmined.client.model.Modelbig;
import net.mcreator.kraftmined.client.model.ModelGoose;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KraftminedModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelGoose.LAYER_LOCATION, ModelGoose::createBodyLayer);
		event.registerLayerDefinition(Modelflying_squid.LAYER_LOCATION, Modelflying_squid::createBodyLayer);
		event.registerLayerDefinition(Modelbig.LAYER_LOCATION, Modelbig::createBodyLayer);
	}
}
