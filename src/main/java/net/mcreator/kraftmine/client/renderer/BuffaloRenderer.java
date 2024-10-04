
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.BuffaloEntity;
import net.mcreator.kraftmine.client.model.Modelbuffalo;

public class BuffaloRenderer extends MobRenderer<BuffaloEntity, Modelbuffalo<BuffaloEntity>> {
	public BuffaloRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbuffalo(context.bakeLayer(Modelbuffalo.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BuffaloEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/bufalo.png");
	}
}
