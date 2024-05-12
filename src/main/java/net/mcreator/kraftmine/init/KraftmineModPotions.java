
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, KraftmineMod.MODID);
	public static final RegistryObject<Potion> TIME_FREEZE_POTION = REGISTRY.register("time_freeze_potion", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.TIME_FREEZE.get(), 3600, 0, true, true)));
	public static final RegistryObject<Potion> POTIONOF_KUNG_FU = REGISTRY.register("potionof_kung_fu", () -> new Potion(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 1, false, true),
			new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 2, false, true), new MobEffectInstance(KraftmineModMobEffects.DRIP.get(), 3600, 1, false, true)));
	public static final RegistryObject<Potion> SPIN = REGISTRY.register("spin", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.HELICOPTER.get(), 300, 1, false, true)));
	public static final RegistryObject<Potion> ANTI_POTIONOF_HEALING = REGISTRY.register("anti_potionof_healing", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.ANTI_HEAL.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> DRIP_POTION = REGISTRY.register("drip_potion", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.DRIP.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> HYDRATION_POTION = REGISTRY.register("hydration_potion", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.HYDRATED.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> SHINE_POTION = REGISTRY.register("shine_potion", () -> new Potion(new MobEffectInstance(MobEffects.GLOWING, 1200, 0, false, true)));
	public static final RegistryObject<Potion> POTION_FRESHNESS = REGISTRY.register("potion_freshness", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.SANITATION.get(), 2400, 0, false, true)));
	public static final RegistryObject<Potion> POTION_ROASTING = REGISTRY.register("potion_roasting", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.BURNHEAL.get(), 2400, 0, false, true)));
	public static final RegistryObject<Potion> POTION_BUTTERFLY = REGISTRY.register("potion_butterfly", () -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 100, 1, false, true),
			new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 0, false, true), new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, true)));
	public static final RegistryObject<Potion> POTION_MILK = REGISTRY.register("potion_milk", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.MILKED.get(), 60, 0, false, true)));
	public static final RegistryObject<Potion> POTION_CONFUSION = REGISTRY.register("potion_confusion", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.CONFUSION.get(), 600, 0, false, true)));
	public static final RegistryObject<Potion> POTION_TERRIFY = REGISTRY.register("potion_terrify", () -> new Potion(new MobEffectInstance(KraftmineModMobEffects.POTION_CRY.get(), 300, 0, false, true)));
}
