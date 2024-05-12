
package net.mcreator.kraftmine.potion;

import net.minecraftforge.client.extensions.common.IClientMobEffectExtensions;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class EyepatchOnEffectMobEffect extends MobEffect {
	public EyepatchOnEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -39169);
	}

	@Override
	public String getDescriptionId() {
		return "effect.kraftmine.eyepatch_on_effect";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void initializeClient(java.util.function.Consumer<IClientMobEffectExtensions> consumer) {
		consumer.accept(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		});
	}
}
