
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.StoneSpearThrownEntity;
import net.mcreator.kraftmine.client.model.Modelstonespeardropped;

public class StoneSpearThrownRenderer extends MobRenderer<StoneSpearThrownEntity, Modelstonespeardropped<StoneSpearThrownEntity>> {
	public StoneSpearThrownRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstonespeardropped(context.bakeLayer(Modelstonespeardropped.LAYER_LOCATION)), 0.30000000000000004f);
	}

	@Override
	public ResourceLocation getTextureLocation(StoneSpearThrownEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/stonespear.png");
	}
}
