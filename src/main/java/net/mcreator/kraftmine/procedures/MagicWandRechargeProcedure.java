package net.mcreator.kraftmine.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class MagicWandRechargeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double seconds = 0;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.FIRE_SCEPTER.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.ICE_WAND.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.THE_SWITCHER.get())) : false)
				|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.LIGHTNING_ROD.get())) : false)) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(new ResourceLocation("kraftmine:magic_wands"))) && (itemstackiterator).getDamageValue() < (itemstackiterator).getMaxDamage()) {
							seconds = seconds + 1;
							if (seconds == 20) {
								if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SUPERSTITIOUS.get(), itemstackiterator) != 0) {
									(itemstackiterator).setDamageValue((int) ((itemstackiterator).getDamageValue() + 20 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SUPERSTITIOUS.get(), itemstackiterator) * 10));
								} else if (!(EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SUPERSTITIOUS.get(), itemstackiterator) != 0)) {
									(itemstackiterator).setDamageValue((int) ((itemstackiterator).getDamageValue() + 20));
								}
								seconds = 0;
							}
						}
					}
				}
			}
		}
	}
}
