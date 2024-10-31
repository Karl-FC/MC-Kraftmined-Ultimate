
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmined.encharted.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.kraftmined.encharted.item.InfiniteWaterbreathingItem;
import net.mcreator.kraftmined.encharted.item.InfiniteSwiftnessItem;
import net.mcreator.kraftmined.encharted.item.InfiniteStrengthItem;
import net.mcreator.kraftmined.encharted.item.InfiniteSlowfallingItem;
import net.mcreator.kraftmined.encharted.item.InfiniteSaturationItem;
import net.mcreator.kraftmined.encharted.item.InfiniteResistanceItem;
import net.mcreator.kraftmined.encharted.item.InfiniteNightvisionItem;
import net.mcreator.kraftmined.encharted.item.InfiniteLeapingItem;
import net.mcreator.kraftmined.encharted.item.InfiniteInvisibilityItem;
import net.mcreator.kraftmined.encharted.item.InfiniteHealItem;
import net.mcreator.kraftmined.encharted.item.InfiniteFireresistanceItem;
import net.mcreator.kraftmined.encharted.KmEnchartedMod;

public class KmEnchartedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(KmEnchartedMod.MODID);
	public static final DeferredItem<Item> INFINITE_HEAL = REGISTRY.register("infinite_heal", InfiniteHealItem::new);
	public static final DeferredItem<Item> INFINITE_RESISTANCE = REGISTRY.register("infinite_resistance", InfiniteResistanceItem::new);
	public static final DeferredItem<Item> INFINITE_SLOWFALLING = REGISTRY.register("infinite_slowfalling", InfiniteSlowfallingItem::new);
	public static final DeferredItem<Item> INFINITE_FIRERESISTANCE = REGISTRY.register("infinite_fireresistance", InfiniteFireresistanceItem::new);
	public static final DeferredItem<Item> INFINITE_STRENGTH = REGISTRY.register("infinite_strength", InfiniteStrengthItem::new);
	public static final DeferredItem<Item> INFINITE_INVISIBILITY = REGISTRY.register("infinite_invisibility", InfiniteInvisibilityItem::new);
	public static final DeferredItem<Item> INFINITE_NIGHTVISION = REGISTRY.register("infinite_nightvision", InfiniteNightvisionItem::new);
	public static final DeferredItem<Item> INFINITE_WATERBREATHING = REGISTRY.register("infinite_waterbreathing", InfiniteWaterbreathingItem::new);
	public static final DeferredItem<Item> INFINITE_SATURATION = REGISTRY.register("infinite_saturation", InfiniteSaturationItem::new);
	public static final DeferredItem<Item> INFINITE_SWIFTNESS = REGISTRY.register("infinite_swiftness", InfiniteSwiftnessItem::new);
	public static final DeferredItem<Item> INFINITE_LEAPING = REGISTRY.register("infinite_leaping", InfiniteLeapingItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
