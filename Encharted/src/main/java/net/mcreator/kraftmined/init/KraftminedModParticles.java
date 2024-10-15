
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmined.client.particle.LifestealParticlesParticle;
import net.mcreator.kraftmined.client.particle.BaneofMetapodParticlesParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KraftminedModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(KraftminedModParticleTypes.LIFESTEAL_PARTICLES.get(), LifestealParticlesParticle::provider);
		event.registerSpriteSet(KraftminedModParticleTypes.BANEOF_METAPOD_PARTICLES.get(), BaneofMetapodParticlesParticle::provider);
	}
}
