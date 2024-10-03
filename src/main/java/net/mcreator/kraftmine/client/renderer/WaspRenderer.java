
package net.mcreator.kraftmine.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.kraftmine.entity.WaspEntity;
import net.mcreator.kraftmine.client.model.Modelwasp;

public class WaspRenderer extends MobRenderer<WaspEntity, Modelwasp<WaspEntity>> {
	public WaspRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwasp(context.bakeLayer(Modelwasp.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(WaspEntity entity) {
		return ResourceLocation.parse("kraftmine:textures/entities/wasp.png");
	}
}
