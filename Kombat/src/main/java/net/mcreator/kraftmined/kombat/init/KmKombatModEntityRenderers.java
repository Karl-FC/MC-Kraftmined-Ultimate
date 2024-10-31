
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.kombat.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmined.kombat.client.renderer.TestDummyRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KmKombatModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(KmKombatModEntities.TEST_DUMMY.get(), TestDummyRenderer::new);
	}
}
