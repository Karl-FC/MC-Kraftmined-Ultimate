
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.kraftmined.unplayable.fluid.types.MilkFluidType;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, KmUnplayableMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> MILK_TYPE = REGISTRY.register("milk", () -> new MilkFluidType());
}
