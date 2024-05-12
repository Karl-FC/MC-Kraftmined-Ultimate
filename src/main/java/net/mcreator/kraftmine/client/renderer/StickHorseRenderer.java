
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.StickHorseEntity;
import net.mcreator.kraftmine.client.model.Modelstick_horse;

public class StickHorseRenderer extends MobRenderer<StickHorseEntity, Modelstick_horse<StickHorseEntity>> {
	public StickHorseRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstick_horse(context.bakeLayer(Modelstick_horse.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StickHorseEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/bufalo.png");
	}
}
