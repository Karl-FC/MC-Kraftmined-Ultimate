
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MobAmogusBlueEntity;
import net.mcreator.kraftmine.client.model.ModelAmogus;

public class MobAmogusBlueRenderer extends MobRenderer<MobAmogusBlueEntity, ModelAmogus<MobAmogusBlueEntity>> {
	public MobAmogusBlueRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAmogus(context.bakeLayer(ModelAmogus.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobAmogusBlueEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/amogus_blue.png");
	}
}
