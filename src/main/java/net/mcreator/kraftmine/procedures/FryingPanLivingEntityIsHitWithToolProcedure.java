package net.mcreator.kraftmine.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FryingPanLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (!itemstack.isEnchanted()) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() * 1), (entity.getDeltaMovement().z() * 2)));
		} else if (itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan")))) != 0) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.BLOCKS,
							(float) (1 + itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))), 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.place")), SoundSource.BLOCKS,
							(float) (1 + itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))), 1, false);
				}
			}
			if ((sourceentity.getDirection()) == Direction.NORTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()),
						(entity.getDeltaMovement().y() + 1
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))),
						((entity.getDeltaMovement().z() + 3
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))) * (-1))));
			} else if ((sourceentity.getDirection()) == Direction.SOUTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()),
						(entity.getDeltaMovement().y() + 1
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))),
						(entity.getDeltaMovement().z() + 3
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan")))))));
			} else if ((sourceentity.getDirection()) == Direction.EAST) {
				entity.setDeltaMovement(new Vec3(
						(entity.getDeltaMovement().x() + 3
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))),
						(entity.getDeltaMovement().y() + 1
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))),
						(entity.getDeltaMovement().z())));
			} else if ((sourceentity.getDirection()) == Direction.WEST) {
				entity.setDeltaMovement(new Vec3(
						((entity.getDeltaMovement().x() + 3
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))) * (-1)),
						(entity.getDeltaMovement().y() + 1
								+ itemstack.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("kraftmine:dying_pan"))))),
						(entity.getDeltaMovement().z())));
			}
		}
	}
}
