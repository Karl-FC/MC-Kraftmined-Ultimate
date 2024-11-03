package net.mcreator.kraftmined.kombat.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmined.kombat.init.KmKombatModMobEffects;

public class RedstoneArmorProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState BlockInQuestion = Blocks.AIR.defaultBlockState();
		double Potionlevel = 0;
		double i = 0;
		double j = 0;
		double k = 0;
		double Iterations = 0;
		Potionlevel = (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KmKombatModMobEffects.REDED) ? _livEnt.getEffect(KmKombatModMobEffects.REDED).getAmplifier() : 0) + 1;
		i = Potionlevel * (-1);
		Iterations = 1 + Potionlevel * 2;
		for (int index0 = 0; index0 < (int) Iterations; index0++) {
			j = Potionlevel * (-1);
			for (int index1 = 0; index1 < (int) Iterations; index1++) {
				k = Potionlevel * (-1);
				for (int index2 = 0; index2 < (int) Iterations; index2++) {
					BlockInQuestion = (world.getBlockState(BlockPos.containing(x + i, y + j, z + k)));
					if (BlockInQuestion == Blocks.REDSTONE_LAMP.defaultBlockState()) {
						if ((BlockInQuestion.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _getbp3 && BlockInQuestion.getValue(_getbp3)) == false) {
							{
								BlockPos _pos = BlockPos.containing(x + i, y + j, z + k);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
									world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
							}
							{
								BlockPos _pos = BlockPos.containing(x + i, y + j, z + k);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("redded_block") instanceof BooleanProperty _booleanProp)
									world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
							}
						}
					} else if (BlockInQuestion.is(BlockTags.create(ResourceLocation.parse("minecraft:buttons")))) {
						if (entity instanceof Player _player) {
							BlockPos _bp = BlockPos.containing(x + i, y + j, z + k);
							_player.level().getBlockState(_bp).useWithoutItem(_player.level(), _player, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
						}
					}
					k = k + 1;
				}
				j = j + 1;
			}
			i = i + 1;
		}
		for (int index3 = 0; index3 < (int) Iterations; index3++) {
			j = Potionlevel * (-1);
			for (int index4 = 0; index4 < (int) Iterations; index4++) {
				k = Potionlevel * (-1);
				for (int index5 = 0; index5 < (int) Iterations; index5++) {
					BlockInQuestion = (world.getBlockState(BlockPos.containing(x + i, y + j, z + k)));
					if (BlockInQuestion.is(BlockTags.create(ResourceLocation.parse("minecraft:buttons")))) {
						if (entity instanceof Player _player) {
							BlockPos _bp = BlockPos.containing(x + i, y + j, z + k);
							_player.level().getBlockState(_bp).useWithoutItem(_player.level(), _player, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
						}
					}
					k = k + 1;
				}
				j = j + 1;
			}
			i = i + 1;
		}
	}
}
