package net.mcreator.kraftmine.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.kraftmine.world.inventory.PossibilityShardGUIMenu;
import net.mcreator.kraftmine.network.PossibilityShardGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PossibilityShardGUIScreen extends AbstractContainerScreen<PossibilityShardGUIMenu> {
	private final static HashMap<String, Object> guistate = PossibilityShardGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_overworld;
	Button button_nether;
	Button button_the_end;

	public PossibilityShardGUIScreen(PossibilityShardGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 266;
		this.imageHeight = 138;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("kraftmine:textures/screens/possibility_shard_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("kraftmine:textures/screens/amogus_blue.png"), this.leftPos + 13, this.topPos + 29, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(ResourceLocation.parse("kraftmine:textures/screens/amogus_green.png"), this.leftPos + 94, this.topPos + 29, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(ResourceLocation.parse("kraftmine:textures/screens/amogus_red.png"), this.leftPos + 175, this.topPos + 29, 0, 0, 64, 64, 64, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.kraftmine.possibility_shard_gui.label_travel_to_possible_realms"), 67, 11, -6724096, false);
	}

	@Override
	public void init() {
		super.init();
		button_overworld = Button.builder(Component.translatable("gui.kraftmine.possibility_shard_gui.button_overworld"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PossibilityShardGUIButtonMessage(0, x, y, z));
				PossibilityShardGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 91, this.topPos + 101, 72, 20).build();
		guistate.put("button:button_overworld", button_overworld);
		this.addRenderableWidget(button_overworld);
		button_nether = Button.builder(Component.translatable("gui.kraftmine.possibility_shard_gui.button_nether"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PossibilityShardGUIButtonMessage(1, x, y, z));
				PossibilityShardGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 17, this.topPos + 101, 56, 20).build();
		guistate.put("button:button_nether", button_nether);
		this.addRenderableWidget(button_nether);
		button_the_end = Button.builder(Component.translatable("gui.kraftmine.possibility_shard_gui.button_the_end"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new PossibilityShardGUIButtonMessage(2, x, y, z));
				PossibilityShardGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 177, this.topPos + 101, 61, 20).build();
		guistate.put("button:button_the_end", button_the_end);
		this.addRenderableWidget(button_the_end);
	}
}
