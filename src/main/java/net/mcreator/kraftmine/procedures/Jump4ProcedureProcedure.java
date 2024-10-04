package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;

public class Jump4ProcedureProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.JUMPSCARES) == true && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).JumpscareVariant == 4 && entity instanceof LivingEntity _livEnt1
				&& _livEnt1.hasEffect(KraftmineModMobEffects.JUMPSCARE_EFFECT)) {
			return true;
		}
		return false;
	}
}
