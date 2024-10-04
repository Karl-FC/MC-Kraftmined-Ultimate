
package net.mcreator.kraftmine.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class NoUMobEffect extends MobEffect {
	public NoUMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -256);
	}
}
