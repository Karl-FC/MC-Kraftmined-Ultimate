package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class WoodenBatLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double chance = 0;
		if (itemstack.is(ItemTags.create(new ResourceLocation("kraftmine:bashing_weapons")))) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				chance = chance + 15;
			}
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				chance = chance + 15;
			}
			if (Math.random() <= chance) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 200, (false), (true)));
			}
		}
	}
}
