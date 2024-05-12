
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, KraftmineMod.MODID);
	public static final RegistryObject<SimpleParticleType> LIFESTEAL_PARTICLES = REGISTRY.register("lifesteal_particles", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BANEOF_METAPOD_PARTICLES = REGISTRY.register("baneof_metapod_particles", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIREFLY = REGISTRY.register("firefly", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> FIREFLYRIGHT = REGISTRY.register("fireflyright", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BUGS = REGISTRY.register("bugs", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> ACIDBUBBLE = REGISTRY.register("acidbubble", () -> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> BLOOD = REGISTRY.register("blood", () -> new SimpleParticleType(false));
}
