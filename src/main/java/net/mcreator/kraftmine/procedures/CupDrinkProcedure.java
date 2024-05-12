package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.network.KraftmineModVariables;

public class CupDrinkProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).AllowDrink == true
				&& (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel < 20) {
			{
				double _setval = (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).Thirstlevel + 5;
				entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Thirstlevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
