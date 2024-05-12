
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RefreshedMobEffect extends MobEffect {
	public RefreshedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13395457);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.hydrated";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
