
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class NoUMobEffect extends MobEffect {
	public NoUMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -256);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.no_u";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
