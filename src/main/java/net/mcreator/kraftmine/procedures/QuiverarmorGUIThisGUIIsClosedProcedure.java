package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

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
		for (int index0 = 0; index0 < 3; index0++) {
			{
				final String _tagName = ("arrow_spectral" + slotSpectral);
				final String _tagValue = "minecraft:spectral_arrow";
				CustomData.update(DataComponents.CUSTOM_DATA, quiver, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("arrow_spectral_amount" + slotSpectral);
				final double _tagValue = (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount((int) slotSpectral));
				CustomData.update(DataComponents.CUSTOM_DATA, quiver, tag -> tag.putDouble(_tagName, _tagValue));
			}
			slotSpectral = slotSpectral + 1;
		}
		slotTipped = 3;
		for (int index1 = 0; index1 < 9; index1++) {
			{
				final String _tagName = ("arrow_tipped" + slotTipped);
				final String _tagValue = "minecraft:tipped_arrow";
				CustomData.update(DataComponents.CUSTOM_DATA, quiver, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("arrow_tipped_amount" + slotTipped);
				final double _tagValue = (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount((int) slotTipped));
				CustomData.update(DataComponents.CUSTOM_DATA, quiver, tag -> tag.putDouble(_tagName, _tagValue));
			}
			slotTipped = slotTipped + 1;
		}
		slotArrow = 11;
		for (int index2 = 0; index2 < 9; index2++) {
			{
				final String _tagName = ("arrow_basic" + slotArrow);
				final String _tagValue = "minecraft:arrow";
				CustomData.update(DataComponents.CUSTOM_DATA, quiver, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = ("arrow_basic_amount" + slotArrow);
				final double _tagValue = (new Object() {
					public int getAmount(int sltid) {
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
							if (stack != null)
								return stack.getCount();
						}
						return 0;
					}
				}.getAmount((int) slotArrow));
				CustomData.update(DataComponents.CUSTOM_DATA, quiver, tag -> tag.putDouble(_tagName, _tagValue));
			}
			slotArrow = slotArrow + 1;
		}
	}
}
