package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class RedstoneArmorTntProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == KraftmineModItems.REDSTONE_ARMOR_HELMET.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == KraftmineModItems.REDSTONE_ARMOR_CHESTPLATE.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == KraftmineModItems.REDSTONE_ARMOR_LEGGINGS.get()
				|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == KraftmineModItems.REDSTONE_ARMOR_BOOTS.get()) {
			if (blockstate == Blocks.REDSTONE_LAMP.defaultBlockState()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.REDSTONE_LAMP.defaultBlockState()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.REDSTONE_TORCH.defaultBlockState()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.REDSTONE_TORCH.defaultBlockState()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.TNT.defaultBlockState()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
