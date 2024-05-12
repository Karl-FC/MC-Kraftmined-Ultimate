
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.kraftmine.client.particle.LifestealParticlesParticle;
import net.mcreator.kraftmine.client.particle.FireflyrightParticle;
import net.mcreator.kraftmine.client.particle.FireflyParticle;
import net.mcreator.kraftmine.client.particle.BugsParticle;
import net.mcreator.kraftmine.client.particle.BloodParticle;
import net.mcreator.kraftmine.client.particle.BaneofMetapodParticlesParticle;
import net.mcreator.kraftmine.client.particle.AcidbubbleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KraftmineModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(KraftmineModParticleTypes.LIFESTEAL_PARTICLES.get(), LifestealParticlesParticle::provider);
		event.register(KraftmineModParticleTypes.BANEOF_METAPOD_PARTICLES.get(), BaneofMetapodParticlesParticle::provider);
		event.register(KraftmineModParticleTypes.FIREFLY.get(), FireflyParticle::provider);
		event.register(KraftmineModParticleTypes.FIREFLYRIGHT.get(), FireflyrightParticle::provider);
		event.register(KraftmineModParticleTypes.BUGS.get(), BugsParticle::provider);
		event.register(KraftmineModParticleTypes.ACIDBUBBLE.get(), AcidbubbleParticle::provider);
		event.register(KraftmineModParticleTypes.BLOOD.get(), BloodParticle::provider);
	}
}
