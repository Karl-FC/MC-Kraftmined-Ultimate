package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;

public class DashConditionsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).IsDashing == false && entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(KraftmineModMobEffects.BEASTMODE)) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.ThirstExhaustionLevel = 0;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).IsDashing == false && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel > 4) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.Thirstlevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel - entity.getData(KraftmineModVariables.PLAYER_VARIABLES).DashStamina;
				_vars.syncPlayerVariables(entity);
			}
		}
		return true;
	}
}
