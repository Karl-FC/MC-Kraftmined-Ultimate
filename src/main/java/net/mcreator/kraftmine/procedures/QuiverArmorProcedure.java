package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModItems;

import java.util.concurrent.atomic.AtomicReference;

public class QuiverArmorProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double SpectralSlot = 0;
		double SpectralInv = 0;
		double TippedSlot = 0;
		double TippedInv = 0;
		double ArrowSlot = 0;
		double ArrowInv = 0;
		double slotSpectral = 0;
		double slotTipped = 0;
		double slotArrow = 0;
		ItemStack quiver = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.QUIVER_ARMOR_CHESTPLATE.get()) {
			quiver = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.SPECTRAL_ARROW)) : false) {
				SpectralSlot = 0;
				for (int index0 = 0; index0 < (int) (3); index0++) {
					if (Items.SPECTRAL_ARROW == Items.SPECTRAL_ARROW) {
						SpectralInv = 0;
						for (int index1 = 0; index1 < (int) (36); index1++) {
							if ((new Object() {
								public ItemStack getItemStack(int sltid, ItemStack _isc) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) SpectralInv, itemstack)).getItem() == Items.SPECTRAL_ARROW && ((new Object() {
								public ItemStack getItemStack(int sltid, ItemStack _isc) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) SpectralInv, itemstack))).getCount() < 64) {
								{
									final int _slotid = (int) SpectralInv;
									final ItemStack _setstack = new ItemStack(Items.SPECTRAL_ARROW);
									_setstack.setCount((int) (((new Object() {
										public ItemStack getItemStack(int sltid, ItemStack _isc) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack((int) SpectralInv, itemstack))).getCount() + 1));
									entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable _modHandler)
											_modHandler.setStackInSlot(_slotid, _setstack);
									});
								}
								quiver.getOrCreateTag().putDouble(("arrow_spectral_amount" + SpectralSlot), (quiver.getOrCreateTag().getDouble(("arrow_spectral_amount" + SpectralSlot)) - 1));
							}
							SpectralInv = SpectralInv + 1;
						}
					}
					SpectralSlot = SpectralSlot + 1;
				}
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.TIPPED_ARROW)) : false) {
				TippedSlot = 3;
				for (int index2 = 0; index2 < (int) (9); index2++) {
					if ((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(((quiver.getOrCreateTag().getString(("arrow_tipped" + TippedSlot)))).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create())
							.orElseGet(() -> Items.AIR)) == Items.TIPPED_ARROW) {
						TippedInv = 0;
						for (int index3 = 0; index3 < (int) (36); index3++) {
							if ((new Object() {
								public ItemStack getItemStack(int sltid, ItemStack _isc) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) TippedInv, itemstack)).getItem() == Items.TIPPED_ARROW && ((new Object() {
								public ItemStack getItemStack(int sltid, ItemStack _isc) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) TippedInv, itemstack))).getCount() < 64) {
								{
									final int _slotid = (int) TippedInv;
									final ItemStack _setstack = (new Object() {
										public ItemStack getItemStack(int sltid, ItemStack _isc) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack((int) TippedInv, itemstack));
									_setstack.setCount((int) (((new Object() {
										public ItemStack getItemStack(int sltid, ItemStack _isc) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack((int) TippedInv, itemstack))).getCount() + 1));
									entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable _modHandler)
											_modHandler.setStackInSlot(_slotid, _setstack);
									});
								}
								quiver.getOrCreateTag().putDouble(("arrow_tipped_amount" + TippedSlot), (quiver.getOrCreateTag().getDouble(("arrow_tipped_amount" + TippedSlot)) - 1));
							}
							TippedInv = TippedInv + 1;
						}
					}
					TippedSlot = TippedSlot + 1;
				}
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.ARROW)) : false) {
				ArrowSlot = 11;
				for (int index4 = 0; index4 < (int) (9); index4++) {
					if ((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(((quiver.getOrCreateTag().getString(("arrow_basic" + ArrowSlot)))).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create())
							.orElseGet(() -> Items.AIR)) == Items.ARROW) {
						ArrowInv = 0;
						for (int index5 = 0; index5 < (int) (36); index5++) {
							if ((new Object() {
								public ItemStack getItemStack(int sltid, ItemStack _isc) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) ArrowInv, itemstack)).getItem() == Items.ARROW && ((new Object() {
								public ItemStack getItemStack(int sltid, ItemStack _isc) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) ArrowInv, itemstack))).getCount() < 64) {
								{
									final int _slotid = (int) ArrowInv;
									final ItemStack _setstack = new ItemStack(Items.ARROW);
									_setstack.setCount((int) (((new Object() {
										public ItemStack getItemStack(int sltid, ItemStack _isc) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack((int) ArrowInv, itemstack))).getCount() + 1));
									entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable _modHandler)
											_modHandler.setStackInSlot(_slotid, _setstack);
									});
								}
								quiver.getOrCreateTag().putDouble(("arrow_basic_amount" + ArrowSlot), (quiver.getOrCreateTag().getDouble(("arrow_basic_amount" + ArrowSlot)) - 1));
							}
							ArrowInv = ArrowInv + 1;
						}
					}
					ArrowSlot = ArrowSlot + 1;
				}
			}
		}
	}
}
