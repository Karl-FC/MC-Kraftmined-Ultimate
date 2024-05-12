package net.mcreator.kraftmine.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.concurrent.atomic.AtomicReference;

public class QuiverItemItemInInventoryTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double SpectralSlot = 0;
		double SpectralInv = 0;
		double TippedSlot = 0;
		double TippedInv = 0;
		double ArrowSlot = 0;
		double ArrowInv = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.SPECTRAL_ARROW)) : false) {
			SpectralSlot = 0;
			for (int index0 = 0; index0 < (int) (3); index0++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) SpectralSlot, itemstack)).getItem() == Items.SPECTRAL_ARROW) {
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
							{
								ItemStack _isc = itemstack;
								final ItemStack _setstack = new ItemStack(Items.SPECTRAL_ARROW);
								final int _sltid = (int) SpectralSlot;
								_setstack.setCount((int) (((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
										return _retval.get();
									}
								}.getItemStack((int) SpectralInv, itemstack))).getCount() - 1));
								_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						SpectralInv = SpectralInv + 1;
					}
				}
				SpectralSlot = SpectralSlot + 1;
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.TIPPED_ARROW)) : false) {
			TippedSlot = 3;
			for (int index2 = 0; index2 < (int) (8); index2++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) TippedSlot, itemstack)).getItem() == Items.TIPPED_ARROW) {
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
								final ItemStack _setstack = new ItemStack(Items.TIPPED_ARROW);
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
							{
								ItemStack _isc = itemstack;
								final ItemStack _setstack = new ItemStack(Items.TIPPED_ARROW);
								final int _sltid = (int) TippedSlot;
								_setstack.setCount((int) (((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
										return _retval.get();
									}
								}.getItemStack((int) TippedInv, itemstack))).getCount() - 1));
								_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						TippedInv = TippedInv + 1;
					}
				}
				TippedSlot = TippedSlot + 1;
			}
		}
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.ARROW)) : false) {
			ArrowSlot = 11;
			for (int index4 = 0; index4 < (int) (8); index4++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) ArrowSlot, itemstack)).getItem() == Items.ARROW) {
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
							{
								ItemStack _isc = itemstack;
								final ItemStack _setstack = new ItemStack(Items.ARROW);
								final int _sltid = (int) ArrowSlot;
								_setstack.setCount((int) (((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
										return _retval.get();
									}
								}.getItemStack((int) ArrowInv, itemstack))).getCount() - 1));
								_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						ArrowInv = ArrowInv + 1;
					}
				}
				ArrowSlot = ArrowSlot + 1;
			}
		}
	}
}
