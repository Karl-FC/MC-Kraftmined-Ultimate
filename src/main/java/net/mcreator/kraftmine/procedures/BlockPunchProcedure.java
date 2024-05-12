package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlockPunchProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getState(), event.getPlayer());
	}

	public static void execute(BlockState blockstate, Entity entity) {
		execute(null, blockstate, entity);
	}

	private static void execute(@Nullable Event event, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double Splinternumber = 0;
		double SplinterLevel = 0;
		if (entity instanceof Player && new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == (new ItemStack(blockstate.getBlock())).getItem()) {
				if (blockstate.getMaterial() == net.minecraft.world.level.material.Material.STONE || blockstate.getMaterial() == net.minecraft.world.level.material.Material.METAL
						|| blockstate.getMaterial() == net.minecraft.world.level.material.Material.WOOD || blockstate.getMaterial() == net.minecraft.world.level.material.Material.GLASS
						|| blockstate.getMaterial() == net.minecraft.world.level.material.Material.CACTUS || blockstate.getMaterial() == net.minecraft.world.level.material.Material.FIRE
						|| blockstate.getMaterial() == net.minecraft.world.level.material.Material.ICE_SOLID) {
					entity.hurt(DamageSource.IN_WALL, 1);
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0));
				}
				if (blockstate.getMaterial() == net.minecraft.world.level.material.Material.WOOD) {
					if (Math.random() < 0.25) {
						SplinterLevel = Mth.nextInt(RandomSource.create(), 1, 5);
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.SPLINTERED.get(), 600, (int) SplinterLevel));
					}
				}
				if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.SPLINTERED.get()) : false) {
					Splinternumber = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.SPLINTERED.get()) ? _livEnt.getEffect(KraftmineModMobEffects.SPLINTERED.get()).getAmplifier() : 0;
					if (entity instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("injuries").bypassArmor(), (float) Splinternumber);
				}
			}
		}
	}
}
