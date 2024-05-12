
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.kraftmine.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.kraftmine.block.entity.XPBankBlockEntity;
import net.mcreator.kraftmine.block.entity.WallnutBlockEntity;
import net.mcreator.kraftmine.block.entity.TomatoBushBlockEntity;
import net.mcreator.kraftmine.block.entity.TomatoBush3BlockEntity;
import net.mcreator.kraftmine.block.entity.TomatoBush2BlockEntity;
import net.mcreator.kraftmine.block.entity.TomatoBush1BlockEntity;
import net.mcreator.kraftmine.block.entity.CornCrop2BlockEntity;
import net.mcreator.kraftmine.block.entity.CornCrop1BlockEntity;
import net.mcreator.kraftmine.block.entity.CornCrop0BlockEntity;
import net.mcreator.kraftmine.KraftmineMod;

public class KraftmineModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, KraftmineMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> XP_BANK = register("xp_bank", KraftmineModBlocks.XP_BANK, XPBankBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WALLNUT = register("wallnut", KraftmineModBlocks.WALLNUT, WallnutBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CORN_CROP_0 = register("corn_crop_0", KraftmineModBlocks.CORN_CROP_0, CornCrop0BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CORN_CROP_1 = register("corn_crop_1", KraftmineModBlocks.CORN_CROP_1, CornCrop1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CORN_CROP_2 = register("corn_crop_2", KraftmineModBlocks.CORN_CROP_2, CornCrop2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TOMATO_BUSH = register("tomato_bush", KraftmineModBlocks.TOMATO_BUSH, TomatoBushBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TOMATO_BUSH_1 = register("tomato_bush_1", KraftmineModBlocks.TOMATO_BUSH_1, TomatoBush1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TOMATO_BUSH_2 = register("tomato_bush_2", KraftmineModBlocks.TOMATO_BUSH_2, TomatoBush2BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TOMATO_BUSH_3 = register("tomato_bush_3", KraftmineModBlocks.TOMATO_BUSH_3, TomatoBush3BlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
