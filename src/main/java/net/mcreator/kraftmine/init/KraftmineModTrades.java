
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@EventBusSubscriber
public class KraftmineModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 64), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 36), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 0, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 5, 0, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 5, 0, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), new ItemStack(Items.EMERALD), 10, 0, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 10, 0, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.RAW_COPPER, 16), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 5), 16, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 48), new ItemStack(KraftmineModItems.PLASTIC_AXE.get()), 12, 1, 0.2f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get()), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 16), new ItemStack(KraftmineModItems.OBSIDIAN_SWORD.get()), 3, 1, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 48), new ItemStack(KraftmineModItems.COCA_COLA_GRENADE.get(), 5), 5, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.WATER_CHARGE.get(), 5), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.BLADE_RAZOR.get(), 10), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 10, 3, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 10), new ItemStack(KraftmineModItems.QUIVER_ARMOR_CHESTPLATE.get()), 3, 20, 0.2f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.IRON_SWORD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 10), 5, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 64), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 36), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 0, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 3, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 10, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 5, 0.01f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), new ItemStack(KraftmineModItems.BLUEPRINTS_GLAIVE.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), new ItemStack(KraftmineModItems.BLUEPRINTS_CUTLASS.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), new ItemStack(KraftmineModItems.BLUEPRINTS_KATANA.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), new ItemStack(KraftmineModItems.BLUEPRINTS_BROADSWORD.get()), 3, 5, 0.1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 5), new ItemStack(KraftmineModItems.FIRE_BRAND.get()), 3, 5, 0.2f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get(), 8), new ItemStack(KraftmineModItems.WEAPON_SMITH_VOUCHER.get()), 10, 15, 0.25f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(Blocks.WHEAT, 32), new ItemStack(KraftmineModItems.TEST_DUMMY_ITEM.get()), 10, 15, 0.5f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), new ItemStack(KraftmineModItems.BLUEPRINTS_SHORTSWORD.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), new ItemStack(KraftmineModItems.BLUEPRINTS_CLAYMORE.get()), 3, 5, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 8), new ItemStack(Items.WRITABLE_BOOK), new ItemStack(KraftmineModItems.BLUEPRINTS.get()), 10, 5, 0.15f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get(), 12), new ItemStack(KraftmineModItems.CRYSTAL_BLUE.get()), 3, 2, 0.5f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EYEPATCH_HELMET.get()), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), 10, 10, 0.01f));
		}
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.CORN.get(), 20), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 16, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 48), new ItemStack(KraftmineModBlocks.WALLNUT.get()), 12, 1, 0.2f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 24), new ItemStack(KraftmineModItems.CHERRY.get()), 3, 1, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.COCONUT.get(), 8), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 3, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.CORN_SEEDS.get(), 10), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 10, 3, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.SOUL_LIGHT.get()), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 8), 5, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 64), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 36), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 0, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 3, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 10, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 5, 0.01f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_HELMET.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_CHESTPLATE.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_LEGGINGS.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_BOOTS.get()), 3, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get(), 10), new ItemStack(Items.BEETROOT, 64), new ItemStack(KraftmineModItems.BEETSNIPER.get()), 3, 15, 0.25f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get()), new ItemStack(KraftmineModItems.CORN.get(), 64), new ItemStack(KraftmineModItems.PLANT_CHARGE.get()), 16, 10, 0.5f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 5), new ItemStack(Items.MELON_SEEDS, 16), new ItemStack(KraftmineModItems.SEED_MACHINE_GUN.get()), 3, 10, 0.2f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Items.POISONOUS_POTATO, 64), new ItemStack(KraftmineModItems.MP_POTATO.get()), 3, 10, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get()), new ItemStack(KraftmineModItems.RANGED_TOMATO.get(), 16), new ItemStack(KraftmineModItems.TOMATO_SHURIKEN.get(), 16), 16, 2, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RANGED_TOMATO.get(), 16), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 16, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get(), 12), new ItemStack(KraftmineModItems.CORN.get()), new ItemStack(KraftmineModItems.POP_CORN.get()), 10, 15, 0.25f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModBlocks.APPLEBLOCK.get()), new ItemStack(KraftmineModItems.RUBY_COIN.get(), 8), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), new ItemStack(KraftmineModBlocks.GOLDEN_APPLE_BLOCK.get()), 5, 5, 0.2f));
		}
		if (event.getType() == VillagerProfession.LIBRARIAN) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.CORN.get(), 20), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 16, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 48), new ItemStack(KraftmineModBlocks.WALLNUT.get()), 12, 1, 0.2f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 24), new ItemStack(KraftmineModItems.CHERRY.get()), 3, 1, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.COCONUT.get(), 8), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 3, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.CORN_SEEDS.get(), 10), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 10, 3, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.SOUL_LIGHT.get()), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 5, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 64), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 36), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 0, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 3, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 10, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 5, 0.01f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_HELMET.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_CHESTPLATE.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_LEGGINGS.get()), 3, 5, 0.1f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Blocks.AZALEA_LEAVES, 24), new ItemStack(KraftmineModItems.GHILLIE_SUIT_BOOTS.get()), 3, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get(), 10), new ItemStack(Items.BEETROOT, 64), new ItemStack(KraftmineModItems.BEETSNIPER.get()), 3, 15, 0.25f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get()), new ItemStack(KraftmineModItems.CORN.get(), 64), new ItemStack(KraftmineModItems.PLANT_CHARGE.get()), 16, 10, 0.5f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 5), new ItemStack(Items.MELON_SEEDS, 16), new ItemStack(KraftmineModItems.SEED_MACHINE_GUN.get()), 3, 10, 0.2f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 24), new ItemStack(Items.POISONOUS_POTATO, 64), new ItemStack(KraftmineModItems.MP_POTATO.get()), 3, 10, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get()), new ItemStack(KraftmineModItems.RANGED_TOMATO.get(), 16), new ItemStack(KraftmineModItems.TOMATO_SHURIKEN.get(), 16), 16, 2, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RANGED_TOMATO.get(), 16), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 16, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get(), 12), new ItemStack(KraftmineModItems.CORN.get()), new ItemStack(KraftmineModItems.POP_CORN.get()), 10, 15, 0.25f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModBlocks.APPLEBLOCK.get()), new ItemStack(KraftmineModItems.RUBY_COIN.get(), 8), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), new ItemStack(KraftmineModBlocks.GOLDEN_APPLE_BLOCK.get()), 5, 5, 0.2f));
		}
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.PLASTIC_SCRAP.get(), 4), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 16), 16, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.REDSTONE_INGOT.get(), 8), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 3, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.OBSIDIAN_NUGGET.get(), 10), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 10, 3, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.SOUL_MIGHT.get()), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 8), 5, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 64), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 36), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 0, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 3, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 10, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 5, 0.01f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 32), new ItemStack(KraftmineModItems.CARBON_FIBER.get(), 24), new ItemStack(KraftmineModItems.CARBON_ARMOR_HELMET.get()), 3, 5, 0.05f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 32), new ItemStack(KraftmineModItems.CARBON_FIBER.get(), 24), new ItemStack(KraftmineModItems.CARBON_ARMOR_CHESTPLATE.get()), 3, 5, 0.05f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 32), new ItemStack(KraftmineModItems.CARBON_FIBER.get(), 24), new ItemStack(KraftmineModItems.CARBON_ARMOR_LEGGINGS.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 32), new ItemStack(KraftmineModItems.CARBON_FIBER.get(), 24), new ItemStack(KraftmineModItems.CARBON_ARMOR_BOOTS.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get()), new ItemStack(KraftmineModItems.CARBON_FIBER.get(), 8), 3, 15, 0.25f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(KraftmineModItems.EGG_ARMOR_HELMET.get()), new ItemStack(KraftmineModItems.EGGHELL_ARMOR_HELMET.get()), 3, 5, 0.1f));
			event.getTrades().get(4)
					.add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(KraftmineModItems.EGG_ARMOR_CHESTPLATE.get()), new ItemStack(KraftmineModItems.EGGHELL_ARMOR_CHESTPLATE.get()), 3, 5, 0.1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(KraftmineModItems.EGG_ARMOR_LEGGINGS.get()), new ItemStack(KraftmineModItems.EGGHELL_ARMOR_LEGGINGS.get()), 3, 5, 0.1f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(KraftmineModItems.EGG_ARMOR_BOOTS.get()), new ItemStack(KraftmineModItems.EGGHELL_ARMOR_BOOTS.get()), 3, 5, 0.1f));
		}
		if (event.getType() == VillagerProfession.LEATHERWORKER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.PLASTIC_SCRAP.get(), 4), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 16), 16, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.REDSTONE_INGOT.get(), 8), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 3, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.OBSIDIAN_NUGGET.get(), 10), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 15), 10, 3, 0.1f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(KraftmineModItems.SOUL_MIGHT.get()), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 8), 5, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 64), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 36), new ItemStack(KraftmineModItems.EMERALDCOIN.get()), 10, 0, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 3, 5, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 10, 0.1f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.SAPPHIRE_COIN.get(), 32), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 64), new ItemStack(KraftmineModItems.EMERALDCOIN.get(), 36), new ItemStack(KraftmineModItems.RUBY_COIN.get()), 10, 2, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 2, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get(), 10), new ItemStack(KraftmineModItems.DIAMOND_COIN.get()), 10, 5, 0.01f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(Items.LEATHER_HELMET), new ItemStack(KraftmineModItems.DRIP_ARMOR_HELMET.get()), 3, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(Items.LEATHER_CHESTPLATE), new ItemStack(KraftmineModItems.DRIP_ARMOR_CHESTPLATE.get()), 3, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(Items.LEATHER_LEGGINGS), new ItemStack(KraftmineModItems.DRIP_ARMOR_LEGGINGS.get()), 3, 5, 0.1f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(KraftmineModItems.RUBY_COIN.get()), new ItemStack(Items.LEATHER_BOOTS), new ItemStack(KraftmineModItems.DRIP_ARMOR_BOOTS.get()), 3, 5, 0.1f));
		}
	}
}
