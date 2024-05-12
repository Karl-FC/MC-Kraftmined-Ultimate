
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.kraftmine.enchantment.SwiftfootedEnchantment;
import net.mcreator.kraftmine.enchantment.SuperstitiousEnchantment;
import net.mcreator.kraftmine.enchantment.StunningEnchantment;
import net.mcreator.kraftmine.enchantment.SlicingEnchantment;
import net.mcreator.kraftmine.enchantment.SaberSwingEnchantment;
import net.mcreator.kraftmine.enchantment.STABEnchantment;
import net.mcreator.kraftmine.enchantment.ReplenishmentEnchantment;
import net.mcreator.kraftmine.enchantment.ReconstructionEnchantment;
import net.mcreator.kraftmine.enchantment.MagicianSecretEnchantment;
import net.mcreator.kraftmine.enchantment.LifestealEnchantment;
import net.mcreator.kraftmine.enchantment.HoldupEnchantment;
import net.mcreator.kraftmine.enchantment.GuardingStrikeEnchantment;
import net.mcreator.kraftmine.enchantment.EfficacyEnchantment;
import net.mcreator.kraftmine.enchantment.DyingPanEnchantment;
import net.mcreator.kraftmine.enchantment.ConjuringEnchantment;
import net.mcreator.kraftmine.enchantment.CommittedEnchantment;
import net.mcreator.kraftmine.enchantment.BonusStrikeEnchantment;
import net.mcreator.kraftmine.enchantment.BleedingEdgeEnchantment;
import net.mcreator.kraftmine.enchantment.BaneofMetapodEnchantment;
import net.mcreator.kraftmine.enchantment.BackstabbingEnchantment;
import net.mcreator.kraftmine.enchantment.AntibacEnchantment;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, KraftmineMod.MODID);
	public static final RegistryObject<Enchantment> SABER_SWING = REGISTRY.register("saber_swing", () -> new SaberSwingEnchantment());
	public static final RegistryObject<Enchantment> BANEOF_METAPOD = REGISTRY.register("baneof_metapod", () -> new BaneofMetapodEnchantment());
	public static final RegistryObject<Enchantment> LIFESTEAL = REGISTRY.register("lifesteal", () -> new LifestealEnchantment());
	public static final RegistryObject<Enchantment> DYING_PAN = REGISTRY.register("dying_pan", () -> new DyingPanEnchantment());
	public static final RegistryObject<Enchantment> RECONSTRUCTION = REGISTRY.register("reconstruction", () -> new ReconstructionEnchantment());
	public static final RegistryObject<Enchantment> CONJURING = REGISTRY.register("conjuring", () -> new ConjuringEnchantment());
	public static final RegistryObject<Enchantment> REPLENISHMENT = REGISTRY.register("replenishment", () -> new ReplenishmentEnchantment());
	public static final RegistryObject<Enchantment> EFFICACY = REGISTRY.register("efficacy", () -> new EfficacyEnchantment());
	public static final RegistryObject<Enchantment> BLEEDING_EDGE = REGISTRY.register("bleeding_edge", () -> new BleedingEdgeEnchantment());
	public static final RegistryObject<Enchantment> STUNNING = REGISTRY.register("stunning", () -> new StunningEnchantment());
	public static final RegistryObject<Enchantment> SLICING = REGISTRY.register("slicing", () -> new SlicingEnchantment());
	public static final RegistryObject<Enchantment> STAB = REGISTRY.register("stab", () -> new STABEnchantment());
	public static final RegistryObject<Enchantment> HOLDUP = REGISTRY.register("holdup", () -> new HoldupEnchantment());
	public static final RegistryObject<Enchantment> COMMITTED = REGISTRY.register("committed", () -> new CommittedEnchantment());
	public static final RegistryObject<Enchantment> ANTIBAC = REGISTRY.register("antibac", () -> new AntibacEnchantment());
	public static final RegistryObject<Enchantment> BACKSTABBING = REGISTRY.register("backstabbing", () -> new BackstabbingEnchantment());
	public static final RegistryObject<Enchantment> SWIFTFOOTED = REGISTRY.register("swiftfooted", () -> new SwiftfootedEnchantment());
	public static final RegistryObject<Enchantment> SUPERSTITIOUS = REGISTRY.register("superstitious", () -> new SuperstitiousEnchantment());
	public static final RegistryObject<Enchantment> MAGICIAN_SECRET = REGISTRY.register("magician_secret", () -> new MagicianSecretEnchantment());
	public static final RegistryObject<Enchantment> BONUS_STRIKE = REGISTRY.register("bonus_strike", () -> new BonusStrikeEnchantment());
	public static final RegistryObject<Enchantment> GUARDING_STRIKE = REGISTRY.register("guarding_strike", () -> new GuardingStrikeEnchantment());
}
