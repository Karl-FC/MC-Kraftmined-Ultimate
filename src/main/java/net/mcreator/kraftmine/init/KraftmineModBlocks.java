
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.kraftmine.block.MahoganyWoodBlock;
import net.mcreator.kraftmine.block.MahoganyStairsBlock;
import net.mcreator.kraftmine.block.MahoganySlabBlock;
import net.mcreator.kraftmine.block.MahoganyPressurePlateBlock;
import net.mcreator.kraftmine.block.MahoganyPlanksBlock;
import net.mcreator.kraftmine.block.MahoganyLogBlock;
import net.mcreator.kraftmine.block.MahoganyLeavesBlock;
import net.mcreator.kraftmine.block.MahoganyFenceGateBlock;
import net.mcreator.kraftmine.block.MahoganyFenceBlock;
import net.mcreator.kraftmine.block.MahoganyButtonBlock;
import net.mcreator.kraftmine.block.DeadwoodWoodBlock;
import net.mcreator.kraftmine.block.DeadwoodStairsBlock;
import net.mcreator.kraftmine.block.DeadwoodSlabBlock;
import net.mcreator.kraftmine.block.DeadwoodPressurePlateBlock;
import net.mcreator.kraftmine.block.DeadwoodPlanksBlock;
import net.mcreator.kraftmine.block.DeadwoodLogBlock;
import net.mcreator.kraftmine.block.DeadwoodLeavesBlock;
import net.mcreator.kraftmine.block.DeadwoodFenceGateBlock;
import net.mcreator.kraftmine.block.DeadwoodFenceBlock;
import net.mcreator.kraftmine.block.DeadwoodButtonBlock;
import net.mcreator.kraftmine.block.CherryWoodBlock;
import net.mcreator.kraftmine.block.CherryStairsBlock;
import net.mcreator.kraftmine.block.CherrySlabBlock;
import net.mcreator.kraftmine.block.CherryPressurePlateBlock;
import net.mcreator.kraftmine.block.CherryPlanksBlock;
import net.mcreator.kraftmine.block.CherryLogBlock;
import net.mcreator.kraftmine.block.CherryLeavesBlock;
import net.mcreator.kraftmine.block.CherryFenceGateBlock;
import net.mcreator.kraftmine.block.CherryFenceBlock;
import net.mcreator.kraftmine.block.CherryButtonBlock;
import net.mcreator.kraftmine.block.BambooStairsBlock;
import net.mcreator.kraftmine.block.BambooSlabBlock;
import net.mcreator.kraftmine.block.BambooPressurePlateBlock;
import net.mcreator.kraftmine.block.BambooPlanksBlock;
import net.mcreator.kraftmine.block.BambooFenceGateBlock;
import net.mcreator.kraftmine.block.BambooFenceBlock;
import net.mcreator.kraftmine.block.BambooButtonBlock;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(KraftmineMod.MODID);
	public static final DeferredBlock<Block> APPLEBLOCK = REGISTRY.register("appleblock", AppleblockBlock::new);
	public static final DeferredBlock<Block> TUNGSTEN_ORE = REGISTRY.register("tungsten_ore", TungstenOreBlock::new);
	public static final DeferredBlock<Block> TUNGSTEN_BLOCK = REGISTRY.register("tungsten_block", TungstenBlockBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_WOOD = REGISTRY.register("mahogany_wood", MahoganyWoodBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_LOG = REGISTRY.register("mahogany_log", MahoganyLogBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_PLANKS = REGISTRY.register("mahogany_planks", MahoganyPlanksBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_LEAVES = REGISTRY.register("mahogany_leaves", MahoganyLeavesBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_STAIRS = REGISTRY.register("mahogany_stairs", MahoganyStairsBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_SLAB = REGISTRY.register("mahogany_slab", MahoganySlabBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_FENCE = REGISTRY.register("mahogany_fence", MahoganyFenceBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_FENCE_GATE = REGISTRY.register("mahogany_fence_gate", MahoganyFenceGateBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_PRESSURE_PLATE = REGISTRY.register("mahogany_pressure_plate", MahoganyPressurePlateBlock::new);
	public static final DeferredBlock<Block> MAHOGANY_BUTTON = REGISTRY.register("mahogany_button", MahoganyButtonBlock::new);
	public static final DeferredBlock<Block> CHERRY_WOOD = REGISTRY.register("cherry_wood", CherryWoodBlock::new);
	public static final DeferredBlock<Block> CHERRY_LOG = REGISTRY.register("cherry_log", CherryLogBlock::new);
	public static final DeferredBlock<Block> CHERRY_PLANKS = REGISTRY.register("cherry_planks", CherryPlanksBlock::new);
	public static final DeferredBlock<Block> CHERRY_LEAVES = REGISTRY.register("cherry_leaves", CherryLeavesBlock::new);
	public static final DeferredBlock<Block> CHERRY_STAIRS = REGISTRY.register("cherry_stairs", CherryStairsBlock::new);
	public static final DeferredBlock<Block> CHERRY_SLAB = REGISTRY.register("cherry_slab", CherrySlabBlock::new);
	public static final DeferredBlock<Block> CHERRY_FENCE = REGISTRY.register("cherry_fence", CherryFenceBlock::new);
	public static final DeferredBlock<Block> CHERRY_FENCE_GATE = REGISTRY.register("cherry_fence_gate", CherryFenceGateBlock::new);
	public static final DeferredBlock<Block> CHERRY_PRESSURE_PLATE = REGISTRY.register("cherry_pressure_plate", CherryPressurePlateBlock::new);
	public static final DeferredBlock<Block> CHERRY_BUTTON = REGISTRY.register("cherry_button", CherryButtonBlock::new);
	public static final DeferredBlock<Block> CLOUD = REGISTRY.register("cloud", CloudBlock::new);
	public static final DeferredBlock<Block> CLOUD_BLOCK_RAIN = REGISTRY.register("cloud_block_rain", CloudBlockRainBlock::new);
	public static final DeferredBlock<Block> BAMBOO_PLANKS = REGISTRY.register("bamboo_planks", BambooPlanksBlock::new);
	public static final DeferredBlock<Block> BAMBOO_STAIRS = REGISTRY.register("bamboo_stairs", BambooStairsBlock::new);
	public static final DeferredBlock<Block> BAMBOO_SLAB = REGISTRY.register("bamboo_slab", BambooSlabBlock::new);
	public static final DeferredBlock<Block> BAMBOO_FENCE = REGISTRY.register("bamboo_fence", BambooFenceBlock::new);
	public static final DeferredBlock<Block> BAMBOO_FENCE_GATE = REGISTRY.register("bamboo_fence_gate", BambooFenceGateBlock::new);
	public static final DeferredBlock<Block> BAMBOO_PRESSURE_PLATE = REGISTRY.register("bamboo_pressure_plate", BambooPressurePlateBlock::new);
	public static final DeferredBlock<Block> BAMBOO_BUTTON = REGISTRY.register("bamboo_button", BambooButtonBlock::new);
	public static final DeferredBlock<Block> MILK_BUCKET = REGISTRY.register("milk_bucket", MilkBucketBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_WOOD = REGISTRY.register("palm_wood_wood", PalmWoodWoodBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_LOG = REGISTRY.register("palm_wood_log", PalmWoodLogBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_PLANKS = REGISTRY.register("palm_wood_planks", PalmWoodPlanksBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_LEAVES = REGISTRY.register("palm_wood_leaves", PalmWoodLeavesBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_STAIRS = REGISTRY.register("palm_wood_stairs", PalmWoodStairsBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_SLAB = REGISTRY.register("palm_wood_slab", PalmWoodSlabBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_FENCE = REGISTRY.register("palm_wood_fence", PalmWoodFenceBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_FENCE_GATE = REGISTRY.register("palm_wood_fence_gate", PalmWoodFenceGateBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_PRESSURE_PLATE = REGISTRY.register("palm_wood_pressure_plate", PalmWoodPressurePlateBlock::new);
	public static final DeferredBlock<Block> PALM_WOOD_BUTTON = REGISTRY.register("palm_wood_button", PalmWoodButtonBlock::new);
	public static final DeferredBlock<Block> LEGO_BLOCK = REGISTRY.register("lego_block", LegoBlockBlock::new);
	public static final DeferredBlock<Block> NICKEL_ORE = REGISTRY.register("nickel_ore", NickelOreBlock::new);
	public static final DeferredBlock<Block> NICKEL_BLOCK = REGISTRY.register("nickel_block", NickelBlockBlock::new);
	public static final DeferredBlock<Block> ALUMINUM_ORE = REGISTRY.register("aluminum_ore", AluminumOreBlock::new);
	public static final DeferredBlock<Block> ALUMINUM_BLOCK = REGISTRY.register("aluminum_block", AluminumBlockBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_TUNGSTEN_ORE = REGISTRY.register("deepslate_tungsten_ore", DeepslateTungstenOreBlock::new);
	public static final DeferredBlock<Block> TITANIUM_ORE = REGISTRY.register("titanium_ore", TitaniumOreBlock::new);
	public static final DeferredBlock<Block> TITANIUM_BLOCK = REGISTRY.register("titanium_block", TitaniumBlockBlock::new);
	public static final DeferredBlock<Block> DEEPSLATE_TITANIUM_ORE = REGISTRY.register("deepslate_titanium_ore", DeepslateTitaniumOreBlock::new);
	public static final DeferredBlock<Block> RUBY_ORE = REGISTRY.register("ruby_ore", RubyOreBlock::new);
	public static final DeferredBlock<Block> RUBY_BLOCK = REGISTRY.register("ruby_block", RubyBlockBlock::new);
	public static final DeferredBlock<Block> SAPHHIRE_ORE = REGISTRY.register("saphhire_ore", SaphhireOreBlock::new);
	public static final DeferredBlock<Block> SAPHHIRE_BLOCK = REGISTRY.register("saphhire_block", SaphhireBlockBlock::new);
	public static final DeferredBlock<Block> AETHERANCIENTDEBRIS = REGISTRY.register("aetherancientdebris", AetherancientdebrisBlock::new);
	public static final DeferredBlock<Block> CLOUD_SAPPHIRE_ORE = REGISTRY.register("cloud_sapphire_ore", CloudSapphireOreBlock::new);
	public static final DeferredBlock<Block> CLOUD_RUBY_ORE = REGISTRY.register("cloud_ruby_ore", CloudRubyOreBlock::new);
	public static final DeferredBlock<Block> WALL_BLOCK = REGISTRY.register("wall_block", WallBlockBlock::new);
	public static final DeferredBlock<Block> GRAVITY_DISRUPTOR = REGISTRY.register("gravity_disruptor", GravityDisruptorBlock::new);
	public static final DeferredBlock<Block> GOLDEN_APPLE_BLOCK = REGISTRY.register("golden_apple_block", GoldenAppleBlockBlock::new);
	public static final DeferredBlock<Block> AETHER_PORTAL = REGISTRY.register("aether_portal", AetherPortalBlock::new);
	public static final DeferredBlock<Block> LIFE_ORB = REGISTRY.register("life_orb", LifeOrbBlock::new);
	public static final DeferredBlock<Block> XP_BANK = REGISTRY.register("xp_bank", XPBankBlock::new);
	public static final DeferredBlock<Block> COCONUT_BLOCK = REGISTRY.register("coconut_block", CoconutBlockBlock::new);
	public static final DeferredBlock<Block> BACKROOM_TRIGGER = REGISTRY.register("backroom_trigger", BackroomTriggerBlock::new);
	public static final DeferredBlock<Block> LUCKY_BLOCK = REGISTRY.register("lucky_block", LuckyBlockBlock::new);
	public static final DeferredBlock<Block> BACKROOM_TRIGGERED_2 = REGISTRY.register("backroom_triggered_2", BackroomTriggered2Block::new);
	public static final DeferredBlock<Block> DOMAIN_BARRIER = REGISTRY.register("domain_barrier", DomainBarrierBlock::new);
	public static final DeferredBlock<Block> CHILL_ICE = REGISTRY.register("chill_ice", ChillIceBlock::new);
	public static final DeferredBlock<Block> SUPPLY_CRATE = REGISTRY.register("supply_crate", SupplyCrateBlock::new);
	public static final DeferredBlock<Block> GLOW_SHROOM = REGISTRY.register("glow_shroom", GlowShroomBlock::new);
	public static final DeferredBlock<Block> CORN_CROP_0 = REGISTRY.register("corn_crop_0", CornCrop0Block::new);
	public static final DeferredBlock<Block> CORN_CROP_1 = REGISTRY.register("corn_crop_1", CornCrop1Block::new);
	public static final DeferredBlock<Block> CORN_CROP_2 = REGISTRY.register("corn_crop_2", CornCrop2Block::new);
	public static final DeferredBlock<Block> TOMATO_BUSH = REGISTRY.register("tomato_bush", TomatoBushBlock::new);
	public static final DeferredBlock<Block> TOMATO_BUSH_1 = REGISTRY.register("tomato_bush_1", TomatoBush1Block::new);
	public static final DeferredBlock<Block> TOMATO_BUSH_2 = REGISTRY.register("tomato_bush_2", TomatoBush2Block::new);
	public static final DeferredBlock<Block> TOMATO_BUSH_3 = REGISTRY.register("tomato_bush_3", TomatoBush3Block::new);
	public static final DeferredBlock<Block> WALLNUT = REGISTRY.register("wallnut", WallnutBlock::new);
	public static final DeferredBlock<Block> MOLTEN_OBSIDIAN = REGISTRY.register("molten_obsidian", MoltenObsidianBlock::new);
	public static final DeferredBlock<Block> FIREFLY_LANTERN = REGISTRY.register("firefly_lantern", FireflyLanternBlock::new);
	public static final DeferredBlock<Block> EMPTY_LANTERN = REGISTRY.register("empty_lantern", EmptyLanternBlock::new);
	public static final DeferredBlock<Block> COARSE_GRASS_BLOCK = REGISTRY.register("coarse_grass_block", CoarseGrassBlockBlock::new);
	public static final DeferredBlock<Block> PLASTIC_ORE = REGISTRY.register("plastic_ore", PlasticOreBlock::new);
	public static final DeferredBlock<Block> PLASTIC_BLOCK = REGISTRY.register("plastic_block", PlasticBlockBlock::new);
	public static final DeferredBlock<Block> CAN_BEANS = REGISTRY.register("can_beans", CanBeansBlock::new);
	public static final DeferredBlock<Block> CAN_RABBIT_STEW = REGISTRY.register("can_rabbit_stew", CanRabbitStewBlock::new);
	public static final DeferredBlock<Block> CAN_SUSPICIOUS_STEW = REGISTRY.register("can_suspicious_stew", CanSuspiciousStewBlock::new);
	public static final DeferredBlock<Block> CAN_BREAD = REGISTRY.register("can_bread", CanBreadBlock::new);
	public static final DeferredBlock<Block> CAN_MUSHROOM_STEW = REGISTRY.register("can_mushroom_stew", CanMushroomStewBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_WOOD = REGISTRY.register("deadwood_wood", DeadwoodWoodBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_LOG = REGISTRY.register("deadwood_log", DeadwoodLogBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_PLANKS = REGISTRY.register("deadwood_planks", DeadwoodPlanksBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_LEAVES = REGISTRY.register("deadwood_leaves", DeadwoodLeavesBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_STAIRS = REGISTRY.register("deadwood_stairs", DeadwoodStairsBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_SLAB = REGISTRY.register("deadwood_slab", DeadwoodSlabBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_FENCE = REGISTRY.register("deadwood_fence", DeadwoodFenceBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_FENCE_GATE = REGISTRY.register("deadwood_fence_gate", DeadwoodFenceGateBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_PRESSURE_PLATE = REGISTRY.register("deadwood_pressure_plate", DeadwoodPressurePlateBlock::new);
	public static final DeferredBlock<Block> DEADWOOD_BUTTON = REGISTRY.register("deadwood_button", DeadwoodButtonBlock::new);
	public static final DeferredBlock<Block> DRIED_LEAVES = REGISTRY.register("dried_leaves", DriedLeavesBlock::new);
	public static final DeferredBlock<Block> ACID = REGISTRY.register("acid", AcidBlock::new);
	public static final DeferredBlock<Block> IRIS_PURPLE = REGISTRY.register("iris_purple", IrisPurpleBlock::new);
	public static final DeferredBlock<Block> IRIS_SILVER = REGISTRY.register("iris_silver", IrisSilverBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			CoarseGrassBlockBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			CoarseGrassBlockBlock.itemColorLoad(event);
		}
	}
}
