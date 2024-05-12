
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AntiHealMobEffect extends MobEffect {
	public AntiHealMobEffect() {
		super(MobEffectCategory.HARMFUL, -6724096);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.anti_heal";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
