
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.potion.TimeFreezeMobEffect;
import net.mcreator.kraftmine.potion.ThirstyMobEffect;
import net.mcreator.kraftmine.potion.SusMobEffect;
import net.mcreator.kraftmine.potion.SplinteredMobEffect;
import net.mcreator.kraftmine.potion.SanitationMobEffect;
import net.mcreator.kraftmine.potion.RefreshedMobEffect;
import net.mcreator.kraftmine.potion.PotionCryMobEffect;
import net.mcreator.kraftmine.potion.NoUMobEffect;
import net.mcreator.kraftmine.potion.MilkedMobEffect;
import net.mcreator.kraftmine.potion.JumpscareEffectMobEffect;
import net.mcreator.kraftmine.potion.HelicopterMobEffect;
import net.mcreator.kraftmine.potion.GigaEffectMobEffect;
import net.mcreator.kraftmine.potion.GhostlyMobEffect;
import net.mcreator.kraftmine.potion.EyepatchOnEffectMobEffect;
import net.mcreator.kraftmine.potion.DripMobEffect;
import net.mcreator.kraftmine.potion.ConfusionMobEffect;
import net.mcreator.kraftmine.potion.BurnhealMobEffect;
import net.mcreator.kraftmine.potion.BleedEffectMobEffect;
import net.mcreator.kraftmine.potion.BeastmodeMobEffect;
import net.mcreator.kraftmine.potion.AntiHealMobEffect;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KraftmineMod.MODID);
	public static final RegistryObject<MobEffect> POTION_CRY = REGISTRY.register("potion_cry", () -> new PotionCryMobEffect());
	public static final RegistryObject<MobEffect> DRIP = REGISTRY.register("drip", () -> new DripMobEffect());
	public static final RegistryObject<MobEffect> JUMPSCARE_EFFECT = REGISTRY.register("jumpscare_effect", () -> new JumpscareEffectMobEffect());
	public static final RegistryObject<MobEffect> BLEED_EFFECT = REGISTRY.register("bleed_effect", () -> new BleedEffectMobEffect());
	public static final RegistryObject<MobEffect> EYEPATCH_ON_EFFECT = REGISTRY.register("eyepatch_on_effect", () -> new EyepatchOnEffectMobEffect());
	public static final RegistryObject<MobEffect> HELICOPTER = REGISTRY.register("helicopter", () -> new HelicopterMobEffect());
	public static final RegistryObject<MobEffect> THIRSTY = REGISTRY.register("thirsty", () -> new ThirstyMobEffect());
	public static final RegistryObject<MobEffect> HYDRATED = REGISTRY.register("hydrated", () -> new RefreshedMobEffect());
	public static final RegistryObject<MobEffect> SUS = REGISTRY.register("sus", () -> new SusMobEffect());
	public static final RegistryObject<MobEffect> TIME_FREEZE = REGISTRY.register("time_freeze", () -> new TimeFreezeMobEffect());
	public static final RegistryObject<MobEffect> SPLINTERED = REGISTRY.register("splintered", () -> new SplinteredMobEffect());
	public static final RegistryObject<MobEffect> ANTI_HEAL = REGISTRY.register("anti_heal", () -> new AntiHealMobEffect());
	public static final RegistryObject<MobEffect> GHOSTLY = REGISTRY.register("ghostly", () -> new GhostlyMobEffect());
	public static final RegistryObject<MobEffect> NO_U = REGISTRY.register("no_u", () -> new NoUMobEffect());
	public static final RegistryObject<MobEffect> SANITATION = REGISTRY.register("sanitation", () -> new SanitationMobEffect());
	public static final RegistryObject<MobEffect> BURNHEAL = REGISTRY.register("burnheal", () -> new BurnhealMobEffect());
	public static final RegistryObject<MobEffect> BEASTMODE = REGISTRY.register("beastmode", () -> new BeastmodeMobEffect());
	public static final RegistryObject<MobEffect> CONFUSION = REGISTRY.register("confusion", () -> new ConfusionMobEffect());
	public static final RegistryObject<MobEffect> MILKED = REGISTRY.register("milked", () -> new MilkedMobEffect());
	public static final RegistryObject<MobEffect> GIGA_EFFECT = REGISTRY.register("giga_effect", () -> new GigaEffectMobEffect());
}
