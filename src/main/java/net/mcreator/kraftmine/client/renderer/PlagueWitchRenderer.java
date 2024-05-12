
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.WitchModel;

import net.mcreator.kraftmine.entity.PlagueWitchEntity;

public class PlagueWitchRenderer extends MobRenderer<PlagueWitchEntity, WitchModel<PlagueWitchEntity>> {
	public PlagueWitchRenderer(EntityRendererProvider.Context context) {
		super(context, new WitchModel(context.bakeLayer(ModelLayers.WITCH)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PlagueWitchEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/scp_049.png");
	}
}
