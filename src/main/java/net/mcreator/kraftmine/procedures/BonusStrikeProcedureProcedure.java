package net.mcreator.kraftmine.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BonusStrikeProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		double punch = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BONUS_STRIKE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0 && immediatesourceentity instanceof Arrow) {
			if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BONUS_STRIKE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 4) {
				punch = 0;
				if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					punch = 1 + EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 3;
				}
				if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
					{
						Entity _shootFrom = sourceentity;
						Level projectileLevel = _shootFrom.level;
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSecondsOnFire(100);
									entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity,
									(float) (amount * 0.01
											* (10 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BONUS_STRIKE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 5)),
									(int) punch);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else {
					{
						Entity _shootFrom = sourceentity;
						Level projectileLevel = _shootFrom.level;
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, sourceentity,
									(float) (amount * 0.01
											* (10 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BONUS_STRIKE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 5)),
									(int) punch);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			} else {
				{
					Entity _shootFrom = sourceentity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, sourceentity,
								(float) (amount * 0.01 * (10 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.BONUS_STRIKE.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 5)),
								1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
