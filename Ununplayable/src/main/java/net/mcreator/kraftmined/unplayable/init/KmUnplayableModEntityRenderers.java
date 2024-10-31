
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmined.unplayable.client.renderer.GooseRenderer;
import net.mcreator.kraftmined.unplayable.client.renderer.FlyingSquidRenderer;
import net.mcreator.kraftmined.unplayable.client.renderer.BigRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KmUnplayableModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(KmUnplayableModEntities.BIG.get(), BigRenderer::new);
		event.registerEntityRenderer(KmUnplayableModEntities.GOOSE.get(), GooseRenderer::new);
		event.registerEntityRenderer(KmUnplayableModEntities.FLYING_SQUID.get(), FlyingSquidRenderer::new);
	}
}
