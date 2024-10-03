
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.kraftmine.entity.AmongamiteEntity;

public class AmongamiteRenderer extends MobRenderer<AmongamiteEntity, SilverfishModel<AmongamiteEntity>> {
	public AmongamiteRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AmongamiteEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/amogus_silverfish.png");
	}
}
