
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmined.encharted.client.particle.LifestealParticlesParticle;
import net.mcreator.kraftmined.encharted.client.particle.BaneofMetapodParticlesParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KmEnchartedModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(KmEnchartedModParticleTypes.LIFESTEAL_PARTICLES.get(), LifestealParticlesParticle::provider);
		event.registerSpriteSet(KmEnchartedModParticleTypes.BANEOF_METAPOD_PARTICLES.get(), BaneofMetapodParticlesParticle::provider);
	}
}
