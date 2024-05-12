
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ConfusionMobEffect extends MobEffect {
	public ConfusionMobEffect() {
		super(MobEffectCategory.HARMFUL, -4836);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.confusion";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
