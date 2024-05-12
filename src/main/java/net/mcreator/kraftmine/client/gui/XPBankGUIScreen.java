package net.mcreator.kraftmine.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.world.inventory.XPBankGUIMenu;
import net.mcreator.kraftmine.network.XPBankGUIButtonMessage;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class XPBankGUIScreen extends AbstractContainerScreen<XPBankGUIMenu> {
	private final static HashMap<String, Object> guistate = XPBankGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox XPStoredCount;
	Button button_deposit_all;
	Button button_claim_all;
	Button button_1;
	Button button_5;
	Button button_10;
	Button button_11;
	Button button_51;
	Button button_101;
	Button button_20;
	Button button_201;

	public XPBankGUIScreen(XPBankGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 294;
		this.imageHeight = 190;
	}

	private static final ResourceLocation texture = new ResourceLocation("kraftmine:textures/screens/xp_bank_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		XPStoredCount.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (XPStoredCount.isFocused())
			return XPStoredCount.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		XPStoredCount.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.kraftmine.xp_bank_gui.label_deposit"), 43, 77, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.kraftmine.xp_bank_gui.label_claim"), 204, 77, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.kraftmine.xp_bank_gui.label_stored_xp_levels"), 24, 36, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.kraftmine.xp_bank_gui.label_xp_bank"), 126, 8, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		XPStoredCount = new EditBox(this.font, this.leftPos + 136, this.topPos + 32, 120, 20, Component.translatable("gui.kraftmine.xp_bank_gui.XPStoredCount")) {
			{
				setSuggestion(Component.translatable("gui.kraftmine.xp_bank_gui.XPStoredCount").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.kraftmine.xp_bank_gui.XPStoredCount").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.kraftmine.xp_bank_gui.XPStoredCount").getString());
				else
					setSuggestion(null);
			}
		};
		XPStoredCount.setMaxLength(32767);
		guistate.put("text:XPStoredCount", XPStoredCount);
		this.addWidget(this.XPStoredCount);
		button_deposit_all = new Button(this.leftPos + 33, this.topPos + 157, 82, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_deposit_all"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(0, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_deposit_all", button_deposit_all);
		this.addRenderableWidget(button_deposit_all);
		button_claim_all = new Button(this.leftPos + 185, this.topPos + 158, 72, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_claim_all"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(1, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_claim_all", button_claim_all);
		this.addRenderableWidget(button_claim_all);
		button_1 = new Button(this.leftPos + 32, this.topPos + 98, 30, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_1"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(2, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_5 = new Button(this.leftPos + 83, this.topPos + 98, 30, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_5"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(3, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_5", button_5);
		this.addRenderableWidget(button_5);
		button_10 = new Button(this.leftPos + 27, this.topPos + 131, 35, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_10"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(4, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_10", button_10);
		this.addRenderableWidget(button_10);
		button_11 = new Button(this.leftPos + 183, this.topPos + 98, 30, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_11"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(5, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_11", button_11);
		this.addRenderableWidget(button_11);
		button_51 = new Button(this.leftPos + 230, this.topPos + 98, 30, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_51"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(6, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_51", button_51);
		this.addRenderableWidget(button_51);
		button_101 = new Button(this.leftPos + 177, this.topPos + 131, 35, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_101"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(7, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:button_101", button_101);
		this.addRenderableWidget(button_101);
		button_20 = new Button(this.leftPos + 83, this.topPos + 131, 35, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_20"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(8, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:button_20", button_20);
		this.addRenderableWidget(button_20);
		button_201 = new Button(this.leftPos + 230, this.topPos + 131, 35, 20, Component.translatable("gui.kraftmine.xp_bank_gui.button_201"), e -> {
			if (true) {
				KraftmineMod.PACKET_HANDLER.sendToServer(new XPBankGUIButtonMessage(9, x, y, z));
				XPBankGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:button_201", button_201);
		this.addRenderableWidget(button_201);
	}
}
