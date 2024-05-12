package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;
import java.util.Map;

public class QuiverarmorGUIThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double slotSpectral = 0;
		double slotTipped = 0;
		double slotArrow = 0;
		ItemStack quiver = ItemStack.EMPTY;
		quiver = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
		slotSpectral = 0;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.SPECTRAL_ARROW);
				_setstack.setCount((int) quiver.getOrCreateTag().getDouble(("arrow_spectral_amount" + slotSpectral)));
				((Slot) _slots.get((int) slotSpectral)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			slotSpectral = slotSpectral + 1;
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((quiver.getOrCreateTag().getString(("arrow_spectral" + slotSpectral)))), (false));
		}
		slotTipped = 3;
		for (int index1 = 0; index1 < (int) (3); index1++) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(((quiver.getOrCreateTag().getString(("arrow_tipped" + slotTipped)))).toLowerCase(java.util.Locale.ENGLISH))))
						.getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR)));
				_setstack.setCount((int) quiver.getOrCreateTag().getDouble(("arrow_tipped_amount" + slotTipped)));
				((Slot) _slots.get((int) slotTipped)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			slotTipped = slotTipped + 1;
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((quiver.getOrCreateTag().getString(("arrow_tipped" + slotTipped)))), (false));
		}
		slotArrow = 11;
		for (int index2 = 0; index2 < (int) (3); index2++) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.ARROW);
				_setstack.setCount((int) quiver.getOrCreateTag().getDouble(("arrow_basic_amount" + slotArrow)));
				((Slot) _slots.get((int) slotArrow)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			slotArrow = slotArrow + 1;
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal((quiver.getOrCreateTag().getString(("arrow_basic" + slotSpectral)))), (false));
		}
	}
}
