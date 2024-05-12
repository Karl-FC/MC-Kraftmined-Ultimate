
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.IceologerEntity;
import net.mcreator.kraftmine.client.model.Modeliceologer;

public class IceologerRenderer extends MobRenderer<IceologerEntity, Modeliceologer<IceologerEntity>> {
	public IceologerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeliceologer(context.bakeLayer(Modeliceologer.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(IceologerEntity entity) {
		return new ResourceLocation("kraftmine:textures/entities/t_chillager.png");
	}
}
