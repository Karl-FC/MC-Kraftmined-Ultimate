package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.kraftmine.init.KraftmineModGameRules;
import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BuffMobEnchantsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.BUFFEDMOBS) == true && !(entity instanceof Player)
				&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem && !(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted())
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
								&& !(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).isEnchanted()))) {
			if (Math.random() <= 0.03) {
				if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(KraftmineModEnchantments.BANEOF_METAPOD.get(), Mth.nextInt(RandomSource.create(), 1, 3));
				} else if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).enchant(KraftmineModEnchantments.BANEOF_METAPOD.get(), Mth.nextInt(RandomSource.create(), 1, 3));
				}
			}
			if (Math.random() <= 0.03) {
				if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(KraftmineModEnchantments.LIFESTEAL.get(), Mth.nextInt(RandomSource.create(), 1, 3));
				} else if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).enchant(KraftmineModEnchantments.LIFESTEAL.get(), Mth.nextInt(RandomSource.create(), 1, 3));
				}
			}
			if (Math.random() <= 0.01) {
				if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.SHARPNESS, Mth.nextInt(RandomSource.create(), 1, 5));
				} else if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).enchant(Enchantments.SHARPNESS, Mth.nextInt(RandomSource.create(), 1, 5));
				}
			}
			if (Math.random() <= 0.01) {
				if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(KraftmineModEnchantments.STUNNING.get(), Mth.nextInt(RandomSource.create(), 1, 5));
				} else if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).enchant(KraftmineModEnchantments.STUNNING.get(), Mth.nextInt(RandomSource.create(), 1, 5));
				}
			}
			if (Math.random() <= 0.03) {
				if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.FIRE_ASPECT, Mth.nextInt(RandomSource.create(), 1, 2));
				} else if (!(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).isEnchanted())) {
					entity.getPersistentData().putBoolean("isBuffed", (true));
					((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).enchant(Enchantments.FIRE_ASPECT, Mth.nextInt(RandomSource.create(), 1, 2));
				}
			}
		}
	}
}
