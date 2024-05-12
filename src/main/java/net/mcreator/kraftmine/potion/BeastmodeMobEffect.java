
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BeastmodeMobEffect extends MobEffect {
	public BeastmodeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066330);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.beastmode";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
