
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmine.client.particle.LifestealParticlesParticle;
import net.mcreator.kraftmine.client.particle.FireflyrightParticle;
import net.mcreator.kraftmine.client.particle.FireflyParticle;
import net.mcreator.kraftmine.client.particle.BugsParticle;
import net.mcreator.kraftmine.client.particle.BloodParticle;
import net.mcreator.kraftmine.client.particle.BaneofMetapodParticlesParticle;
import net.mcreator.kraftmine.client.particle.AcidbubbleParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KraftmineModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(KraftmineModParticleTypes.LIFESTEAL_PARTICLES.get(), LifestealParticlesParticle::provider);
		event.registerSpriteSet(KraftmineModParticleTypes.BANEOF_METAPOD_PARTICLES.get(), BaneofMetapodParticlesParticle::provider);
		event.registerSpriteSet(KraftmineModParticleTypes.FIREFLY.get(), FireflyParticle::provider);
		event.registerSpriteSet(KraftmineModParticleTypes.FIREFLYRIGHT.get(), FireflyrightParticle::provider);
		event.registerSpriteSet(KraftmineModParticleTypes.BUGS.get(), BugsParticle::provider);
		event.registerSpriteSet(KraftmineModParticleTypes.ACIDBUBBLE.get(), AcidbubbleParticle::provider);
		event.registerSpriteSet(KraftmineModParticleTypes.BLOOD.get(), BloodParticle::provider);
	}
}
