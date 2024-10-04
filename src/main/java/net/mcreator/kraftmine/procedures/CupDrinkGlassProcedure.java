package net.mcreator.kraftmine.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.kraftmine.network.KraftmineModVariables;

public class CupDrinkGlassProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(KraftmineModVariables.PLAYER_VARIABLES).AllowDrink == true && entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel < 20) {
			{
				KraftmineModVariables.PlayerVariables _vars = entity.getData(KraftmineModVariables.PLAYER_VARIABLES);
				_vars.Thirstlevel = entity.getData(KraftmineModVariables.PLAYER_VARIABLES).Thirstlevel + 3;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 1, false, false));
		}
	}
}
