package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

public class ReactorCoreRecipebookProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level.isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("kraftmine:reactor_core")) == false) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BEACON)) : false) {
				if (entity instanceof ServerPlayer _serverPlayer)
					_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("kraftmine:reactor_core")});
			}
		}
	}
}
