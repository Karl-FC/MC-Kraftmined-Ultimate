package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.KraftmineMod;

public class ExcaliburEntityHitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double ysomething = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.EXCALIBUR.get()) {
			world.levelEvent(2001, new BlockPos(entity.getX(), entity.getY() + 2, entity.getZ()), Block.getId(Blocks.STONE.defaultBlockState()));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.PLAYERS, 3, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.PLAYERS, 3, 1, false);
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("CD") == false) {
				for (int index0 = 0; index0 < (int) (10); index0++) {
					if (!(entity.getDeltaMovement().y() < -1)) {
						ysomething = entity.getY();
						break;
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
				itemstack.getOrCreateTag().putBoolean("CD", (true));
				KraftmineMod.queueServerWork(500, () -> {
					itemstack.getOrCreateTag().putBoolean("CD", (false));
				});
				for (int index1 = 0; index1 < (int) (60); index1++) {
					{
						Entity _ent = entity;
						_ent.teleportTo((entity.getX()), ysomething, (entity.getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((entity.getX()), ysomething, (entity.getZ()), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
