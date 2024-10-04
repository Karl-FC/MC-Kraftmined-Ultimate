package net.mcreator.kraftmine.item.inventory;

import net.neoforged.neoforge.items.ComponentItemHandler;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.neoforge.common.MutableDataComponentHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.client.gui.QuiverguiScreen;

import javax.annotation.Nonnull;

@EventBusSubscriber(Dist.CLIENT)
public class QuiverItemInventoryCapability extends ComponentItemHandler {
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onItemDropped(ItemTossEvent event) {
		if (event.getEntity().getItem().getItem() == KraftmineModItems.QUIVER_ITEM.get()) {
			if (Minecraft.getInstance().screen instanceof QuiverguiScreen) {
				Minecraft.getInstance().player.closeContainer();
			}
		}
	}

	public QuiverItemInventoryCapability(MutableDataComponentHolder parent) {
		super(parent, DataComponents.CONTAINER, 19);
	}

	@Override
	public int getSlotLimit(int slot) {
		return 64;
	}

	@Override
	public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
		return stack.getItem() != KraftmineModItems.QUIVER_ITEM.get();
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return super.getStackInSlot(slot).copy();
	}
}
