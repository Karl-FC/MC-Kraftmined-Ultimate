
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.GiantAIEntity;
import net.mcreator.kraftmine.client.model.Modelgiant_ai;

public class GiantAIRenderer extends MobRenderer<GiantAIEntity, Modelgiant_ai<GiantAIEntity>> {
	public GiantAIRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelgiant_ai(context.bakeLayer(Modelgiant_ai.LAYER_LOCATION)), 5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantAIEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/giant_2.png");
	}
}
