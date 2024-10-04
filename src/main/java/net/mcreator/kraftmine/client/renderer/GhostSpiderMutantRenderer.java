
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.GhostSpiderMutantEntity;
import net.mcreator.kraftmine.client.model.ModelMutantGhostSpider;

public class GhostSpiderMutantRenderer extends MobRenderer<GhostSpiderMutantEntity, ModelMutantGhostSpider<GhostSpiderMutantEntity>> {
	public GhostSpiderMutantRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelMutantGhostSpider(context.bakeLayer(ModelMutantGhostSpider.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(GhostSpiderMutantEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/ghostspider3.png");
	}
}
