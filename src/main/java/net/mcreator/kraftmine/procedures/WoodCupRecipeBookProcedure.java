package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

import java.util.Collections;

public class WoodCupRecipeBookProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, ResourceLocation.parse("kraftmine:wood_cup_recipe")) == false) {
			if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.OAK_LOG)) : false)
					|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.ACACIA_LOG)) : false)) {
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:wood_cup_recipe")));
			}
		}
	}
}
