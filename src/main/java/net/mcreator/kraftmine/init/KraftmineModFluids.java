
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.kraftmine.fluid.MilkBucketFluid;
import net.mcreator.kraftmine.fluid.AcidFluid;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, KraftmineMod.MODID);
	public static final RegistryObject<FlowingFluid> MILK_BUCKET = REGISTRY.register("milk_bucket", () -> new MilkBucketFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_MILK_BUCKET = REGISTRY.register("flowing_milk_bucket", () -> new MilkBucketFluid.Flowing());
	public static final RegistryObject<FlowingFluid> ACID = REGISTRY.register("acid", () -> new AcidFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_ACID = REGISTRY.register("flowing_acid", () -> new AcidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(MILK_BUCKET.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MILK_BUCKET.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(ACID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_ACID.get(), RenderType.translucent());
		}
	}
}
