package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RedstoneArmorTntProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
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
				world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.REDSTONE_LAMP.defaultBlockState()) {
				world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.REDSTONE_TORCH.defaultBlockState()) {
				world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.REDSTONE_TORCH.defaultBlockState()) {
				world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				KraftmineMod.queueServerWork(200, () -> {
					world.setBlock(new BlockPos(x, y, z), Blocks.REDSTONE_TORCH.defaultBlockState(), 3);
				});
			}
			if (blockstate == Blocks.TNT.defaultBlockState()) {
				world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new PrimedTnt(EntityType.TNT, _level);
					entityToSpawn.moveTo(x, y, z, 0, 0);
					entityToSpawn.setYBodyRot(0);
					entityToSpawn.setYHeadRot(0);
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
