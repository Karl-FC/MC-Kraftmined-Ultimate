
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ThirstyMobEffect extends MobEffect {
	public ThirstyMobEffect() {
		super(MobEffectCategory.HARMFUL, -10066432);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.thirsty";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
