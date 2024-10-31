
package net.mcreator.kraftmined.unplayable.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmined.unplayable.entity.GooseEntity;
import net.mcreator.kraftmined.unplayable.client.model.ModelGoose;

public class GooseRenderer extends MobRenderer<GooseEntity, ModelGoose<GooseEntity>> {
	public GooseRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGoose(context.bakeLayer(ModelGoose.LAYER_LOCATION)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GooseEntity entity) {
		return ResourceLocation.parse("km_unplayable:textures/entities/goose.png");
	}
}
