
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.IronSpearEntityEntity;
import net.mcreator.kraftmine.client.model.Modelstonespeardropped;

public class IronSpearEntityRenderer extends MobRenderer<IronSpearEntityEntity, Modelstonespeardropped<IronSpearEntityEntity>> {
	public IronSpearEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelstonespeardropped(context.bakeLayer(Modelstonespeardropped.LAYER_LOCATION)), 0.30000000000000004f);
	}

	@Override
	public ResourceLocation getTextureLocation(IronSpearEntityEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/stonespear.png");
	}
}
