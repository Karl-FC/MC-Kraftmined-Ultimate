
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.GooseEntity;
import net.mcreator.kraftmine.client.model.ModelGoose;

public class GooseRenderer extends MobRenderer<GooseEntity, ModelGoose<GooseEntity>> {
	public GooseRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGoose(context.bakeLayer(ModelGoose.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GooseEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/goosetexture.png");
	}
}
