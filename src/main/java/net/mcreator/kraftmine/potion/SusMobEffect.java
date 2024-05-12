
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SusMobEffect extends MobEffect {
	public SusMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.sus";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
