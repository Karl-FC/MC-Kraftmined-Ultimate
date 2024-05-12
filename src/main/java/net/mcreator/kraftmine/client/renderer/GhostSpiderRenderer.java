
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.kraftmine.entity.GhostSpiderEntity;

public class GhostSpiderRenderer extends MobRenderer<GhostSpiderEntity, SpiderModel<GhostSpiderEntity>> {
	public GhostSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new EyesLayer<GhostSpiderEntity, SpiderModel<GhostSpiderEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("kraftmine:textures/entities/ghost_spider_eyes.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(GhostSpiderEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/ghostspider.png");
	}
}
