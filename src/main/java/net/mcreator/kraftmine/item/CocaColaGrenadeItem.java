
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.kraftmine.procedures.CocaColaGrenadeRangedItemUsedProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;
import net.mcreator.kraftmine.entity.CocaColaGrenadeEntity;

public class CocaColaGrenadeItem extends Item {
	public CocaColaGrenadeItem() {
		super(new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).stacksTo(64));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.NONE;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public void onUsingTick(ItemStack itemstack, LivingEntity entityLiving, int count) {
		Level world = entityLiving.level;
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (true) {
				ItemStack stack = ProjectileWeaponItem.getHeldProjectile(entity, e -> e.getItem() == KraftmineModItems.COCA_COLA_GRENADE.get());
				if (stack == ItemStack.EMPTY) {
					for (int i = 0; i < entity.getInventory().items.size(); i++) {
						ItemStack teststack = entity.getInventory().items.get(i);
						if (teststack != null && teststack.getItem() == KraftmineModItems.COCA_COLA_GRENADE.get()) {
							stack = teststack;
							break;
						}
					}
				}
				if (entity.getAbilities().instabuild || stack != ItemStack.EMPTY) {
					CocaColaGrenadeEntity entityarrow = CocaColaGrenadeEntity.shoot(world, entity, world.getRandom(), 0.8f, 3, 1);
					itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
					if (entity.getAbilities().instabuild) {
						entityarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					} else {
						if (new ItemStack(KraftmineModItems.COCA_COLA_GRENADE.get()).isDamageableItem()) {
							if (stack.hurt(1, world.getRandom(), entity)) {
								stack.shrink(1);
								stack.setDamageValue(0);
								if (stack.isEmpty())
									entity.getInventory().removeItem(stack);
							}
						} else {
							stack.shrink(1);
							if (stack.isEmpty())
								entity.getInventory().removeItem(stack);
						}
					}
					CocaColaGrenadeRangedItemUsedProcedure.execute(entity, itemstack);
				}
				entity.releaseUsingItem();
			}
		}
	}
}
