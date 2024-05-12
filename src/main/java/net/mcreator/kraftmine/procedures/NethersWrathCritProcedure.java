package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.KraftmineMod;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class NethersWrathCritProcedure {
	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getTarget(), event.getEntity(), event.isVanillaCritical());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, boolean isvanillacritical) {
		execute(null, world, x, y, z, entity, sourceentity, isvanillacritical);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, boolean isvanillacritical) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == KraftmineModItems.NETHERS_WRATH.get() && isvanillacritical == true) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.getMobType() == MobType.UNDEAD : false) {
				((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.SMITE, 5);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("particle.soul_escape")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				KraftmineMod.queueServerWork(60, () -> {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						if (_enchantments.containsKey(Enchantments.SMITE)) {
							_enchantments.remove(Enchantments.SMITE);
							EnchantmentHelper.setEnchantments(_enchantments, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						}
					}
				});
			}
		}
	}
}
