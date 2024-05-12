
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.kraftmine.client.gui.XPBankGUIScreen;
import net.mcreator.kraftmine.client.gui.QuiverguiScreen;
import net.mcreator.kraftmine.client.gui.QuiverarmorGUIScreen;
import net.mcreator.kraftmine.client.gui.PossibilityShardGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KraftmineModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(KraftmineModMenus.XP_BANK_GUI.get(), XPBankGUIScreen::new);
			MenuScreens.register(KraftmineModMenus.QUIVERGUI.get(), QuiverguiScreen::new);
			MenuScreens.register(KraftmineModMenus.POSSIBILITY_SHARD_GUI.get(), PossibilityShardGUIScreen::new);
			MenuScreens.register(KraftmineModMenus.QUIVERARMOR_GUI.get(), QuiverarmorGUIScreen::new);
		});
	}
}
