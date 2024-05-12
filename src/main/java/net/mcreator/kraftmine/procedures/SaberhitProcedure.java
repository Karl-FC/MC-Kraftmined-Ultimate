package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;
import net.mcreator.kraftmine.KraftmineMod;

import java.util.Comparator;

public class SaberhitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:attack.saber")), SoundSource.PLAYERS, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:attack.saber")), SoundSource.PLAYERS, 2, 1, false);
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:lightsabers")))) {
			if ((EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SABER_SWING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
					|| EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SABER_SWING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0)
					&& !world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(
							(sourceentity.level.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
									.getBlockPos().getX()),
							(2 + sourceentity.level.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
									.getBlockPos().getY()),
							(sourceentity.level.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
									.getBlockPos().getZ())),
							3, 3, 3), e -> true).isEmpty()) {
				if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SABER_SWING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					KraftmineMod.queueServerWork((int) (20 - EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SABER_SWING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 5),
							() -> {
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.OFF_HAND, true);
								{
									ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (((Entity) world.getEntitiesOfClass(Mob.class,
										AABB.ofSize(new Vec3((sourceentity.level
												.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
												.getBlockPos().getX()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getY()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getZ())),
												3, 3, 3),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((sourceentity.level
												.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
												.getBlockPos().getX()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getY()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) instanceof Mob) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:attack.saber")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, 5));
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:attack.saber")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, 5), false);
										}
									}
								}
							});
				} else if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SABER_SWING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) {
					KraftmineMod.queueServerWork((int) (15 - EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.SABER_SWING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) * 5),
							() -> {
								if (sourceentity instanceof LivingEntity _entity)
									_entity.swing(InteractionHand.OFF_HAND, true);
								{
									ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
									if (_ist.hurt(1, RandomSource.create(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
								if (((Entity) world.getEntitiesOfClass(Mob.class,
										AABB.ofSize(new Vec3((sourceentity.level
												.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
												.getBlockPos().getX()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getY()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getZ())),
												3, 3, 3),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf((sourceentity.level
												.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
												.getBlockPos().getX()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getY()),
												(sourceentity.level.clip(
														new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sourceentity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) instanceof Mob) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:attack.saber")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, 5));
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("kraftmine:attack.saber")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, 5), false);
										}
									}
								}
							});
				}
				if ((EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == false
						|| (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SMITE, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == false
						|| (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == false) {
					entity.hurt(DamageSource.GENERIC, 12);
				} else if ((EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == true) {
					entity.hurt(DamageSource.GENERIC, (float) (12 + EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) * 0.5 + 0.5));
				} else if ((EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SMITE, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == true
						&& entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:undead")))) {
					entity.hurt(DamageSource.GENERIC, (float) (12 + EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SMITE, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) * 2.5));
				} else if ((EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == true
						&& entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:arthropod")))) {
					entity.hurt(DamageSource.GENERIC, (float) (12 + EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) * 2.5));
				}
				if ((EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == false) {
					{
						ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				} else if ((EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) == true) {
					if (Math.random() < (100 / (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) + 1)) / 100) {
						{
							ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
			}
		}
	}
}
