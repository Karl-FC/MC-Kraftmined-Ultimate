
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmined.client.renderer.GooseRenderer;
import net.mcreator.kraftmined.client.renderer.FlyingSquidRenderer;
import net.mcreator.kraftmined.client.renderer.BigRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KraftminedModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(KraftminedModEntities.BIG.get(), BigRenderer::new);
		event.registerEntityRenderer(KraftminedModEntities.GOOSE.get(), GooseRenderer::new);
		event.registerEntityRenderer(KraftminedModEntities.FLYING_SQUID.get(), FlyingSquidRenderer::new);
	}
}
