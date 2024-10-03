
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, KraftmineMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LIFESTEAL_PARTICLES = REGISTRY.register("lifesteal_particles", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BANEOF_METAPOD_PARTICLES = REGISTRY.register("baneof_metapod_particles", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLY = REGISTRY.register("firefly", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FIREFLYRIGHT = REGISTRY.register("fireflyright", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BUGS = REGISTRY.register("bugs", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ACIDBUBBLE = REGISTRY.register("acidbubble", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(false));
}
