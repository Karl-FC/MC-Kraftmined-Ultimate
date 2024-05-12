package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StunningProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level, event.getTarget(), event.getEntity(), event.isVanillaCritical());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, boolean isvanillacritical) {
		execute(null, world, entity, sourceentity, isvanillacritical);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity, boolean isvanillacritical) {
		if (entity == null || sourceentity == null)
			return;
		boolean isStunned = false;
		double StunTime = 0;
		if (isvanillacritical == true) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
					&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.STUNNING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				StunTime = EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.STUNNING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 5;
				entity.getPersistentData().putBoolean("isStunned", (true));
				if (entity instanceof Player _player) {
					_player.getAbilities().invulnerable = (true);
					_player.onUpdateAbilities();
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) StunTime, 200));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) StunTime, 200));
				for (int index0 = 0; index0 < (int) (StunTime); index0++) {
					entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
				}
				KraftmineMod.queueServerWork((int) StunTime, () -> {
					entity.getPersistentData().putBoolean("isStunned", (false));
					if (entity instanceof Player _player) {
						_player.getAbilities().invulnerable = (true);
						_player.onUpdateAbilities();
					}
				});
			}
		}
	}
}
