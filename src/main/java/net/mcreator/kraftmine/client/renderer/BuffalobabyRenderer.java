
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.BuffalobabyEntity;
import net.mcreator.kraftmine.client.model.Modelbuffalo_baby;

public class BuffalobabyRenderer extends MobRenderer<BuffalobabyEntity, Modelbuffalo_baby<BuffalobabyEntity>> {
	public BuffalobabyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbuffalo_baby(context.bakeLayer(Modelbuffalo_baby.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(BuffalobabyEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/bufalo.png");
	}
}
