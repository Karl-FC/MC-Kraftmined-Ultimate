package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AcidRainProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double chances = 0;
		double countdown = 0;
		if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("kraftmine:barrens")))
				&& world.getBiome(new BlockPos(entity.getX(), entity.getY(), entity.getZ())).is(new ResourceLocation("kraftmine:wasteland")) && world.getLevelData().isRaining()) {
			countdown = countdown + 1;
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem() && countdown == 20) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 1, 1));
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("acidrain").bypassArmor(), 1);
			} else {
				if (!(((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)).isEnchanted()
						&& EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.ANTIBAC.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0) && countdown == 60) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 1, 1));
					if (entity instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("acidrain").bypassArmor(), 1);
				} else {
					if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.ANTIBAC.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) < 2 && countdown == 200) {
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 1, 1));
						if (entity instanceof LivingEntity _entity)
							_entity.hurt(new DamageSource("acidrain").bypassArmor(), 1);
					}
				}
			}
		}
	}
}
