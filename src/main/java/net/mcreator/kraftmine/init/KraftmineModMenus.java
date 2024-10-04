
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, KraftmineMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<XPBankGUIMenu>> XP_BANK_GUI = REGISTRY.register("xp_bank_gui", () -> IMenuTypeExtension.create(XPBankGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuiverguiMenu>> QUIVERGUI = REGISTRY.register("quivergui", () -> IMenuTypeExtension.create(QuiverguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PossibilityShardGUIMenu>> POSSIBILITY_SHARD_GUI = REGISTRY.register("possibility_shard_gui", () -> IMenuTypeExtension.create(PossibilityShardGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<QuiverarmorGUIMenu>> QUIVERARMOR_GUI = REGISTRY.register("quiverarmor_gui", () -> IMenuTypeExtension.create(QuiverarmorGUIMenu::new));
}
