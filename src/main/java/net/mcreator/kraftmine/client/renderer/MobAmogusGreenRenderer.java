
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.MobAmogusGreenEntity;
import net.mcreator.kraftmine.client.model.ModelAmogus;

public class MobAmogusGreenRenderer extends MobRenderer<MobAmogusGreenEntity, ModelAmogus<MobAmogusGreenEntity>> {
	public MobAmogusGreenRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelAmogus(context.bakeLayer(ModelAmogus.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MobAmogusGreenEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/amogus_green.png");
	}
}
