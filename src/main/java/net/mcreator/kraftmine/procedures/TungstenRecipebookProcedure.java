package net.mcreator.kraftmine.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

import java.util.Collections;

public class TungstenRecipebookProcedure {
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
		}.hasRecipe(entity, ResourceLocation.parse("kraftmine:tungsten_block")) == false) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(KraftmineModItems.TUNGSTEN_INGOT.get())) : false) {
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_blade")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_sword")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_shovel")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_axe")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_hoe")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_pickaxe")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_block")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_armor_helmet")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_armor_chestplate")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_armor_leggings")));
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("kraftmine:tungsten_armor_boots")));
			}
		}
	}
}
