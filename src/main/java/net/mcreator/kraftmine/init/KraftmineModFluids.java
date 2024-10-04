
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.kraftmine.fluid.MilkBucketFluid;
import net.mcreator.kraftmine.fluid.AcidFluid;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, KraftmineMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> MILK_BUCKET = REGISTRY.register("milk_bucket", () -> new MilkBucketFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MILK_BUCKET = REGISTRY.register("flowing_milk_bucket", () -> new MilkBucketFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> ACID = REGISTRY.register("acid", () -> new AcidFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_ACID = REGISTRY.register("flowing_acid", () -> new AcidFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(MILK_BUCKET.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MILK_BUCKET.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ACID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ACID.get(), RenderType.translucent());
		}
	}
}
