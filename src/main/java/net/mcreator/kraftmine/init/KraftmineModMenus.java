
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.kraftmine.world.inventory.XPBankGUIMenu;
import net.mcreator.kraftmine.world.inventory.QuiverguiMenu;
import net.mcreator.kraftmine.world.inventory.QuiverarmorGUIMenu;
import net.mcreator.kraftmine.world.inventory.PossibilityShardGUIMenu;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, KraftmineMod.MODID);
	public static final RegistryObject<MenuType<XPBankGUIMenu>> XP_BANK_GUI = REGISTRY.register("xp_bank_gui", () -> IForgeMenuType.create(XPBankGUIMenu::new));
	public static final RegistryObject<MenuType<QuiverguiMenu>> QUIVERGUI = REGISTRY.register("quivergui", () -> IForgeMenuType.create(QuiverguiMenu::new));
	public static final RegistryObject<MenuType<PossibilityShardGUIMenu>> POSSIBILITY_SHARD_GUI = REGISTRY.register("possibility_shard_gui", () -> IForgeMenuType.create(PossibilityShardGUIMenu::new));
	public static final RegistryObject<MenuType<QuiverarmorGUIMenu>> QUIVERARMOR_GUI = REGISTRY.register("quiverarmor_gui", () -> IForgeMenuType.create(QuiverarmorGUIMenu::new));
}
