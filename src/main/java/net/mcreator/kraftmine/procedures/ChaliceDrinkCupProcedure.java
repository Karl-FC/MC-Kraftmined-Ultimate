package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.network.KraftmineModVariables;

public class ChaliceDrinkCupProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).AllowDrink == true && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel < 20) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.Thirstlevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel + 10;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
