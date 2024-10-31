
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.unplayable.init;

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

import net.mcreator.kraftmined.unplayable.fluid.MilkFluid;
import net.mcreator.kraftmined.unplayable.KmUnplayableMod;

public class KmUnplayableModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, KmUnplayableMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> MILK = REGISTRY.register("milk", () -> new MilkFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MILK = REGISTRY.register("flowing_milk", () -> new MilkFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(MILK.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MILK.get(), RenderType.translucent());
		}
	}
}
