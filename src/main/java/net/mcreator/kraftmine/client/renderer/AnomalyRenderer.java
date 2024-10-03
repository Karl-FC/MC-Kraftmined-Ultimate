
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.AnomalyEntity;
import net.mcreator.kraftmine.client.model.Modelanomaly;

public class AnomalyRenderer extends MobRenderer<AnomalyEntity, Modelanomaly<AnomalyEntity>> {
	public AnomalyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelanomaly(context.bakeLayer(Modelanomaly.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AnomalyEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/anomaly.png");
	}
}
