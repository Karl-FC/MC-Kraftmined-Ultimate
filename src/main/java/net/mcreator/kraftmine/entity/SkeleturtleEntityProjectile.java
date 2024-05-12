
package net.mcreator.kraftmine.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.network.protocol.Packet;

import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.init.KraftmineModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SkeleturtleEntityProjectile extends AbstractArrow implements ItemSupplier {
	public SkeleturtleEntityProjectile(PlayMessages.SpawnEntity packet, Level world) {
		super(KraftmineModEntities.SKELETURTLE_PROJECTILE.get(), world);
	}

	public SkeleturtleEntityProjectile(EntityType<? extends SkeleturtleEntityProjectile> type, Level world) {
		super(type, world);
	}

	public SkeleturtleEntityProjectile(EntityType<? extends SkeleturtleEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public SkeleturtleEntityProjectile(EntityType<? extends SkeleturtleEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(KraftmineModItems.WATER_CHARGE.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(KraftmineModItems.WATER_CHARGE.get());
	}
}
