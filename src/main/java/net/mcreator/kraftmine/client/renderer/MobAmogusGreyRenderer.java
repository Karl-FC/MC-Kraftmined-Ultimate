
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MobAmogusGreyEntity;
import net.mcreator.kraftmine.client.model.ModelAmogus;

public class MobAmogusGreyRenderer extends MobRenderer<MobAmogusGreyEntity, ModelAmogus<MobAmogusGreyEntity>> {
	public MobAmogusGreyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAmogus(context.bakeLayer(ModelAmogus.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobAmogusGreyEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/amogus_grey.png");
	}
}
