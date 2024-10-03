
package net.mcreator.kraftmine.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.kraftmine.init.KraftmineModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class JumpscareEffectMobEffect extends MobEffect {
	public JumpscareEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, KraftmineModMobEffects.JUMPSCARE_EFFECT.get());
	}
}
