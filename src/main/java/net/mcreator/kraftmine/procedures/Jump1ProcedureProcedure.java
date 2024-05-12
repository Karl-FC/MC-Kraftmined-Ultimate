package net.mcreator.kraftmine.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.kraftmine.network.KraftmineModVariables;
import net.mcreator.kraftmine.init.KraftmineModMobEffects;
import net.mcreator.kraftmine.init.KraftmineModGameRules;

public class Jump1ProcedureProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (world.getLevelData().getGameRules().getBoolean(KraftmineModGameRules.JUMPSCARES) == true
				&& (entity.getCapability(KraftmineModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new KraftmineModVariables.PlayerVariables())).JumpscareVariant == 1
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(KraftmineModMobEffects.JUMPSCARE_EFFECT.get()) : false)) {
			return true;
		}
		return false;
	}
}
