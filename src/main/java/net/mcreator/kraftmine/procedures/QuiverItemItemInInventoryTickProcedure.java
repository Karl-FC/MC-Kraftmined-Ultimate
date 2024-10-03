package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

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
			for (int index0 = 0; index0 < 3; index0++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(sltid).copy();
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) SpectralSlot, itemstack)).getItem() == Items.SPECTRAL_ARROW) {
					SpectralInv = 0;
					for (int index1 = 0; index1 < 36; index1++) {
						if ((new Object() {
							public ItemStack getItemStack(int sltid, ItemStack _isc) {
								IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(sltid).copy();
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SpectralInv, itemstack)).getItem() == Items.SPECTRAL_ARROW && (new Object() {
							public ItemStack getItemStack(int sltid, ItemStack _isc) {
								IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(sltid).copy();
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) SpectralInv, itemstack)).getCount() < 64) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = new ItemStack(Items.SPECTRAL_ARROW).copy();
								_setstack.setCount((int) ((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(sltid).copy();
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) SpectralInv, itemstack)).getCount() + 1));
								_modHandler.setStackInSlot((int) SpectralInv, _setstack);
							}
							if (itemstack.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
								ItemStack _setstack = new ItemStack(Items.SPECTRAL_ARROW).copy();
								_setstack.setCount((int) ((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(sltid).copy();
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) SpectralInv, itemstack)).getCount() - 1));
								_modHandlerItemSetSlot.setStackInSlot((int) SpectralSlot, _setstack);
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
			for (int index2 = 0; index2 < 8; index2++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(sltid).copy();
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) TippedSlot, itemstack)).getItem() == Items.TIPPED_ARROW) {
					TippedInv = 0;
					for (int index3 = 0; index3 < 36; index3++) {
						if ((new Object() {
							public ItemStack getItemStack(int sltid, ItemStack _isc) {
								IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(sltid).copy();
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) TippedInv, itemstack)).getItem() == Items.TIPPED_ARROW && (new Object() {
							public ItemStack getItemStack(int sltid, ItemStack _isc) {
								IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(sltid).copy();
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) TippedInv, itemstack)).getCount() < 64) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = new ItemStack(Items.TIPPED_ARROW).copy();
								_setstack.setCount((int) ((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(sltid).copy();
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) TippedInv, itemstack)).getCount() + 1));
								_modHandler.setStackInSlot((int) TippedInv, _setstack);
							}
							if (itemstack.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
								ItemStack _setstack = new ItemStack(Items.TIPPED_ARROW).copy();
								_setstack.setCount((int) ((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(sltid).copy();
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) TippedInv, itemstack)).getCount() - 1));
								_modHandlerItemSetSlot.setStackInSlot((int) TippedSlot, _setstack);
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
			for (int index4 = 0; index4 < 8; index4++) {
				if ((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
						if (_itemHandler != null)
							return _itemHandler.getStackInSlot(sltid).copy();
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) ArrowSlot, itemstack)).getItem() == Items.ARROW) {
					ArrowInv = 0;
					for (int index5 = 0; index5 < 36; index5++) {
						if ((new Object() {
							public ItemStack getItemStack(int sltid, ItemStack _isc) {
								IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(sltid).copy();
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) ArrowInv, itemstack)).getItem() == Items.ARROW && (new Object() {
							public ItemStack getItemStack(int sltid, ItemStack _isc) {
								IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
								if (_itemHandler != null)
									return _itemHandler.getStackInSlot(sltid).copy();
								return ItemStack.EMPTY;
							}
						}.getItemStack((int) ArrowInv, itemstack)).getCount() < 64) {
							if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
								ItemStack _setstack = new ItemStack(Items.ARROW).copy();
								_setstack.setCount((int) ((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(sltid).copy();
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) ArrowInv, itemstack)).getCount() + 1));
								_modHandler.setStackInSlot((int) ArrowInv, _setstack);
							}
							if (itemstack.getCapability(Capabilities.ItemHandler.ITEM, null) instanceof IItemHandlerModifiable _modHandlerItemSetSlot) {
								ItemStack _setstack = new ItemStack(Items.ARROW).copy();
								_setstack.setCount((int) ((new Object() {
									public ItemStack getItemStack(int sltid, ItemStack _isc) {
										IItemHandler _itemHandler = _isc.getCapability(Capabilities.ItemHandler.ITEM, null);
										if (_itemHandler != null)
											return _itemHandler.getStackInSlot(sltid).copy();
										return ItemStack.EMPTY;
									}
								}.getItemStack((int) ArrowInv, itemstack)).getCount() - 1));
								_modHandlerItemSetSlot.setStackInSlot((int) ArrowSlot, _setstack);
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
