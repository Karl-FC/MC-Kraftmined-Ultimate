
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.kraftmine.network.ExtraUseButtonMessage;
import net.mcreator.kraftmine.network.DashMessage;
import net.mcreator.kraftmine.network.CombatUseMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class KraftmineModKeyMappings {
	public static final KeyMapping EXTRA_USE_BUTTON = new KeyMapping("key.kraftmine.extra_use_button", GLFW.GLFW_KEY_R, "key.categories.kraftmine") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new ExtraUseButtonMessage(0, 0));
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
				PacketDistributor.sendToServer(new CombatUseMessage(0, 0));
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
				PacketDistributor.sendToServer(new DashMessage(0, 0));
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

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				EXTRA_USE_BUTTON.consumeClick();
				COMBAT_USE.consumeClick();
				DASH.consumeClick();
			}
		}
	}
}
