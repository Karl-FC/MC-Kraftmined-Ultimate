
package net.mcreator.kraftmine.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.kraftmine.procedures.SaberhitProcedure;
import net.mcreator.kraftmine.procedures.SaberOffhandProcedure;
import net.mcreator.kraftmine.init.KraftmineModTabs;
import net.mcreator.kraftmine.init.KraftmineModItems;

public class DiamondsaberItem extends SwordItem {
	public DiamondsaberItem() {
		super(new Tier() {
			public int getUses() {
				return 2150;
			}

			public float getSpeed() {
				return 15f;
			}

			public float getAttackDamageBonus() {
				return 10f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 2;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(KraftmineModItems.REACTOR_CORE.get()));
			}
		}, 3, -1.5f, new Item.Properties().tab(KraftmineModTabs.TAB_CRTABCOMBAT).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		SaberhitProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		SaberOffhandProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}
