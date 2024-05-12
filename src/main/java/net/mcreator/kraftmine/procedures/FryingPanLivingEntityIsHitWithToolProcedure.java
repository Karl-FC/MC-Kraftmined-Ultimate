package net.mcreator.kraftmine.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.kraftmine.init.KraftmineModEnchantments;

public class FryingPanLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!(itemstack).isEnchanted()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 1), (entity.getDeltaMovement().z() * 2)));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack) != 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.BLOCKS,
							(float) (1 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)), 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.BLOCKS,
							(float) (1 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)), 1, false);
				}
			}
			if ((sourceentity.getDirection()) == Direction.NORTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 1 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)),
						((entity.getDeltaMovement().z() + 3 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)) * (-1))));
			} else if ((sourceentity.getDirection()) == Direction.SOUTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 1 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)),
						(entity.getDeltaMovement().z() + 3 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack))));
			} else if ((sourceentity.getDirection()) == Direction.EAST) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + 3 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)),
						(entity.getDeltaMovement().y() + 1 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)), (entity.getDeltaMovement().z())));
			} else if ((sourceentity.getDirection()) == Direction.WEST) {
				entity.setDeltaMovement(new Vec3(((entity.getDeltaMovement().x() + 3 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)) * (-1)),
						(entity.getDeltaMovement().y() + 1 + EnchantmentHelper.getItemEnchantmentLevel(KraftmineModEnchantments.DYING_PAN.get(), itemstack)), (entity.getDeltaMovement().z())));
			}
		}
	}
}
