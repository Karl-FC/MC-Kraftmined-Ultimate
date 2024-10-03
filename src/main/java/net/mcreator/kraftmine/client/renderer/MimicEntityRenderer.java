
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MimicEntityEntity;
import net.mcreator.kraftmine.client.model.ModelMimic;

public class MimicEntityRenderer extends MobRenderer<MimicEntityEntity, ModelMimic<MimicEntityEntity>> {
	public MimicEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMimic(context.bakeLayer(ModelMimic.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(MimicEntityEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/mimic.png");
	}
}
