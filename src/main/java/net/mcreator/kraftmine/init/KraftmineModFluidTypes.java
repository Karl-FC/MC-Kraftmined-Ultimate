
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.kraftmine.fluid.types.MilkBucketFluidType;
import net.mcreator.kraftmine.fluid.types.AcidFluidType;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, KraftmineMod.MODID);
	public static final RegistryObject<FluidType> MILK_BUCKET_TYPE = REGISTRY.register("milk_bucket", () -> new MilkBucketFluidType());
	public static final RegistryObject<FluidType> ACID_TYPE = REGISTRY.register("acid", () -> new AcidFluidType());
}
