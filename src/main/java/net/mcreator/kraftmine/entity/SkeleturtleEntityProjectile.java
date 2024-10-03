
package net.mcreator.kraftmine.entity;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SkeleturtleEntityProjectile extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(KraftmineModItems.WATER_CHARGE.get());

	public SkeleturtleEntityProjectile(EntityType<? extends SkeleturtleEntityProjectile> type, Level world) {
		super(type, world);
	}

	public SkeleturtleEntityProjectile(EntityType<? extends SkeleturtleEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world, PROJECTILE_ITEM, null);
	}

	public SkeleturtleEntityProjectile(EntityType<? extends SkeleturtleEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world, PROJECTILE_ITEM, null);
	}

	@Override
	protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getDefaultPickupItem() {
		return new ItemStack(KraftmineModItems.WATER_CHARGE.get());
	}
}
