
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.kraftmine.client.gui.XPBankGUIScreen;
import net.mcreator.kraftmine.client.gui.QuiverguiScreen;
import net.mcreator.kraftmine.client.gui.QuiverarmorGUIScreen;
import net.mcreator.kraftmine.client.gui.PossibilityShardGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KraftmineModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(KraftmineModMenus.XP_BANK_GUI.get(), XPBankGUIScreen::new);
		event.register(KraftmineModMenus.QUIVERGUI.get(), QuiverguiScreen::new);
		event.register(KraftmineModMenus.POSSIBILITY_SHARD_GUI.get(), PossibilityShardGUIScreen::new);
		event.register(KraftmineModMenus.QUIVERARMOR_GUI.get(), QuiverarmorGUIScreen::new);
	}
}
