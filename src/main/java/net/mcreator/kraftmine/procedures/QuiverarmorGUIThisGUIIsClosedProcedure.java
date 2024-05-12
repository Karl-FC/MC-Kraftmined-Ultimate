package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import java.util.function.Supplier;
import java.util.Map;

public class QuiverarmorGUIThisGUIIsClosedProcedure {
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
			quiver.getOrCreateTag().putString(("arrow_spectral" + slotSpectral), "minecraft:spectral_arrow");
			quiver.getOrCreateTag().putDouble(("arrow_spectral_amount" + slotSpectral), (new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount((int) slotSpectral)));
			slotSpectral = slotSpectral + 1;
		}
		slotTipped = 3;
		for (int index1 = 0; index1 < (int) (9); index1++) {
			quiver.getOrCreateTag().putString(("arrow_tipped" + slotTipped), "minecraft:tipped_arrow");
			quiver.getOrCreateTag().putDouble(("arrow_tipped_amount" + slotTipped), (new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount((int) slotTipped)));
			slotTipped = slotTipped + 1;
		}
		slotArrow = 11;
		for (int index2 = 0; index2 < (int) (9); index2++) {
			quiver.getOrCreateTag().putString(("arrow_basic" + slotArrow), "minecraft:arrow");
			quiver.getOrCreateTag().putDouble(("arrow_basic_amount" + slotArrow), (new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount((int) slotArrow)));
			slotArrow = slotArrow + 1;
		}
	}
}
