
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.kraftmine.fluid.types.MilkBucketFluidType;
import net.mcreator.kraftmine.fluid.types.AcidFluidType;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, KraftmineMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> MILK_BUCKET_TYPE = REGISTRY.register("milk_bucket", () -> new MilkBucketFluidType());
	public static final DeferredHolder<FluidType, FluidType> ACID_TYPE = REGISTRY.register("acid", () -> new AcidFluidType());
}
