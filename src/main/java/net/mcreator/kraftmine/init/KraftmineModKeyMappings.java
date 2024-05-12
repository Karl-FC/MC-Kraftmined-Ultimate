
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.kraftmine.network.ExtraUseButtonMessage;
import net.mcreator.kraftmine.network.DashMessage;
import net.mcreator.kraftmine.network.CombatUseMessage;
import net.mcreator.kraftmine.KraftmineMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KraftmineModKeyMappings {
	public static final KeyMapping EXTRA_USE_BUTTON = new KeyMapping("key.kraftmine.extra_use_button", GLFW.GLFW_KEY_R, "key.categories.kraftmine") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new ExtraUseButtonMessage(0, 0));
				ExtraUseButtonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping COMBAT_USE = new KeyMapping("key.kraftmine.combat_use", GLFW.GLFW_KEY_V, "key.categories.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new CombatUseMessage(0, 0));
				CombatUseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DASH = new KeyMapping("key.kraftmine.dash", GLFW.GLFW_KEY_C, "key.categories.kraftmine") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new DashMessage(0, 0));
				DashMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(EXTRA_USE_BUTTON);
		event.register(COMBAT_USE);
		event.register(DASH);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				EXTRA_USE_BUTTON.consumeClick();
				COMBAT_USE.consumeClick();
				DASH.consumeClick();
			}
		}
	}
}
