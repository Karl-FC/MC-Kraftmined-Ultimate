
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

import net.mcreator.kraftmine.entity.JockeyTowerEntity;

public class JockeyTowerRenderer extends MobRenderer<JockeyTowerEntity, ChickenModel<JockeyTowerEntity>> {
	public JockeyTowerRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(JockeyTowerEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/pato.png");
	}
}
