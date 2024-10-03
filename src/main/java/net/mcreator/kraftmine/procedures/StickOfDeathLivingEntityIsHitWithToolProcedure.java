package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;

public class StickOfDeathLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (itemstack.getItem() == KraftmineModItems.STICK_OF_DEATH.get()) {
			if ((sourceentity.getDirection()) == Direction.NORTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 1), (-100)));
			} else if ((sourceentity.getDirection()) == Direction.SOUTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 1), 100));
			} else if ((sourceentity.getDirection()) == Direction.EAST) {
				entity.setDeltaMovement(new Vec3(100, (entity.getDeltaMovement().y() + 1), (entity.getDeltaMovement().z())));
			} else if ((sourceentity.getDirection()) == Direction.WEST) {
				entity.setDeltaMovement(new Vec3((-100), (entity.getDeltaMovement().y() + 1), (entity.getDeltaMovement().z())));
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.trigger")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, 3));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.portal.trigger")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, 3), false);
				}
			}
		}
	}
}
