
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.kraftmined.KraftminedMod;

public class KraftminedModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, KraftminedMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LIFESTEAL_PARTICLES = REGISTRY.register("lifesteal_particles", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BANEOF_METAPOD_PARTICLES = REGISTRY.register("baneof_metapod_particles", () -> new SimpleParticleType(false));
}
