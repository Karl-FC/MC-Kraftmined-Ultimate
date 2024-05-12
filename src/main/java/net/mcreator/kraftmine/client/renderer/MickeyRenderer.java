
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MickeyEntity;
import net.mcreator.kraftmine.client.model.ModelMickey;

public class MickeyRenderer extends MobRenderer<MickeyEntity, ModelMickey<MickeyEntity>> {
	public MickeyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMickey(context.bakeLayer(ModelMickey.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MickeyEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/mickey.png");
	}
}
