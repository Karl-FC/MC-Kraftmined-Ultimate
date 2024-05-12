
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.GhastModel;

import net.mcreator.kraftmine.entity.GiantSquidEntity;

public class GiantSquidRenderer extends MobRenderer<GiantSquidEntity, GhastModel<GiantSquidEntity>> {
	public GiantSquidRenderer(EntityRendererProvider.Context context) {
		super(context, new GhastModel(context.bakeLayer(ModelLayers.GHAST)), 3f);
	}

	@Override
	public ResourceLocation getTextureLocation(GiantSquidEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/squid_ghast.png");
	}
}
