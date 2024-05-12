
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.GeneralEntity;
import net.mcreator.kraftmine.client.model.Modelgeneral;

public class GeneralRenderer extends MobRenderer<GeneralEntity, Modelgeneral<GeneralEntity>> {
	public GeneralRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgeneral(context.bakeLayer(Modelgeneral.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(GeneralEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/general.png");
	}
}
