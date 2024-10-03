package net.mcreator.kraftmine.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BlockPunchProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, BlockState blockstate, Entity entity) {
		execute(null, world, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double Splinternumber = 0;
		double SplinterLevel = 0;
		if (entity instanceof Player && new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == (new ItemStack(blockstate.getBlock())).getItem()) {
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:ores/iron")))
						|| blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe"))) || blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:glass"))) || false
						|| blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:fire"))) || false) {
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.IN_WALL)), 1);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0));
				}
				if (blockstate.is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/axe")))) {
					if (Math.random() < 0.25) {
						SplinterLevel = Mth.nextInt(RandomSource.create(), 1, 5);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(KraftmineModMobEffects.SPLINTERED, 600, (int) SplinterLevel));
					}
				}
				if (entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(KraftmineModMobEffects.SPLINTERED)) {
					Splinternumber = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(KraftmineModMobEffects.SPLINTERED) ? _livEnt.getEffect(KraftmineModMobEffects.SPLINTERED).getAmplifier() : 0;
					entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) Splinternumber);
				}
			}
		}
	}
}
